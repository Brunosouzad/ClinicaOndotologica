package br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.paciente;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Contato;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Endereco;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.enums.Sexo;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreatePacienteRequest {

    private String nome;
    private String dataDeNascimento;
    private Endereco endereco;
    private Sexo sexo;
    private Contato contato;
}
