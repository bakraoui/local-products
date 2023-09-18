package com.localproducts.helpers.categoryHelpers;

import com.localproducts.dto.categoryDto.CreateCategoryRequest;

import java.util.function.Function;

import static com.localproducts.helpers.categoryHelpers.CategoryValidatorResult.LABEL_NOT_VALID;
import static com.localproducts.helpers.categoryHelpers.CategoryValidatorResult.SUCCESS;

public interface CreateCategoryRequestHandler extends Function<CreateCategoryRequest, CategoryValidatorResult> {

    static CreateCategoryRequestHandler isLabelValid() {
        return request -> request.getLabel().isEmpty() ? LABEL_NOT_VALID: SUCCESS;
    }

    default CreateCategoryRequestHandler and (CreateCategoryRequestHandler other) {
        return request -> {
            CategoryValidatorResult result = this.apply(request);
            return result.equals(SUCCESS) ? other.apply(request): result;
        };
    }
}
