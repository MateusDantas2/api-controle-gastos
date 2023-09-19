package br.com.demtech.validations.release;

import br.com.demtech.domain.entity.Category;
import br.com.demtech.domain.entity.Person;
import br.com.demtech.domain.repository.CategoryRepository;
import br.com.demtech.domain.repository.PersonRepository;
import br.com.demtech.dto.ResponseStandard;
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

    public ResponseStandard validateFieldsExists(Category category, Person person) {
        if (!categoryRepository.existsById(category.getId())) {
            return new ResponseStandard("erro", "O id da categoria não existe.");
        }

        if (!personRepository.existsById(person.getId())) {
            return new ResponseStandard("erro", "O id da pessoa não existe.");
        }
        return null;
    }
}
