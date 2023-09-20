package br.com.demtech.exceptions;

/**
 *
 * @author Mateus Dantas
 */
public class ReleaseException extends RuntimeException {

    public ReleaseException(Long id) {
        super("Lançamento não encontrado com o ID: " + id);
    }
}
