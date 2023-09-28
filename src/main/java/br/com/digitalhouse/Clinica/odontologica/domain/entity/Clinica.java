package br.com.digitalhouse.Clinica.odontologica.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Clinica {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotNull
    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotNull
    @CNPJ
    @Column(name = "cnpj")
    private String cnpj;

    @NotNull
    @Column(name = "razao_Social")
    private String razaoSocial;

    @NotNull
    @Column(name = "descricao")
    private String descricao;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contato")
    private Contato contato;
}
