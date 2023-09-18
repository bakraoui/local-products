package com.localproducts.service.Implementation;

import com.localproducts.dto.cooperativeDto.CooperativeResponse;
import com.localproducts.dto.cooperativeDto.CreateCooperativeRequest;
import com.localproducts.entities.Region;
import com.localproducts.exceptions.RecordNotExistException;
import com.localproducts.mappers.CooperativeMapper;
import com.localproducts.repositories.RegionRepository;
import com.localproducts.security.AppRole;
import com.localproducts.security.service.AppRoleRepository;
import com.localproducts.entities.Cooperative;
import com.localproducts.repositories.CooperativeRepository;
import com.localproducts.service.Interfaces.ICooperativeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class CooperativeService implements ICooperativeService {

    private final CooperativeRepository cooperativeRepository;
    private final AppRoleRepository appRoleRepository;
    private final RegionRepository regionRepository;

    public CooperativeService(CooperativeRepository cooperativeRepository, AppRoleRepository appRoleRepository, RegionRepository regionRepository) {
        this.cooperativeRepository = cooperativeRepository;
        this.appRoleRepository = appRoleRepository;
        this.regionRepository = regionRepository;
    }


    public void save(CreateCooperativeRequest request){
        //TODO Input validation: can create Validators as we did for Admin, Client, Category

        checkIfCooperativeExist(request.getName());

        Set<AppRole> roles = createCooperativeRoles();

        List<Region> regions = getRegionsFromIds(request.getRegions());

        Cooperative cooperative = CooperativeMapper.cooperativeRequestToCooperative(request, roles, regions);

        cooperativeRepository.save(cooperative);

    }


    // get all cooperative
    public List<CooperativeResponse> getAll(){
        List<Cooperative> cooperatives =  cooperativeRepository.findAll();

        return  cooperatives.stream()
                .map(CooperativeMapper::cooperativeTocooperativeResponse)
                .collect(Collectors.toList());

    }

    @Override
    public CooperativeResponse getCooperative(Long id){
        Cooperative cooperative =  cooperativeRepository.findById(id)
                .stream().findFirst().orElseThrow(() -> new RecordNotExistException("No cooperative with the given Id"));
        return CooperativeMapper.cooperativeTocooperativeResponse(cooperative);

    }

    // delete cooperative
    @Override
    public void deleteCooperative(Long id){
        Optional<Cooperative> cooperative = cooperativeRepository.findById(id);
        if (cooperative.isPresent()) cooperativeRepository.deleteById(id);
        else throw new IllegalStateException("Cooperative not found");
    }

    @Override
    public void update(Cooperative cooperative) {
        Optional<Cooperative> cooperative1 = cooperativeRepository.findByName(cooperative.getName());
        if (cooperative1.isPresent()) throw new IllegalStateException("This name already token. change t");
        else cooperativeRepository.save(cooperative);
    }

    private void checkIfCooperativeExist(String name) {
        Optional<Cooperative> cooperativeOptional = cooperativeRepository.findByName(name);
        if (cooperativeOptional.isPresent()) throw new IllegalStateException("Cooperative already exist");
    }

    private Set<AppRole> createCooperativeRoles() {
        AppRole role = createCooperativeRoleIfNotExist();
        Set<AppRole> roles = new HashSet<>();
        roles.add(role);
        return roles;
    }

    private AppRole createCooperativeRoleIfNotExist() {
        Optional<AppRole> cooperativeRole = appRoleRepository.findByName("COOPERATIVE") ;
        if (cooperativeRole.isPresent()) {
            return cooperativeRole.get();
        }

        AppRole role = new AppRole();
        role.setName("COOPERATIVE");
        return appRoleRepository.save(role);

    }

    private List<Region> getRegionsFromIds(List<Long> ids) {
        return ids.stream()
                .map(id -> {
                    Optional<Region> region = regionRepository.findById(id);
                    return region.orElse(null);
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
