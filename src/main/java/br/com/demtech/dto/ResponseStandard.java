package br.com.demtech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mateus Dantas
 */
@Getter @Setter
@AllArgsConstructor
public class ResponseStandard {

    private String status;
    private String message;

    public static ResponseStandard error(String message) {
        return new ResponseStandard("erro", message);
    }

    public static ResponseStandard success(String message) {
        return new ResponseStandard("sucesso", message);
    }
}