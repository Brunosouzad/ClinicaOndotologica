package br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.dentista;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Dentista;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class DentistaSummaryResponse {
    private UUID id;
    private String nome;
    private String especialidade;

}
