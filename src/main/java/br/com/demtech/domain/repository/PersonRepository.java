package br.com.demtech.domain.repository;

import br.com.demtech.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mateus Dantas
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean existsByName(String name);
}
