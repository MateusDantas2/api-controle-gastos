package br.com.demtech.service;

import br.com.demtech.domain.entity.Category;
import br.com.demtech.domain.repository.CategoryRepository;
import br.com.demtech.dto.ResponseStandard;
import br.com.demtech.event.ResourceCreatedEvent;
import br.com.demtech.exceptions.CategoryNotFoundException;
import br.com.demtech.exceptions.EmptyException;
import br.com.demtech.validations.category.CategoryValidation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Mateus Dantas
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryValidation categoryValidation;
    @Autowired
    private ApplicationEventPublisher publisher;

    public ResponseStandard createCategory(Category category, HttpServletResponse response) {
        ResponseStandard errorResponse = categoryValidation.validateNameExists(category);
        if (errorResponse != null) {
            return errorResponse;
        }

        Category savedCategory = categoryRepository.save(category);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedCategory.getId()));

        return ResponseStandard.success("Cadastro concluído com sucesso!");
    }

    public List<Category> listCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new EmptyException("Dados não encontrados na base de dados!");
        }
        return categories;
    }

    public Category listCategoryById(Long id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
