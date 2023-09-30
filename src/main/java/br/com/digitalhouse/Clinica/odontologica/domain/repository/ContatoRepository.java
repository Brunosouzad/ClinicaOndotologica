package br.com.digitalhouse.Clinica.odontologica.domain.repository;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContatoRepository extends JpaRepository<Contato, UUID> {
}
