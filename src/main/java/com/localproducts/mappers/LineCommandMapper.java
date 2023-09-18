package com.localproducts.mappers;

import com.localproducts.dto.lineCommandDto.LineCommandResponse;
import com.localproducts.entities.LineCommand;

public class LineCommandMapper {
    public static LineCommandResponse lineCommandToLineCommandResponse(LineCommand lineCommand) {
        return LineCommandResponse.builder()
                .id(lineCommand.getId())
                .cooperativeName(lineCommand.getProduct().getCooperative().getName())
                .productId(lineCommand.getProduct().getId())
                .productName(lineCommand.getProduct().getName())
                .description(lineCommand.getProduct().getDescription())
                .categoryLabel(lineCommand.getProduct().getCategory().getLabel())
                .build();
    }
}
