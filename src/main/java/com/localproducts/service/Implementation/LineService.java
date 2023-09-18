package com.localproducts.service.Implementation;

import com.localproducts.dto.lineCommandDto.LineCommandResponse;
import com.localproducts.entities.Command;
import com.localproducts.entities.LineCommand;
import com.localproducts.entities.Product;
import com.localproducts.exceptions.RecordNotExistException;
import com.localproducts.mappers.LineCommandMapper;
import com.localproducts.repositories.CommandRepository;
import com.localproducts.repositories.LineCommandRepository;
import com.localproducts.repositories.ProductRepository;
import com.localproducts.service.Interfaces.ILineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineService implements ILineService {

    private final LineCommandRepository lineCommandRepository;
    private final ProductRepository productRepository;
    private final CommandRepository commandRepository;

    public LineService(LineCommandRepository lineCommandRepository, ProductRepository productRepository, CommandRepository commandRepository) {
        this.lineCommandRepository = lineCommandRepository;
        this.productRepository = productRepository;
        this.commandRepository = commandRepository;
    }

    @Override
    public void create(LineCommand line) {

        //TODO: validate inputs

        //TODO: check if records already exist or not

        lineCommandRepository.save(line);
    }

    @Override
    public void delete(LineCommand line) {
        lineCommandRepository.delete(line);
    }

    @Override
    public void deleteById(Long id) {
        lineCommandRepository.deleteById(id);
    }

    @Override
    public LineCommandResponse findById(Long id) {
        LineCommand lineCommand = lineCommandRepository.findById(id)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("Line not found"));
        return LineCommandMapper.lineCommandToLineCommandResponse(lineCommand);
    }



    @Override
    public List<LineCommandResponse> findByProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("Product Not Found."));

        List<LineCommand> lineCommands = lineCommandRepository.findByProduct(product);

        return lineCommands.stream()
                .map(LineCommandMapper::lineCommandToLineCommandResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<LineCommandResponse> findByCommand(Long commandId) {
        Command command = commandRepository.findById(commandId)
                .stream().findFirst()
                .orElseThrow(() -> new RecordNotExistException("Command Not Found."));
        List<LineCommand> lineCommands =  lineCommandRepository.findByCommand(command);

        return lineCommands.stream()
                .map(LineCommandMapper::lineCommandToLineCommandResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void update(LineCommand lineCommand) {
        lineCommandRepository.save(lineCommand);
    }
}
