package br.com.digitalhouse.Clinica.odontologica.app.api.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateContatoRequest {
    private UUID id;
    private String email;
    private String telefone;
}
