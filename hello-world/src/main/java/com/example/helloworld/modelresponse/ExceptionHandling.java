package com.example.helloworld.modelresponse;

import java.util.Date;
import com.example.helloworld.modelresponse.ErrorMessage; 

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler{
  // General exception
  @ExceptionHandler(value= {Exception.class})
  public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();

    if (errorMessageDescription == null) errorMessageDescription = ex.toString();

    ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
    return new ResponseEntity<>(
      errorMessage,
      new HttpHeaders(),
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }

  // Specific Exception
  @ExceptionHandler(value= {NullPointerException.class})
  public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();

    if (errorMessageDescription == null) errorMessageDescription = ex.toString();

    ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
    return new ResponseEntity<>(
      errorMessage,
      new HttpHeaders(),
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }

  // User Service Exception
  @ExceptionHandler(value= {UserServiceException.class})
  public ResponseEntity<Object> handleUserServideException(UserServiceException ex, WebRequest request) {
    String errorMessageDescription = ex.getLocalizedMessage();

    if (errorMessageDescription == null) errorMessageDescription = ex.toString();

    ErrorMessage errorMessage = new ErrorMessage(new Date(), errorMessageDescription);
    return new ResponseEntity<>(
      errorMessage,
      new HttpHeaders(),
      HttpStatus.INTERNAL_SERVER_ERROR
    );
  }
}