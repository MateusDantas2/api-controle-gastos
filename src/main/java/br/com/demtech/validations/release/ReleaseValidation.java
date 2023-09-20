package br.com.demtech.validations.release;

import br.com.demtech.domain.entity.Category;
import br.com.demtech.domain.entity.Person;
import br.com.demtech.domain.repository.CategoryRepository;
import br.com.demtech.domain.repository.PersonRepository;
import br.com.demtech.exceptions.CategoryException;
import br.com.demtech.exceptions.PersonDoesNotExistOrIsInactiveException;
import br.com.demtech.exceptions.PersonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus Nascimento
 */
@Service
public class ReleaseValidation {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PersonRepository personRepository;

    public void validateFieldsExists(Category category, Person person) {
        if (!categoryRepository.existsById(category.getId())) {
            throw new CategoryException("erro", "O id da categoria não existe.");
        }

        if (!personRepository.existsById(person.getId())) {
            throw new PersonException("erro", "O id da pessoa não existe.");
        }

        Person savedPerson = personRepository.findById(person.getId()).orElse(null);
        if (savedPerson == null || savedPerson.isInactive()) {
            throw new PersonDoesNotExistOrIsInactiveException();
        }
    }
}
