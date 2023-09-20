package br.com.demtech.exceptions;

/**
 *
 * @author Mateus Dantas
 */
public class CategoryException extends RuntimeException {

    public CategoryException(Long id) {
        super("Categoria não encontrada com o ID: " + id);
    }

    public CategoryException(String title, String message) {
        super(message);
    }
}
