package br.com.digitalhouse.Clinica.odontologica.domain.service;

import br.com.digitalhouse.Clinica.odontologica.domain.entity.Consulta;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Dentista;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface DentistaService {
    Dentista criarDentista(Dentista dentista);
    Dentista buscarDentistaPorID(UUID id);
    Page<Dentista> buscarTodosDentista(Pageable pageable);
    Dentista atualizarDentista(UUID id, Map<String, Object> campos);
    void excluirDentista(UUID id);
}
