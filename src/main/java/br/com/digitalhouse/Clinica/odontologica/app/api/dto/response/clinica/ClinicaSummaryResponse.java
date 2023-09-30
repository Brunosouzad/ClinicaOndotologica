package br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.clinica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ClinicaSummaryResponse {
    private UUID id;
    private String nome;
    private String cnpj;
}
