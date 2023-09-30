package br.com.digitalhouse.Clinica.odontologica.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "clinica_dentistas")
@Table(name = "clinica_detintas")
public class ClinicaDentista {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToMany
    @JoinTable(
            name = "clinica_dentista_dentistas",
            joinColumns = @JoinColumn(name = "clinica_dentista_id"),
            inverseJoinColumns = @JoinColumn(name = "dentista_id")
    )
    private List<Dentista> dentistas = new ArrayList<>();

    @NotNull
    @ManyToMany
    @JoinTable(
            name = "clinica_dentista_clinicas",
            joinColumns = @JoinColumn(name = "clinica_dentista_id"),
            inverseJoinColumns = @JoinColumn(name = "clinica_id")
    )
    private List<Clinica> clinicas = new ArrayList<>();
}
