package br.com.fernando.realmeet.config;

import br.com.fernando.realmeet.api.model.ResponseError;
import br.com.fernando.realmeet.exception.RoomNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RoomNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(Exception exception) {
        return buildResponseEntity(HttpStatus.NOT_FOUND, exception);
    }


    private ResponseEntity<Object> buildResponseEntity(HttpStatus httpStatus, Exception exception) {
        return new ResponseEntity<>(
                new ResponseError()
                        .status(httpStatus.getReasonPhrase())
                        .code(httpStatus.value())
                        .message(exception.getMessage())
                , httpStatus
        );
    }


}
