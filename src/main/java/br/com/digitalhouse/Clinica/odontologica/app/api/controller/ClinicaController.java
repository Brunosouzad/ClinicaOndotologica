package br.com.digitalhouse.Clinica.odontologica.app.api.controller;

import br.com.digitalhouse.Clinica.odontologica.app.api.ClinicaApi;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.CreateClinicaRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.ClinicaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.ClinicaSummaryResponse;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.service.ClinicaService;
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
public class ClinicaController implements ClinicaApi {
    private final ClinicaService clinicaService;
    private final ObjectMapper objectMapper;

    @Autowired
    public ClinicaController(ClinicaService clinicaService, ObjectMapper objectMapper) {
        this.clinicaService = clinicaService;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<Page<ClinicaSummaryResponse>> buscarClinica(Pageable page) {
        Page<Clinica> clinicaPage = clinicaService.buscarTodasClinicas(page);
        Page<ClinicaSummaryResponse> response = clinicaPage
                .map(clinica -> new ClinicaSummaryResponse(clinica.getId(), clinica.getNome(), clinica.getCnpj()));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ClinicaDetailedResponse> criarClinica(CreateClinicaRequest request) {
        Clinica clinica = objectMapper.convertValue(request, Clinica.class);
        Clinica clinicaCriada = clinicaService.criarClinica(clinica);
        ClinicaDetailedResponse clinicaDetailedResponse = clinicaParaClinicaDetailedResponse(clinicaCriada);
        return ResponseEntity.status(HttpStatus.CREATED).body(clinicaDetailedResponse);
    }

    @Override
    public ResponseEntity<ClinicaDetailedResponse> atualizarClinicaPorId(UUID id, Map<String, Object> campos) {
        Clinica clinica = clinicaService.atualizarClinica(id, campos);
        ClinicaDetailedResponse clinicaDetailedResponse = clinicaParaClinicaDetailedResponse(clinica);
        return ResponseEntity.ok().body(clinicaDetailedResponse);
    }

    @Override
    public ResponseEntity<ClinicaDetailedResponse> buscarClinicaPorId(UUID id) {
            Clinica clinica = clinicaService.buscarClinicaPorID(id);
            ClinicaDetailedResponse clinicaDetailedResponse = clinicaParaClinicaDetailedResponse(clinica);
             return ResponseEntity.ok(clinicaDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> excluirClinicaPorId(UUID id) {
        clinicaService.excluirClinicar(id);
        return ResponseEntity.noContent().build();
    }


    private ClinicaDetailedResponse clinicaParaClinicaDetailedResponse(Clinica clinica) {
        return objectMapper.convertValue(clinica, ClinicaDetailedResponse.class);
    }


}
