package br.com.digitalhouse.Clinica.odontologica.domain.service;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Consulta;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface PacienteService {
    Paciente criarPaciente(Paciente paciente);
    Paciente buscarPacientePorID(UUID id);
    Page<Paciente> buscarTodosPaciente(Pageable pageable);
    Paciente atualizarPaciente(UUID id, Map<String, Object> campos);
    void excluirPaciente(UUID id);
}
