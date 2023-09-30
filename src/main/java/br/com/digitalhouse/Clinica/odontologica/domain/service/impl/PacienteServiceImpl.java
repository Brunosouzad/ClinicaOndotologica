package br.com.digitalhouse.Clinica.odontologica.domain.service.impl;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Paciente;
import br.com.digitalhouse.Clinica.odontologica.domain.exception.ClinicaNotFoundExcepetion;
import br.com.digitalhouse.Clinica.odontologica.domain.repository.PacienteRepository;
import br.com.digitalhouse.Clinica.odontologica.domain.service.PacienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j

public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente criarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPacientePorID(UUID id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new ClinicaNotFoundExcepetion(id));
    }

    @Override
    public Page<Paciente> buscarTodosPaciente(Pageable pageable) {
        return pacienteRepository.findAll(pageable);
    }

    @Override
    public Paciente atualizarPaciente(UUID id, Map<String, Object> campos) {
        Paciente pacienteExistente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ClinicaNotFoundExcepetion(id));

        for (Field field : Clinica.class.getDeclaredFields()) {
            String fieldName = field.getName();
            if (campos.containsKey(fieldName)) {
                try {
                    field.setAccessible(true);
                    Object newValue = campos.get(fieldName);
                    field.set(pacienteExistente, newValue);
                } catch (IllegalAccessException e) {
                    log.error("Erro ao definir valor do campo: " + fieldName, e);
                }
            }
        }

        return pacienteRepository.save(pacienteExistente);
    }

    @Override
    public void excluirPaciente(UUID id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(()-> new ClinicaNotFoundExcepetion(id));
        pacienteRepository.delete(paciente);

    }
}
