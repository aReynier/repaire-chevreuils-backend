package repairechevreuilsbackend.repaire_chevreuils_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// This is use to handle 404 error with right error message
@RestControllerAdvice
class AdminNotFoundAdvice {

  @ExceptionHandler(AdminNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String adminNotFoundHandler(AdminNotFoundException ex) {
    return ex.getMessage();
  }
}
