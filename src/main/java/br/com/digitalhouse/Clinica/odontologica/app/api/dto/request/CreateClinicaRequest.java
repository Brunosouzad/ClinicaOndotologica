package br.com.digitalhouse.Clinica.odontologica.app.api.dto.request;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Contato;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class CreateClinicaRequest {
    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @CNPJ
    private String cnpj;
    @Size(min = 5, message = "A razao social deve ter pelo menos 5 caracteres")
    private String razaoSocial;
    @NotNull
    private String descricao;
    @NotNull
    private CreateEnderecoRequest endereco;
    @NotNull
    private CreateContatoRequest contato;
}
