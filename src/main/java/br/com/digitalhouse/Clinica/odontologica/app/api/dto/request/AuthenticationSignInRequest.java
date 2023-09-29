package br.com.digitalhouse.Clinica.odontologica.app.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationSignInRequest {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
