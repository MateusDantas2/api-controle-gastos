package br.com.demtech.exceptions;

/**
 *
 * @author Mateus Dantas
 */
public class PersonException extends RuntimeException {

    public PersonException(Long id) {
        super("Pessoa não encontrada com o ID: " + id);
    }

    public PersonException(String title, String message) {
        super(message);
    }
}
