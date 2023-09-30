package br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.dentista;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Contato;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.enums.Sexo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateDentistaRequest {

    private String nome;
    private LocalDate dataDeNascimento;
    private String especialidade;
    private Sexo sexo;
    private Contato contato;
}
