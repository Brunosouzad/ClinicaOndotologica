package br.com.digitalhouse.Clinica.odontologica.domain.service;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface ClinicaService {
    Clinica criarClinica(Clinica clinica);
    Clinica buscarClinicaPorID(UUID id);
    Page<Clinica> buscarTodasClinicas(Pageable pageable);
    Clinica atualizarClinica(UUID id, Map<String, Object> campos);
    void excluirClinicar(UUID id);
}
