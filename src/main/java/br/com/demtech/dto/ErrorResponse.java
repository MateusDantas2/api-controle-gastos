package br.com.demtech.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mateus Nascimento
 */
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private String status;
    private String message;
    private String details;

    public ErrorResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(String status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
    }
}
