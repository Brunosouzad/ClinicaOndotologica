package br.com.digitalhouse.Clinica.odontologica.app.api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateContatoRequest {
    private String email;
    private String telefone;
}
