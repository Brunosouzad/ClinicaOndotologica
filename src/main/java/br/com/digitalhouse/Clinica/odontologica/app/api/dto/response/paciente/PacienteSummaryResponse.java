package br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.paciente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class PacienteSummaryResponse {
    private UUID id;
    private String nome;
}
