package com.mashreq.kcm.conferenceroom.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mashreq.kcm.conferenceroom.model.common.FieldValidationModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionDetails {
    /**
     * The Status.
     */
    private HttpStatus status;
    /**
     * The Timestamp.
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    /**
     * The Message.
     */
    private String message;
    /**
     * The Path.
     */
    private String path;

    private List<FieldValidationModel> fieldValidationErrors;

    /**
     * Instantiates a new Exception details.
     */
    private ExceptionDetails() {
        timestamp = LocalDateTime.now();
    }

    /**
     * Instantiates a new Exception details.
     *
     * @param status the status
     */
    public ExceptionDetails(HttpStatus status) {
        this();
        this.status = status;
    }

    public ExceptionDetails(HttpStatus status, String path) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.path = path;
    }

    public ExceptionDetails(HttpStatus status, String message,  String Path) {
        this();
        this.status = status;
        this.message = message;
        this.path = Path;
    }

    public ExceptionDetails(HttpStatus status, String message, String Path, List<FieldValidationModel> errors) {
        this();
        this.status = status;
        this.message = message;
        this.path = Path;
        this.fieldValidationErrors = errors;
    }
}
