package br.com.digitalhouse.Clinica.odontologica.domain.service;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Consulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface ConsultaService {
    Consulta criarConsulta(Consulta consulta);
    Consulta buscarConsultaPorID(UUID id);
    Page<Consulta> buscarTodasConsulta(Pageable pageable);
    Consulta atualizarConsulta(UUID id, Map<String, Object> campos);
    void excluirConsulta(UUID id);
}

