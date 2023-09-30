package br.com.digitalhouse.Clinica.odontologica.domain.service.impl;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Dentista;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Paciente;
import br.com.digitalhouse.Clinica.odontologica.domain.exception.ClinicaNotFoundExcepetion;
import br.com.digitalhouse.Clinica.odontologica.domain.repository.DentistaRepository;
import br.com.digitalhouse.Clinica.odontologica.domain.service.DentistaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class DentistaServiceImpl implements DentistaService {

    private final DentistaRepository dentistaRepository;


    @Autowired
    public DentistaServiceImpl(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    @Override
    public Dentista criarDentista(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }

    @Override
    public Dentista buscarDentistaPorID(UUID id) {
        return dentistaRepository.findById(id).orElseThrow(() -> new ClinicaNotFoundExcepetion(id));
    }

    @Override
    public Page<Dentista> buscarTodosDentista(Pageable pageable) {
        return dentistaRepository.findAll(pageable);
    }

    @Override
    public Dentista atualizarDentista(UUID id, Map<String, Object> campos) {
        Dentista dentistaExistente = dentistaRepository.findById(id)
                .orElseThrow(() -> new ClinicaNotFoundExcepetion(id));

        for (Field field : Clinica.class.getDeclaredFields()) {
            String fieldName = field.getName();
            if (campos.containsKey(fieldName)) {
                try {
                    field.setAccessible(true);
                    Object newValue = campos.get(fieldName);
                    field.set(dentistaExistente, newValue);
                } catch (IllegalAccessException e) {
                    log.error("Erro ao definir valor do campo: " + fieldName, e);
                }
            }
        }

        return dentistaRepository.save(dentistaExistente);
    }

    @Override
    public void excluirDentista(UUID id) {
        Dentista dentista = dentistaRepository.findById(id).orElseThrow(()-> new ClinicaNotFoundExcepetion(id));
        dentistaRepository.delete(dentista);
    }
}
