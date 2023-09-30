package br.com.digitalhouse.Clinica.odontologica.domain.entity;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity(name = "destistas")
@Getter
@Setter
@Table(name = "dentistas")
public class Dentista {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "nome")
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    @Column(name = "data_de_nascimento")
    private LocalDate dataDeNascimento;
    @NotNull
    @Column(name = "especialidade")
    private String especialidade;
    @NotNull
    @Column(name = "criadoEm")
    private LocalDateTime criadoEm;
    @NotNull
    @Column(name = "atulizadoEm")
    private LocalDateTime atualizadoEm;
    @NotNull
    @Column(name = "sexo")
    private Sexo sexo;
    @NotNull
    @JoinColumn(name = "id_contato")
    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;

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

