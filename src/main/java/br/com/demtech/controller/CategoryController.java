package br.com.demtech.controller;

import br.com.demtech.domain.entity.Category;
import br.com.demtech.dto.ResponseStandard;
import br.com.demtech.service.CategoryService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * @author Mateus Dantas
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/createCategory", produces = "application/json")
    public ResponseEntity<ResponseStandard> createCategory(@Valid @RequestBody Category category, HttpServletResponse response) {
        ResponseStandard responseStandard = categoryService.createCategory(category, response);
        return ResponseEntity.status(CREATED).body(responseStandard);
    }

    @GetMapping
    public ResponseEntity<List<Category>> listCategories() {
        List<Category> categories = categoryService.listCategories();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> listCategoryById(@PathVariable Long id) {
        Category category = categoryService.listCategoryById(id);
        return ResponseEntity.ok(category);
    }
}
