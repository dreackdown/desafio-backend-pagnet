package dev.hugofaria.backend.web;

import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(JobInstanceAlreadyCompleteException.class)
    private ResponseEntity<Object> handleFileAlreadyImported(
            JobInstanceAlreadyCompleteException exception
    ) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                "O arquivo informado já foi importado no sistema!"
        );
    }

    @ExceptionHandler(MultipartException.class)
    private ResponseEntity<Object> handleMultipartException(
            MultipartException exception
    ) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                String.format(exception.getMessage())
        );
    }
}