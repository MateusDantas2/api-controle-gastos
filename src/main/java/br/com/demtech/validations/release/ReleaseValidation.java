package br.com.demtech.validations.release;

import br.com.demtech.domain.entity.Category;
import br.com.demtech.domain.entity.Person;
import br.com.demtech.domain.repository.CategoryRepository;
import br.com.demtech.domain.repository.PersonRepository;
import br.com.demtech.exceptions.EmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

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
            throw new EmptyException("erro", "O id da categoria não existe.", BAD_REQUEST);
        }

        if (!personRepository.existsById(person.getId())) {
            throw new EmptyException("erro", "O id da pessoa não existe.", BAD_REQUEST);
        }
    }
}
