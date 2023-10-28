package br.com.demtech.exceptions;

/**
 *
 * @author Mateus Dantas
 */
public class UserException extends RuntimeException {
    public UserException(String title, String message) {
        super(message);
    }
}
