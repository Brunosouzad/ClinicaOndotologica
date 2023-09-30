package br.com.digitalhouse.Clinica.odontologica.domain.service;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.ClinicaDentista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface ClinicaDentistaService {
    ClinicaDentista criarClinicaDentista(ClinicaDentista clinicaDentista);
    ClinicaDentista buscarClinicaDentistaPorID(UUID id);
    Page<ClinicaDentista> buscarTodasClinicasDentista(Pageable pageable);
    ClinicaDentista atualizarClinicaDentista(UUID id, Map<String, Object> campos);
    void excluirClinicarDentista(UUID id);
}

