package br.com.demtech.domain.repository;

import br.com.demtech.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Mateus Nascimento
 */
public interface PersonRepository extends JpaRepository<Person, Long> {}
