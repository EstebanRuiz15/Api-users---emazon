package com.emazon.api_users.aplication.exceptions;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.emazon.api_users.domain.exceptions.ErrorExceptionParam;
import com.emazon.api_users.infraestructure.util.ConstantsInfra;


@ControllerAdvice
public class ControlAdvise {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

     @ExceptionHandler(ErrorExceptionParam.class)
    public ResponseEntity<?> resourceNotFoundException(ErrorExceptionParam ex, WebRequest request) {
        ExceptionResponse errorDetails = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
public ResponseEntity<ExceptionResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, WebRequest request) {
    String message = ex.getMessage();

    // Verifica si el error está relacionado con enums
    if (message.contains("Cannot deserialize value of type") && message.contains("not one of the values accepted for Enum class")) {
        // Personaliza el mensaje para errores de enums
        message = ConstantsInfra.ERROR_ROLE;
    }
    ExceptionResponse response = new ExceptionResponse( HttpStatus.BAD_REQUEST.value(),
        message,
        request.getDescription(false));
    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ErrorNotAuthenticated.class)
     public ResponseEntity<?> handleAuthenticationException(RuntimeException ex,WebRequest request) {
        ExceptionResponse errorResponse = new ExceptionResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage(),request.getDescription(false));

        // Devuelve el estado 401 y el mensaje de error
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}