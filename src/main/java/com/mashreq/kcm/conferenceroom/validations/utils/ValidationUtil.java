package com.mashreq.kcm.conferenceroom.validations.utils;

import com.mashreq.kcm.conferenceroom.model.common.FieldValidationModel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationUtil {
    public static void setFieldValidationObject(List<FieldValidationModel> fieldList, String fieldName, String Message) {
        FieldValidationModel field = new FieldValidationModel();
        field.setFieldName(String.valueOf(fieldName));
        field.setMessage(Message);
        fieldList.add(field);
    }

    public static void setInputValidationObject(List<FieldValidationModel> fieldList, String Message) {
        FieldValidationModel field = new FieldValidationModel();
        field.setMessage(Message);
        fieldList.add(field);
    }

    public static void setInputValidation(List<FieldValidationModel> fieldList, String Message) {
        FieldValidationModel field = new FieldValidationModel();
        field.setMessage(Message);
        fieldList.add(field);
    }

}
