package br.com.demtech.validations.person;

import br.com.demtech.domain.entity.Person;
import br.com.demtech.domain.repository.PersonRepository;
import br.com.demtech.dto.ResponseStandard;
import br.com.demtech.exceptions.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mateus Nascimento
 */
@Service
public class PersonValidation {

    @Autowired
    private PersonRepository personRepository;

    public ResponseStandard validateNameExists(Person person) {
        if (personRepository.existsByName(person.getName())) {
            return new ResponseStandard("erro", "O nome da pessoa já existe.");
        }
        return null;
    }

    public Person getPersonById(Long id) {
        Person savedPerson = personRepository.findById(id).orElse(null);
        if (savedPerson == null) {
            throw new PersonNotFoundException(id);
        }
        return savedPerson;
    }
}
