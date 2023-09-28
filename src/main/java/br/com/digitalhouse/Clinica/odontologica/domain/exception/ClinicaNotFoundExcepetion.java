package br.com.digitalhouse.Clinica.odontologica.domain.exception;

import java.util.UUID;

public class ClinicaNotFoundExcepetion extends RuntimeException{
    public ClinicaNotFoundExcepetion(UUID clinicaID) {
        super("Clinica com id: %s não encontrado! Reveja o que foi solicitado.".formatted(clinicaID));
    }
}
