package br.com.demtech.exceptions.handler;

import br.com.demtech.dto.ErrorResponse;
import br.com.demtech.exceptions.PersonDoesNotExistOrIsInactiveException;
import br.com.demtech.exceptions.PersonException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 *
 * @author Mateus Dantas
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class PersonExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PersonException.class)
    public ResponseEntity<Object> handlePersonDoesNotExists(PersonException ex, WebRequest request) {
        String message = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("erro 400", message);
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), BAD_REQUEST, request);
    }

    @ExceptionHandler(PersonDoesNotExistOrIsInactiveException.class)
    public ResponseEntity<Object> handlePersonDoesNotExistOrInactive(PersonDoesNotExistOrIsInactiveException ex, WebRequest request) {
        String message = ex.getMessage();
        ErrorResponse errorResponse = new ErrorResponse("erro 400", message);
        return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), BAD_REQUEST, request);
    }
}
