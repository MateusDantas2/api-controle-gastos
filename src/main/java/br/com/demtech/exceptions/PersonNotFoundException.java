package br.com.demtech.exceptions;

/**
 *
 * @author Mateus Dantas
 */
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Long id) {
        super("Pessoa não encontrada com o ID: " + id);
    }
}
