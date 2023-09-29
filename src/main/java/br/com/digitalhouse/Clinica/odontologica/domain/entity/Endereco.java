package br.com.digitalhouse.Clinica.odontologica.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String lagadouro;
    @NotNull
    private String bairro;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;
    @NotNull
    private String cidade;
    @NotNull
    private String estado;
    @NotNull
    private String cep;
}
