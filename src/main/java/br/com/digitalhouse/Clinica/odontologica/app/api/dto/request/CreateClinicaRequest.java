package br.com.digitalhouse.Clinica.odontologica.app.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClinicaRequest {
    private String nome;
    private String cnpj;
    private String razaoSocial;
    private String descricao;
    private CreateEnderecoRequest endereco;
    private CreateContatoRequest contato;
}
