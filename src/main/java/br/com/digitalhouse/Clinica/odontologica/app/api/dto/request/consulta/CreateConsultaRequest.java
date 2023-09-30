package br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.consulta;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Dentista;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateConsultaRequest {
    private Paciente paciente;
    private Dentista dentistas;
    private LocalDate dataDaConsulta;
    private Boolean cancelada;
    private String motivoDoCancelamento;
}
