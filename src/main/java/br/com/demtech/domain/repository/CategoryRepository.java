package br.com.demtech.domain.repository;

import br.com.demtech.domain.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mateus Dantas
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}
