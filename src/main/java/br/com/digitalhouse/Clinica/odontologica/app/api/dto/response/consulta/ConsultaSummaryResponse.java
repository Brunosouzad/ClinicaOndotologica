package br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Dentista;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Paciente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ConsultaSummaryResponse {
    private UUID id;
    private Paciente paciente;
    private Dentista dentistas;
    private LocalDate dataDaConsulta;
}
