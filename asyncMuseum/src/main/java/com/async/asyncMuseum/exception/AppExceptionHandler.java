package com.async.asyncMuseum.exception;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        return MyResponse.response(HttpStatus.BAD_REQUEST, resourceNotFoundException.getMessage(), null);
    }

    @ExceptionHandler(ResourceExistException.class)
    public ResponseEntity<Object> resourceExistException(ResourceExistException resourceExistException){
        return MyResponse.response(HttpStatus.CONFLICT, resourceExistException.getMessage(), null);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<String, String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        return MyResponse.response(HttpStatus.BAD_REQUEST, "Une erreur s'est produite", errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getPropertyPath() + ": "
                    + violation.getMessage());
        }
        return MyResponse.response(HttpStatus.BAD_REQUEST, "Une erreur s'est produite", errors);
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException exception) {
        String message = exception.getMostSpecificCause().getMessage();

        Map<String, Object> errors = new HashMap<>();
        errors.put("error", "Une erreur s'est produite");
        errors.put("details", message);

        return MyResponse.response(HttpStatus.BAD_REQUEST, "Erreur de contrainte d'intégrité", errors);
    }


    @ExceptionHandler(UniqueConstraintException.class)
    public ResponseEntity<Object> dataIntegrityViolationException(UniqueConstraintException exception){
        return MyResponse.response(HttpStatus.BAD_REQUEST, exception.getMessage(), null);
    }

}
