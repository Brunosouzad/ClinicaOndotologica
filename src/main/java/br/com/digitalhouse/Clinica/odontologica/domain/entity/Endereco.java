package br.com.digitalhouse.Clinica.odontologica.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "enderecos")
@Table(name = "enderecos")
@Getter
@Setter
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @Column(name = "lagadouro")
    private String lagadouro;
    @NotNull
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;
    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;
    @NotNull
    @Column(name = "cidade")
    private String cidade;
    @NotNull
    @Column(name = "estado")
    private String estado;
    @NotNull
    @Column(name = "cep")
    private String cep;

    @PrePersist
    public void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        this.criadoEm = now;
        this.atualizadoEm = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.atualizadoEm = LocalDateTime.now();
    }
}
