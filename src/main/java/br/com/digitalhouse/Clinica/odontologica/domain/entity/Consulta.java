package br.com.digitalhouse.Clinica.odontologica.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "consultas")
@Table(name = "consultas")
@Getter
@Setter
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_consulta")
    private UUID id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dentista")
    private Dentista dentistas;

    @Column(name = "data_consulta")
    private LocalDate dataDaConsulta;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @Column(name = "cancelada")
    private Boolean cancelada;

    @Column(name = "motivo_cancelamento")
    private String motivoDoCancelamento;

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
