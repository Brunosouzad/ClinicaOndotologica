package br.com.digitalhouse.Clinica.odontologica.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignIn {
    private String email;
    private String password;

    public String getNome() {
        return null;
    }

    public UserPermissionEnum getRole() {
        return null;
    }
}
