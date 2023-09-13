package br.com.demtech.controller;

import br.com.demtech.domain.entity.Person;
import br.com.demtech.dto.ResponseStandard;
import br.com.demtech.service.PersonService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private PersonService personService;

    @PostMapping(value = "/createPerson", produces = "application/json")
    public ResponseEntity<ResponseStandard> createPerson(@Valid @RequestBody Person person, HttpServletResponse response) {
        ResponseStandard responseStandard = personService.createPerson(person, response);
        return ResponseEntity.status(CREATED).body(responseStandard);
    }

    @GetMapping
    public ResponseEntity<List<Person>> listPeople() {
        List<Person> people = personService.listPeople();
        return ResponseEntity.ok().body(people);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> listPersonById(@PathVariable Long id) {
        Person person = personService.listPersonById(id);
        return ResponseEntity.ok(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @Valid @RequestBody Person person) {
        Person savedPerson = personService.updatePerson(id, person);
        return ResponseEntity.ok(savedPerson);
    }

    @PutMapping("/{id}/status")
    @ResponseStatus(NO_CONTENT)
    public void updateStatusPerson(@PathVariable Long id, @RequestBody Boolean status) {
        personService.updateStatusPerson(id, status);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}
