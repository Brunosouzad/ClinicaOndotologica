package br.com.digitalhouse.Clinica.odontologica.domain.service.impl;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Consulta;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Dentista;
import br.com.digitalhouse.Clinica.odontologica.domain.exception.ClinicaNotFoundExcepetion;
import br.com.digitalhouse.Clinica.odontologica.domain.repository.ConsultaRepository;
import br.com.digitalhouse.Clinica.odontologica.domain.service.ConsultaService;
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
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Consulta criarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public Consulta buscarConsultaPorID(UUID id) {
        return consultaRepository.findById(id).orElseThrow(() -> new ClinicaNotFoundExcepetion(id));

    }

    @Override
    public Page<Consulta> buscarTodasConsulta(Pageable pageable) {
        return consultaRepository.findAll(pageable);
    }

    @Override
    public Consulta atualizarConsulta(UUID id, Map<String, Object> campos) {
        Consulta consultaExistente = consultaRepository.findById(id)
                .orElseThrow(() -> new ClinicaNotFoundExcepetion(id));

        for (Field field : Clinica.class.getDeclaredFields()) {
            String fieldName = field.getName();
            if (campos.containsKey(fieldName)) {
                try {
                    field.setAccessible(true);
                    Object newValue = campos.get(fieldName);
                    field.set(consultaExistente, newValue);
                } catch (IllegalAccessException e) {
                    log.error("Erro ao definir valor do campo: " + fieldName, e);
                }
            }
        }

        return consultaRepository.save(consultaExistente);
    }

    @Override
    public void excluirConsulta(UUID id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(()-> new ClinicaNotFoundExcepetion(id));
        consultaRepository.delete(consulta);
    }
}
