package br.com.digitalhouse.Clinica.odontologica.domain.entity;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "pacientes")
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @Column(name = "nome")
    private String nome;
    @NotNull
    @Column(name = "data_de_nascimento")
    private String dataDeNascimento;
    @NotNull
    @JoinColumn(name = "id_endeco")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @Column(name = "criado_em")
    private LocalDateTime criadoEm;
    @Column(name = "atualizado_em")
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
