package com.srover.client.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    List<FieldMessage> fieldMessages = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public void addFieldError(FieldMessage fieldMessage) {
        fieldMessages.add(fieldMessage);
    }

    public List<FieldMessage> getFieldErrors() {
        return fieldMessages;
    }
}
