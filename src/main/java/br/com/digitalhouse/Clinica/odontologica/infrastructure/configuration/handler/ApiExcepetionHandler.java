package br.com.digitalhouse.Clinica.odontologica.infrastructure.configuration.handler;

import br.com.digitalhouse.Clinica.odontologica.domain.exception.ClinicaNotFoundExcepetion;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
public class ApiExcepetionHandler {
    @ExceptionHandler(ClinicaNotFoundExcepetion.class)
    public ResponseEntity<?> clinicaNotFoundExceptionHandler(ClinicaNotFoundExcepetion exception) {
        return ResponseEntity.badRequest().body(
                """
                {
                    "status" : 400,
                    "message" : "%s"
                }       \s
                """.formatted(exception.getMessage())
        );
    }
}
