package br.com.digitalhouse.Clinica.odontologica.domain.repository;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicaRepository extends JpaRepository<Clinica, UUID> {
}
