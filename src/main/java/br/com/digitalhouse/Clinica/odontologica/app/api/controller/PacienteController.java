package br.com.digitalhouse.Clinica.odontologica.app.api.controller;

import br.com.digitalhouse.Clinica.odontologica.app.api.PacienteApi;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.dentista.CreateDentistaRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.paciente.CreatePacienteRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.dentista.DentistaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.dentista.DentistaSummaryResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.paciente.PacienteDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.paciente.PacienteSummaryResponse;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Dentista;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Paciente;
import br.com.digitalhouse.Clinica.odontologica.domain.service.PacienteService;
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
public class PacienteController implements PacienteApi {

    private final PacienteService pacienteService;
    private final ObjectMapper mapper;


    @Autowired
    public PacienteController(PacienteService pacienteService, ObjectMapper mapper) {
        this.pacienteService = pacienteService;
        this.mapper = mapper;
    }



    @Override
    public ResponseEntity<Page<PacienteSummaryResponse>> buscarPaciente (Pageable page) {
        Page<Paciente> pacientePage = pacienteService.buscarTodosPaciente(page);
        Page<PacienteSummaryResponse> response = pacientePage
                .map(paciente -> new PacienteSummaryResponse(paciente.getId(), paciente.getNome()));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<PacienteDetailedResponse> criarPaciente(CreatePacienteRequest request) {

        Paciente paciente = mapper.convertValue(request, Paciente.class);
        Paciente pacienteCriado = pacienteService.criarPaciente(paciente);
        PacienteDetailedResponse pacienteDetailedResponse = pacienteParaDetailedResponse(pacienteCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteDetailedResponse);
    }

    @Override
    public ResponseEntity<PacienteDetailedResponse> buscarPacienteporID (UUID id) {
        Paciente paciente = pacienteService.buscarPacientePorID(id);
        PacienteDetailedResponse pacienteDetailedResponse = pacienteParaDetailedResponse(paciente);
        return ResponseEntity.ok(pacienteDetailedResponse);
    }

    @Override
    public ResponseEntity<PacienteDetailedResponse> atualizaPacientePorID(UUID id, Map<String, Object> campos) {
        Paciente paciente = pacienteService.atualizarPaciente(id, campos);
        PacienteDetailedResponse pacienteDetailedResponse = pacienteParaDetailedResponse(paciente);
        return ResponseEntity.ok().body(pacienteDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> excluirPacienteporID(UUID id) {
        pacienteService.excluirPaciente(id);
        return ResponseEntity.noContent().build();
    }

    private PacienteDetailedResponse pacienteParaDetailedResponse(Paciente paciente) {
        return mapper.convertValue(paciente, PacienteDetailedResponse.class);
    }
}