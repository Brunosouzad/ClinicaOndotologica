package br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.dentista;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Contato;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class DentistaDetailedResponse {
    private UUID id;
    private String nome;
    private LocalDate dataDeNascimento;
    private String especialidade;
    private Sexo sexo;
    private Contato contato;
}
