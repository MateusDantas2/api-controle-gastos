package br.com.demtech.controller;

import br.com.demtech.domain.entity.Person;
import br.com.demtech.domain.repository.PersonRepository;
import br.com.demtech.dto.ErrorResponse;
import br.com.demtech.event.ResourceCreatedEvent;
import br.com.demtech.exceptions.GeneralExceptionHandler;
import br.com.demtech.validations.person.PersonValidation;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

/**
 *
 * @author Mateus Dantas
 */
@RestController
@RequestMapping("/pessoas")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ApplicationEventPublisher publisher;
    @Autowired
    private GeneralExceptionHandler generalExceptionHandler;
    @Autowired
    private PersonValidation personValidation;

    @GetMapping
    public List<Person> list() {
        return personRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Person person, HttpServletResponse response) {
        ResponseEntity<ErrorResponse> errorResponse = personValidation.validateNameExists(person);
        if (errorResponse != null) return errorResponse;

        Person savedPerson = personRepository.save(person);
        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedPerson.getId()));

        return ResponseEntity.status(CREATED).body(savedPerson);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Object> toRemove(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        return generalExceptionHandler.deleteIfExists(id, person);
    }
}
