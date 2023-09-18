package com.localproducts.helpers.clientHelper;

import com.localproducts.dto.clientDto.CreateClientRequest;

import java.util.function.Function;

public interface CreateClientRequestHandler extends Function<CreateClientRequest, ClientValidatorResult> {

    static CreateClientRequestHandler isUsernameValid() {
        return request -> request.getUsername().isEmpty() ? ClientValidatorResult.USERNAME_NOT_VALID : ClientValidatorResult.SUCCESS;
    }

    static CreateClientRequestHandler isPasswordValid() {
        return request -> request.getPassword().isEmpty() ? ClientValidatorResult.PASSWORD_NOT_VALID : ClientValidatorResult.SUCCESS;
    }

    static CreateClientRequestHandler isAddressValid() {
        return request -> request.getAddress().isEmpty() ? ClientValidatorResult.ADDRESS_NOT_VALID : ClientValidatorResult.SUCCESS;
    }

    static CreateClientRequestHandler isNameValid() {
        return request -> request.getName().isEmpty() ? ClientValidatorResult.NAME_NOT_VALID : ClientValidatorResult.SUCCESS;
    }

    default CreateClientRequestHandler and (CreateClientRequestHandler other) {
        return request -> {
            ClientValidatorResult result = this.apply(request);
            return result.equals(ClientValidatorResult.SUCCESS) ? other.apply(request) : result;
        };
    }
}
