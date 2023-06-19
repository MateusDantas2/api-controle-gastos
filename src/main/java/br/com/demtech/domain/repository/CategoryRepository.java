package br.com.demtech.domain.repository;

import br.com.demtech.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mateus Nascimento
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {}
