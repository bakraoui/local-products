package com.example.demo.service.Implementation;

import com.example.demo.configuration.security.AppRole;
import com.example.demo.configuration.security.service.AppRoleRepository;
import com.example.demo.dto.CooperativeDto;
import com.example.demo.dto.ProduitDto;
import com.example.demo.dto.ToDto;
import com.example.demo.entities.Cooperative;
import com.example.demo.repositories.CooperativeRepository;
import com.example.demo.service.Interfaces.CooperativeInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class CooperativeImp implements CooperativeInterface {

    @Autowired
    CooperativeRepository cooperativeRepository;
    @Autowired
    AppRoleRepository appRoleRepository;


    // add one cooperative
    @Override
    public void addCooperative(Cooperative cooperative){
        Optional<Cooperative> coop = cooperativeRepository.findByName(cooperative.getName());
        if (coop.isPresent()) throw new IllegalStateException("Cooperative already exist");
        else{
            AppRole cooperativeRole = appRoleRepository.findByName("COOPERATIVE") ;
            if (cooperativeRole == null) {

                cooperativeRole = new AppRole();
                cooperativeRole.setName("COOPERATIVE");
                appRoleRepository.save(cooperativeRole);
                System.out.println(555555l);
                
                cooperativeRole = appRoleRepository.findByName("COOPERATIVE");
            }
            Set<AppRole> appRole = cooperative.getAppUser().getRoles();
            appRole.add(cooperativeRole);
            cooperative.getAppUser().setRoles(appRole);

            cooperativeRepository.save(cooperative );
        }
    }

    // add list of cooperatives
    @Override
    public void addCooperatives(Cooperative ...cooperatives){
        int i=0;
        for (Cooperative cooperative: cooperatives ) {
            Optional<Cooperative> coop = cooperativeRepository.findByName(cooperative.getName());

            if (coop.isPresent())   i++;
            else    cooperativeRepository.save(cooperative);
        }
        if (i != 0) throw new IllegalStateException(" already Exist in database.");
    }

    // get all cooperative
    public List<CooperativeDto> getAll(){
        List<Cooperative> cooperatives =  cooperativeRepository.findAll();
        List<CooperativeDto> cooperativeDtos = new ArrayList<>();

        for (Cooperative cooperative:cooperatives) {
            cooperativeDtos.add(ToDto.toCooperativeDto(cooperative));
        }
        return cooperativeDtos;
    }

    // get cooperative with given Id
    @Override
    public CooperativeDto getCooperative(long id){
        Cooperative cooperative =  cooperativeRepository.findById(id)
                .stream().findFirst().orElse(null);

        return ToDto.toCooperativeDto(cooperative);

    }

    // get cooperatives By region
    @Override
    public List<CooperativeDto> FilterByRegion(String regionName) {
        List<Cooperative> cooperatives = cooperativeRepository.findByRegions_Name(regionName);
        List<CooperativeDto> cooperativeDtos = new ArrayList<>();

        for (Cooperative cooperative:cooperatives) {
            cooperativeDtos.add(ToDto.toCooperativeDto(cooperative));
        }

        return cooperativeDtos;
    }

    // delete cooperative
    @Override
    public void deleteCooperative(Long id){
        Optional<Cooperative> cooperative = cooperativeRepository.findById(id);
        if (cooperative.isPresent()) cooperativeRepository.deleteById(id);
        else throw new IllegalStateException("Cooperative not found");
    }

    // Get cooperative By Name
    @Override
    public CooperativeDto getCooperativeByName(String name) {
        Cooperative cooperative =  cooperativeRepository.findByName(name)
                .stream().findFirst().orElse(null);

        return ToDto.toCooperativeDto(cooperative);
    }

    // get coopeartive by part of its name
    @Override
    public List<CooperativeDto> getCooperativeByNameContaining(String name) {

        List<Cooperative> cooperatives =  cooperativeRepository.findByNameContaining(name);

        List<CooperativeDto> cooperativeDtos = new ArrayList<>();

        for (Cooperative cooperative:cooperatives) {
            cooperativeDtos.add(ToDto.toCooperativeDto(cooperative));
        }

        return cooperativeDtos;
    }

    @Override
    public void update(Cooperative cooperative) {
        Optional<Cooperative> cooperative1 = cooperativeRepository.findByName(cooperative.getName());
        if (cooperative1.isPresent()) throw new IllegalStateException("This name already token. change t");
        else cooperativeRepository.save(cooperative);
    }


}
