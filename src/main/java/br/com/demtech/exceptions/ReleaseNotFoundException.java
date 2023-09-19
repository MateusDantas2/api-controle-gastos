package br.com.demtech.exceptions;

/**
 *
 * @author Mateus Dantas
 */
public class ReleaseNotFoundException extends RuntimeException {

    public ReleaseNotFoundException(Long id) {
        super("Lançamento não encontrado com o ID: " + id);
    }
}
