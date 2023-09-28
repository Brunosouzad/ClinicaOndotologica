package br.com.digitalhouse.Clinica.odontologica.domain.service.impl;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.exception.ClinicaNotFoundExcepetion;
import br.com.digitalhouse.Clinica.odontologica.domain.repository.ClinicaRepository;
import br.com.digitalhouse.Clinica.odontologica.domain.service.ClinicaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.UUID;
@Slf4j
@Service
public class ClinicaServiceImpl implements ClinicaService {
    private final ClinicaRepository clinicaRepository;
    @Autowired
    public ClinicaServiceImpl(ClinicaRepository clinicaRepository, ObjectMapper objectMapper) {
        this.clinicaRepository = clinicaRepository;
    }

    @Override
    public Clinica criarClinica(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    @Override
    public Clinica buscarClinicaPorID(UUID id) {
        return clinicaRepository.findById(id).orElseThrow(() -> new ClinicaNotFoundExcepetion(id));

    }

    @Override
    public Page<Clinica> buscarTodasClinicas(Pageable pageable) {
        return clinicaRepository.findAll(pageable);
    }

    @Override
    public Clinica atualizarClinica(UUID id, Map<String, Object> campos) {
        Clinica clinicaExistente = clinicaRepository.findById(id)
                .orElseThrow(() -> new ClinicaNotFoundExcepetion(id));

        for (Field field : Clinica.class.getDeclaredFields()) {
            String fieldName = field.getName();
            if (campos.containsKey(fieldName)) {
                try {
                    field.setAccessible(true);
                    Object newValue = campos.get(fieldName);
                    field.set(clinicaExistente, newValue);
                } catch (IllegalAccessException e) {
                    log.error("Erro ao definir valor do campo: " + fieldName, e);
                }
            }
        }

        return clinicaRepository.save(clinicaExistente);
    }



    @Override
    public void excluirClinicar(UUID id) {
        Clinica clinica = clinicaRepository.findById(id).orElseThrow(()-> new ClinicaNotFoundExcepetion(id));
        clinicaRepository.delete(clinica);
    }

}
