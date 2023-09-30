package br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.paciente;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Contato;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Endereco;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class PacienteDetailedResponse {
    private UUID id;
    private String nome;
    private String dataDeNascimento;
    private Endereco endereco;
    private Sexo sexo;
    private Contato contato;
}
