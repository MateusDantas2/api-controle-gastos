package br.com.demtech.exceptions;

/**
 *
 * @author Mateus Dantas
 */
public class EmptyException extends RuntimeException {
    public EmptyException(String message) {
        super(message);
    }

    public EmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
