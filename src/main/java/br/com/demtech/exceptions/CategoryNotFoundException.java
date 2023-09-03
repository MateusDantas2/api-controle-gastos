package br.com.demtech.exceptions;

/**
 *
 * @author Mateus Dantas
 */
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(Long id) {
        super("Categoria não encontrada com o ID: " + id);
    }
}
