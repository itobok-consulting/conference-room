package com.mashreq.kcm.conferenceroom.exceptions;

import com.mashreq.kcm.conferenceroom.model.common.FieldValidationModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(value = HttpStatus.PRECONDITION_REQUIRED, reason = "Field Validation Exception")
public class ValidationException extends RuntimeException {

    private final List<FieldValidationModel> errors;

    public ValidationException(List<FieldValidationModel> errors) {
        this.errors = errors;
    }

    public List<FieldValidationModel> getValidationErrors() {
        return errors;
    }

}
