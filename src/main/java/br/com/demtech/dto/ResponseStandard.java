package br.com.demtech.dto;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

/**
 *
 * @author Mateus Dantas
 */
@Getter @Setter
public class ResponseStandard {

    private String status;
    private String message;

    public ResponseStandard(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ResponseStandard error(String message) {
        return new ResponseStandard("erro", message);
    }

    public static ResponseStandard success(String message) {
        return new ResponseStandard("sucesso", message);
    }
}
