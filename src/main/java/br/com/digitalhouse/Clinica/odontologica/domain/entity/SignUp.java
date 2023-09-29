package br.com.digitalhouse.Clinica.odontologica.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class SignUp {
    private String nome;
    private String email;
    private String password;
    private LocalDate dataNascimento;
    private UserPermissionEnum role;
}
