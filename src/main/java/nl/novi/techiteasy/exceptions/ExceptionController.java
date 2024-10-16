package nl.novi.techiteasy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {RecordNotFoundException.class})
    public ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException exception) {
        String message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        String message = "Unexpected error " + ex.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ResponseEntity<Object> handleUsernameNotFoundException(UsernameNotFoundException exception) {
        String message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {BadRequestException.class})
    public ResponseEntity<Object> handleBadRequestException(BadRequestException exception) {
        String message = exception.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

}
