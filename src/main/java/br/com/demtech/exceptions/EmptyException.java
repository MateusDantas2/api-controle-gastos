package br.com.demtech.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Mateus Dantas
 */
@Getter
@NoArgsConstructor
public class EmptyException extends RuntimeException {

    private  String title;
    private HttpStatus httpStatus;

    public EmptyException(String message) {
        super(message);
    }

    public EmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyException(String title, String message) {
        super(message);
        this.title = title;
    }

    public EmptyException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public EmptyException(String title, String message, HttpStatus httpStatus) {
        super(message);
        this.title = title;
        this.httpStatus = httpStatus;
    }
}
