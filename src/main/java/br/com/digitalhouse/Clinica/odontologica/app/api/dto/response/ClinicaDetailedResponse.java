package br.com.digitalhouse.Clinica.odontologica.app.api.dto.response;

import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.CreateContatoRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.CreateEnderecoRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor

public class ClinicaDetailedResponse {

    private UUID id;
    private String nome;
    private String cnpj;
    private String razaoSocial;
    private String descricao;
    private CreateEnderecoRequest endereco;
    private CreateContatoRequest contato;
}
