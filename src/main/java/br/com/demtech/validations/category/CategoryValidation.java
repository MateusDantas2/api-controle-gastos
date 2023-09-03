package br.com.demtech.validations.category;

import br.com.demtech.domain.entity.Category;
import br.com.demtech.domain.repository.CategoryRepository;
import br.com.demtech.dto.ResponseStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus Nascimento
 */
@Service
public class CategoryValidation {

    @Autowired
    private CategoryRepository categoryRepository;

    public ResponseStandard validateNameExists(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            return new ResponseStandard("erro", "O nome da categoria já existe.");
        }
        return null;
    }
}
