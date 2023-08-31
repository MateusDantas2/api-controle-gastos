package br.com.demtech.validations.person;

import br.com.demtech.domain.entity.Category;
import br.com.demtech.domain.entity.Person;
import br.com.demtech.domain.repository.PersonRepository;
import br.com.demtech.dto.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 *
 * @author Mateus Nascimento
 */
@Service
public class PersonValidation {

    @Autowired
    private PersonRepository personRepository;

    public ResponseEntity<ErrorResponse> validateNameExists(Person person) {
        if (personRepository.existsByName(person.getName())) {
            ErrorResponse errorResponse = new ErrorResponse("erro", "O nome da pessoa já existe.");
            return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
        }
        return null;
    }
}
