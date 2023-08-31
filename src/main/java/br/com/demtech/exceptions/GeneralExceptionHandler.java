package br.com.demtech.exceptions;

import br.com.demtech.domain.entity.Person;
import br.com.demtech.domain.repository.PersonRepository;
import br.com.demtech.dto.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;
import static org.springframework.http.HttpStatus.*;

/**
 *
 * @author Mateus Dantas
 */
@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private PersonRepository personRepository;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable
        (HttpMessageNotReadableException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String userMessage = messageSource.getMessage("invalid.field", null, getLocale());
        String developerMessage = e.getCause().toString();
        List<Error> errors = Arrays.asList(new Error(userMessage, developerMessage));
        return handleExceptionInternal(e, errors, headers, BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid
        (MethodArgumentNotValidException e, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<Error> errors = listOfErrors(e.getBindingResult());
        return handleExceptionInternal(e, errors, headers, BAD_REQUEST, request);
    }

    public ResponseEntity<Object> deleteIfExists(Long id, Optional<Person> person) {
        if (person.isPresent()) {
            personRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            ErrorResponse errorResponse = new ErrorResponse("erro", "Pessoa não encontrada!");
            return ResponseEntity.status(NOT_FOUND).body(errorResponse);
        }
    }

    @ExceptionHandler({ EmptyResultDataAccessException.class })
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
        String userMessage = messageSource.getMessage("resource.not.found", null, LocaleContextHolder.getLocale());
        String developerMessage = ex.toString();
        List<Error> erros = Arrays.asList(new Error(userMessage, developerMessage));
        return handleExceptionInternal(ex, erros, new HttpHeaders(), NOT_FOUND, request);
    }

    public ResponseEntity<ErrorResponse> validateNameExists(Person person) {
        if (personRepository.existsByName(person.getName())) {
            ErrorResponse errorResponse = new ErrorResponse("erro", "O nome da pessoa já existe.");
            return ResponseEntity.status(BAD_REQUEST).body(errorResponse);
        }
        return null;
    }

    private List<Error> listOfErrors(BindingResult bindingResult) {
        List<Error> errors = new ArrayList<>();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            String userMessage = messageSource.getMessage(fieldError, getLocale());
            String developerMessage = fieldError.toString();
            errors.add(new Error(userMessage, developerMessage));
        }

        return errors;
    }

    @Getter
    @AllArgsConstructor
    public static class Error {
        private String userMessage;
        private String developerMessage;
    }
}
