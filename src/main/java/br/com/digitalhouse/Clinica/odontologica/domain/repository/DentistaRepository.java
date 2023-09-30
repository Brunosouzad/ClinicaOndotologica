package br.com.digitalhouse.Clinica.odontologica.domain.repository;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DentistaRepository extends JpaRepository<Dentista, UUID> {
}
