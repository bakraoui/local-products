package com.localproducts.helpers.categoryHelpers;

import lombok.Getter;

@Getter
public enum CategoryValidatorResult {
    LABEL_NOT_VALID("Label Name not Valid"),
    SUCCESS("Label is valid");

    private final String message;

    CategoryValidatorResult(String message) {
        this.message = message;
    }

}
