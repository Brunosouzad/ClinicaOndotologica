package br.com.digitalhouse.Clinica.odontologica.app.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class CreateEnderecoRequest {
    private String lagadouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

}
