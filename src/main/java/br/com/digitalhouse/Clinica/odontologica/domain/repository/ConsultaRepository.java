package br.com.digitalhouse.Clinica.odontologica.domain.repository;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsultaRepository extends JpaRepository<Consulta, UUID> {
}
