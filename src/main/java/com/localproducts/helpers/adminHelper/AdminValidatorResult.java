package com.localproducts.helpers.adminHelper;

import lombok.Getter;

@Getter
public enum AdminValidatorResult {

    USERNAME_NOT_VALID("Username Not Valid"),
    PASSWORD_NOT_VALID("Password Not Valid"),
    ADDRESS_NOT_VALID("Address Not Valid"),
    NAME_NOT_VALID("Name Not Valid"),
    SUCCESS("Admin Inputs are Valid.");

    private final String message;

    AdminValidatorResult(String message) {
        this.message = message;
    }

}
