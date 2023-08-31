package br.com.demtech.validations.category;

import br.com.demtech.domain.entity.Category;
import br.com.demtech.domain.repository.CategoryRepository;
import br.com.demtech.dto.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 *
 * @author Mateus Nascimento
 */
@Service
public class CategoryValidation {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseEntity<ErrorResponse> validateNameExists(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            ErrorResponse errorResponse = new ErrorResponse("erro", "O nome da categoria já existe.");
            return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
        }
        return null;
    }
}
