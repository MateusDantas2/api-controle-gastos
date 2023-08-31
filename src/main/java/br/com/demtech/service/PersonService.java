package br.com.demtech.service;

import br.com.demtech.domain.entity.Person;
import br.com.demtech.domain.repository.PersonRepository;
import br.com.demtech.dto.ErrorResponse;
import br.com.demtech.dto.ResponseStandard;
import br.com.demtech.dto.SuccessResponse;
import br.com.demtech.event.ResourceCreatedEvent;
import br.com.demtech.exceptions.EmptyException;
import br.com.demtech.validations.person.PersonValidation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Mateus Dantas
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonValidation personValidation;
    @Autowired
    private ApplicationEventPublisher publisher;

    public ResponseStandard createPerson(Person person, HttpServletResponse response) {
        ResponseStandard errorResponse = personValidation.validateNameExists(person);
        if (errorResponse != null) {
            return errorResponse;
        }

        Person savedPerson = personRepository.save(person);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedPerson.getId()));

        return ResponseStandard.success("Cadastro concluído com sucesso!");
    }

    public List<Person> listPerson() {
        List<Person> people = personRepository.findAll();
        if (people.isEmpty()) {
            throw new EmptyException("Dados não encontrados na base de dados!");
        }
        return people;
    }
}
