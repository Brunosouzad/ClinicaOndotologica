package br.com.digitalhouse.Clinica.odontologica.app.api.controller;

import br.com.digitalhouse.Clinica.odontologica.app.api.DentistaApi;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.dentista.CreateDentistaRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.clinica.ClinicaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta.ConsultaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta.ConsultaSummaryResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.dentista.DentistaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.dentista.DentistaSummaryResponse;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Consulta;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Dentista;
import br.com.digitalhouse.Clinica.odontologica.domain.service.DentistaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class DentistaController implements DentistaApi {

    private final DentistaService dentistaService;
    private final ObjectMapper mapper;

    @Autowired
    public DentistaController(DentistaService dentistaService, ObjectMapper mapper) {
        this.dentistaService = dentistaService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<DentistaSummaryResponse>> buscarDentista(Pageable page) {
        Page<Dentista> dentistaPage = dentistaService.buscarTodosDentista(page);
        Page<DentistaSummaryResponse> response = dentistaPage
                .map(dentista -> new DentistaSummaryResponse(dentista.getId(), dentista.getNome(), dentista.getEspecialidade()));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<DentistaDetailedResponse> criarDentista(CreateDentistaRequest request) {

        Dentista dentista = mapper.convertValue(request, Dentista.class);
        Dentista dentistaCriado = dentistaService.criarDentista(dentista);
        DentistaDetailedResponse dentistaDetailedResponse = dentistaParaDetailedResponse(dentistaCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(dentistaDetailedResponse);
    }

    @Override
    public ResponseEntity<DentistaDetailedResponse> buscarDentistaPorID(UUID id) {
        Dentista dentista = dentistaService.buscarDentistaPorID(id);
        DentistaDetailedResponse dentistaDetailedResponse = dentistaParaDetailedResponse(dentista);
        return ResponseEntity.ok(dentistaDetailedResponse);
    }

    @Override
    public ResponseEntity<DentistaDetailedResponse> atualizarDentistaporID(UUID id, Map<String, Object> campos) {
        Dentista dentista = dentistaService.atualizarDentista(id, campos);
        DentistaDetailedResponse dentistaDetailedResponse = dentistaParaDetailedResponse(dentista);
        return ResponseEntity.ok().body(dentistaDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> excluirDentistaPorID(UUID id) {
        dentistaService.excluirDentista(id);
        return ResponseEntity.noContent().build();
    }

    private DentistaDetailedResponse dentistaParaDetailedResponse(Dentista dentista) {
        return mapper.convertValue(dentista, DentistaDetailedResponse.class);
    }
}
