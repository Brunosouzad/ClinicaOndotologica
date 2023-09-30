package br.com.digitalhouse.Clinica.odontologica.app.api;

import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.consulta.CreateConsultaRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.paciente.CreatePacienteRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.clinica.ClinicaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta.ConsultaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta.ConsultaSummaryResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.paciente.PacienteDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.paciente.PacienteSummaryResponse;
import br.com.digitalhouse.Clinica.odontologica.domain.entity.Clinica;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/paciente")
@Tag(name = "paciente", description = "paciente API")
public interface PacienteApi {

        @GetMapping
        @Operation(summary = "Buscar todos pacientes por paginação", description = "Retorna uma lista paginada de pacientes")
        @ApiResponse(responseCode = "200", description = "Sucesso!", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Clinica.class))})
        @ApiResponse(responseCode = "401", description = "Requer Autorização", content = {@Content(schema = @Schema())})
        @ApiResponse(responseCode = "500", description = "Erro no servidor", content = {@Content(schema = @Schema())})
        ResponseEntity<Page<PacienteSummaryResponse>> buscarPaciente(@PageableDefault Pageable page);

        @PostMapping
        @Operation(summary = "Criar Paciente", description = "Retorna um Paciente criado")
        ResponseEntity<PacienteDetailedResponse> criarPaciente(@RequestBody @Valid CreatePacienteRequest request);

        @GetMapping("{id}")
        @Operation(summary = "Buscar paciente por ID", description = "Retorna um paciente que foi buscado pelo ID")
        ResponseEntity<PacienteDetailedResponse> buscarPacienteporID(@PathVariable UUID id);

        @PatchMapping("{id}")
        @Operation(summary = "Atualizar Paciente", description = "Atualiza campos do paciente por ID")
        ResponseEntity<PacienteDetailedResponse> atualizaPacientePorID(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

        @DeleteMapping("{id}")
        @Operation(summary = "Excluir Dentista", description = "Excluir Paciente selecionado por ID")
        ResponseEntity<Void> excluirPacienteporID(@PathVariable UUID id);
    }


