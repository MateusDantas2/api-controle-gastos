package br.com.demtech.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mateus Dantas
 */
@Getter @Setter
public class SuccessResponse {

    private String status;
    private String message;
    private Object data;

    public SuccessResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public SuccessResponse(String status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
