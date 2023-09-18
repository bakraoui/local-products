package com.localproducts.helpers.adminHelper;

import com.localproducts.dto.adminDto.CreateAdminRequest;

import java.util.function.Function;

public interface CreateAdminRequestHandler extends Function<CreateAdminRequest, AdminValidatorResult> {

    static CreateAdminRequestHandler isUsernameValid() {
        return request -> request.getUsername().isEmpty() ? AdminValidatorResult.USERNAME_NOT_VALID : AdminValidatorResult.SUCCESS;
    }

    static CreateAdminRequestHandler isPasswordValid() {
        return request -> request.getPassword().isEmpty() ? AdminValidatorResult.PASSWORD_NOT_VALID : AdminValidatorResult.SUCCESS;
    }

    static CreateAdminRequestHandler isAddressValid() {
        return request -> request.getAddress().isEmpty() ? AdminValidatorResult.ADDRESS_NOT_VALID : AdminValidatorResult.SUCCESS;
    }

    static CreateAdminRequestHandler isNameValid() {
        return request -> request.getName().isEmpty() ? AdminValidatorResult.NAME_NOT_VALID : AdminValidatorResult.SUCCESS;
    }

    default CreateAdminRequestHandler and (CreateAdminRequestHandler other) {
        return request -> {
            AdminValidatorResult result = this.apply(request);
            return result.equals(AdminValidatorResult.SUCCESS) ? other.apply(request) : result;
        };
    }
}
