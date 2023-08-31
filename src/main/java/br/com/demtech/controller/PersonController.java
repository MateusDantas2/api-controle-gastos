package br.com.demtech.controller;

import br.com.demtech.domain.entity.Person;
import br.com.demtech.domain.repository.PersonRepository;
import br.com.demtech.dto.ResponseStandard;
import br.com.demtech.exceptions.EmptyException;
import br.com.demtech.exceptions.GeneralExceptionHandler;
import br.com.demtech.service.PersonService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private GeneralExceptionHandler generalExceptionHandler;
    @Autowired
    private PersonService personService;

    @PostMapping(value = "/createPerson", produces = "application/json")
    public ResponseEntity<ResponseStandard> createPerson(@Valid @RequestBody Person person, HttpServletResponse response) {
        ResponseStandard responseEntity = personService.createPerson(person, response);
        return ResponseEntity.status(CREATED).body(responseEntity);
    }

    @GetMapping
    public ResponseEntity<List<Person>> listPerson() {
        List<Person> person = personService.listPerson();
        return ResponseEntity.ok().body(person);
    }

    //TODO REFATORAR
    @GetMapping("/{id}")
    public ResponseEntity<Person> listPersonById(@PathVariable Long id) {
        Person person = personRepository.findById(id).orElse(null);
        return person != null ? ResponseEntity.ok(person) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @Valid @RequestBody Person person) {
        Person savedPerson = personRepository.findById(id).orElse(null);
        if (savedPerson == null) {
            throw new EmptyResultDataAccessException(1);
        }
        BeanUtils.copyProperties(person, savedPerson, "id");
        personRepository.save(savedPerson);
        return ResponseEntity.ok(savedPerson);
    }

    //TODO REFATORAR
    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public ResponseEntity<Object> deletePerson(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        return generalExceptionHandler.deleteIfExists(id, person);
    }
}
