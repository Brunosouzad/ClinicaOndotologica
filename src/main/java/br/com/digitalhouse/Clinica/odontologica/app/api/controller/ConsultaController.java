package br.com.digitalhouse.Clinica.odontologica.app.api.controller;

import br.com.digitalhouse.Clinica.odontologica.app.api.ConsultaApi;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.consulta.CreateConsultaRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.clinica.ClinicaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta.ConsultaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta.ConsultaSummaryResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.dentista.DentistaSummaryResponse;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Consulta;
import br.com.digitalhouse.Clinica.odontologica.domain.service.ConsultaService;
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
public class ConsultaController implements ConsultaApi {
    private final ConsultaService consultaService;
    private final ObjectMapper mapper;

    @Autowired
    public ConsultaController(ConsultaService consultaService, ObjectMapper mapper) {
        this.consultaService = consultaService;
        this.mapper = mapper;
    }


    @Override
    public ResponseEntity<Page<ConsultaSummaryResponse>> buscarConsulta(Pageable page) {
        Page<Consulta> consultaPage = consultaService.buscarTodasConsulta(page);
        Page<ConsultaSummaryResponse> response = consultaPage
                .map(consulta -> new ConsultaSummaryResponse(consulta.getId(), consulta.getPaciente(), consulta.getDentistas(), consulta.getDataDaConsulta()));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ConsultaDetailedResponse> criarConsulta(CreateConsultaRequest request) {
        Consulta consulta = mapper.convertValue(request, Consulta.class);
        Consulta consultaCriada = consultaService.criarConsulta(consulta);
        ConsultaDetailedResponse consultaDetailedResponse = consultaParaDetailedResponse(consultaCriada);
        return ResponseEntity.status(HttpStatus.CREATED).body(consultaDetailedResponse);
    }

    @Override
    public ResponseEntity<ConsultaDetailedResponse> buscarConsultaPorId(UUID id) {
        Consulta consulta = consultaService.buscarConsultaPorID(id);
        ConsultaDetailedResponse consultaDetailedResponse = consultaParaDetailedResponse(consulta);
        return ResponseEntity.ok(consultaDetailedResponse);
    }

    @Override
    public ResponseEntity<ConsultaDetailedResponse> atualizarConsultaPorId(UUID id, Map<String, Object> campos) {
        Consulta consulta = consultaService.atualizarConsulta(id, campos);
        ConsultaDetailedResponse consultaDetailedResponse = consultaParaDetailedResponse(consulta);
        return ResponseEntity.ok().body(consultaDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> excluirConsultaPorId(UUID id) {
        consultaService.excluirConsulta(id);
        return ResponseEntity.noContent().build();
    }

    private ConsultaDetailedResponse consultaParaDetailedResponse(Consulta consulta) {
        return mapper.convertValue(consulta, ConsultaDetailedResponse.class);
    }
}
