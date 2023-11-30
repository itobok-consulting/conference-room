package com.mashreq.kcm.conferenceroom.validations.rules;

import lombok.Data;

import java.util.Objects;

@Data
public abstract class RoomsAbstractValidator<Argument> {
    protected RoomsAbstractValidator<Argument> nextValidator;

    public void validate(Argument argument) {
        this.setNextValidator();
        if (Objects.nonNull(this.nextValidator)) {
            this.nextValidator.validate(argument);
        }
    }
    public void setNextValidator() {

    }
}
