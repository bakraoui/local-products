package com.localproducts.mappers;

import com.localproducts.dto.commandDto.CommandResponse;
import com.localproducts.entities.Command;

public class CommandMapper {
    public static CommandResponse commandToCommandResponse(Command command) {
        return CommandResponse.builder()
                .id(command.getId())
                .isPayed(command.isPayed())

                .clientId(command.getClient().getId())
                .clientName(command.getClient().getName())
                .clientAddress(command.getClient().getAddress())

                .cooperativeId(command.getCooperative().getId())
                .cooperativeName(command.getCooperative().getName())
                .build();
    }
}
