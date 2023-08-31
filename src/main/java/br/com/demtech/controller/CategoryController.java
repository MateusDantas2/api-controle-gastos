package br.com.demtech.controller;

import br.com.demtech.domain.entity.Category;
import br.com.demtech.domain.repository.CategoryRepository;
import br.com.demtech.dto.ErrorResponse;
import br.com.demtech.event.ResourceCreatedEvent;
import br.com.demtech.validations.category.CategoryValidation;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

/**
 *
 * @author Mateus Dantas
 */
@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private CategoryValidation categoryValidation;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Category category, HttpServletResponse response) {
        ResponseEntity<ErrorResponse> erroResponse = categoryValidation.validateNameExists(category);
        if (erroResponse != null) return erroResponse;

        Category savedCategory = categoryRepository.save(category);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedCategory.getId()));

        return ResponseEntity.status(CREATED).body(savedCategory);
    }

    @GetMapping
    public List<Category> list() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryRepository.findById(id).orElse(null);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }
}
