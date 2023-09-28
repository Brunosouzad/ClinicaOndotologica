package br.com.digitalhouse.Clinica.odontologica.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String lagadouro;
    private String bairro;
    private LocalDate criadoEm;
    private LocalDate atualizadoEm;
    private String cidade;
    private String estado;
    private String cep;
}
