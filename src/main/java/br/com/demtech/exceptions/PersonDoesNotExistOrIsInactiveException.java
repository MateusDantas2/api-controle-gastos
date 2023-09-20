package br.com.demtech.exceptions;

/**
 *
 * @author Mateus Dantas
 */
public class PersonDoesNotExistOrIsInactiveException extends RuntimeException {
    public PersonDoesNotExistOrIsInactiveException() {
        super("Pessoa está inativa ou não foi encontrada!");
    }
}
