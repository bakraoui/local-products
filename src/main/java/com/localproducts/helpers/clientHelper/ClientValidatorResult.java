package com.localproducts.helpers.clientHelper;

import lombok.Getter;

@Getter
public enum ClientValidatorResult {
    USERNAME_NOT_VALID("Username Not Valid"),
    PASSWORD_NOT_VALID("Password Not Valid"),
    ADDRESS_NOT_VALID("Address Not Valid"),
    NAME_NOT_VALID("Name Not Valid"),
    SUCCESS("Client Inputs are Valid.");

    private final String message;


    ClientValidatorResult(String message) {
        this.message = message;
    }

}
