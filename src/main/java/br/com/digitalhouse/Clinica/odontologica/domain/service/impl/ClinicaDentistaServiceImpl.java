package br.com.digitalhouse.Clinica.odontologica.domain.service.impl;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.ClinicaDentista;
import br.com.digitalhouse.Clinica.odontologica.domain.exception.ClinicaNotFoundExcepetion;
import br.com.digitalhouse.Clinica.odontologica.domain.repository.ClinicaDentistaRepository;
import br.com.digitalhouse.Clinica.odontologica.domain.service.ClinicaDentistaService;
import lombok.AllArgsConstructor;
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
public class ClinicaDentistaServiceImpl implements ClinicaDentistaService {
    private final ClinicaDentistaRepository clinicaDentistaRepository;

    @Autowired
    public ClinicaDentistaServiceImpl(ClinicaDentistaRepository clinicaDentistaRepository) {
        this.clinicaDentistaRepository = clinicaDentistaRepository;
    }


    @Override
    public ClinicaDentista criarClinicaDentista(ClinicaDentista clinicaDentista) {
        return clinicaDentistaRepository.save(clinicaDentista);
    }

    @Override
    public ClinicaDentista buscarClinicaDentistaPorID(UUID id) {
        return clinicaDentistaRepository.findById(id).orElseThrow(() -> new ClinicaNotFoundExcepetion(id));
    }

    @Override
    public Page<ClinicaDentista> buscarTodasClinicasDentista(Pageable pageable) {
        return clinicaDentistaRepository.findAll(pageable);
    }

    @Override
    public ClinicaDentista atualizarClinicaDentista(UUID id, Map<String, Object> campos) {
        ClinicaDentista clinicaDentistaExistente = clinicaDentistaRepository.findById(id)
                .orElseThrow(() -> new ClinicaNotFoundExcepetion(id));

        for (Field field : Clinica.class.getDeclaredFields()) {
            String fieldName = field.getName();
            if (campos.containsKey(fieldName)) {
                try {
                    field.setAccessible(true);
                    Object newValue = campos.get(fieldName);
                    field.set(clinicaDentistaExistente, newValue);
                } catch (IllegalAccessException e) {
                    log.error("Erro ao definir valor do campo: " + fieldName, e);
                }
            }
        }
        return clinicaDentistaRepository.save(clinicaDentistaExistente);

    }


    @Override
    public void excluirClinicarDentista(UUID id) {
        ClinicaDentista clinicaDentista = clinicaDentistaRepository.findById(id).orElseThrow(()-> new ClinicaNotFoundExcepetion(id));
        clinicaDentistaRepository.delete(clinicaDentista);
    }
}
