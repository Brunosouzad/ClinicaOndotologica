package br.com.digitalhouse.Clinica.odontologica.domain.repository;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.ClinicaDentista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicaDentistaRepository extends JpaRepository<ClinicaDentista, UUID> {
}
