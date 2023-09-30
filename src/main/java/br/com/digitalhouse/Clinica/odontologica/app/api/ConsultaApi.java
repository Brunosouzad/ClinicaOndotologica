package br.com.digitalhouse.Clinica.odontologica.app.api;

import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.consulta.CreateConsultaRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta.ConsultaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta.ConsultaSummaryResponse;
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

    @RequestMapping("v1/consulta")
    @Tag(name = "Consulta", description = "Consulta API")

    public interface ConsultaApi {
        @GetMapping
        @Operation(summary = "Buscar todas Consulta", description = "Retorna uma lista de Consultas")
        @ApiResponse(responseCode = "200", description = "Sucesso!", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Clinica.class))})
        @ApiResponse(responseCode = "401", description = "Requer Autorização", content = {@Content(schema = @Schema())})
        @ApiResponse(responseCode = "500", description = "Erro no servidor", content = {@Content(schema = @Schema())})
        ResponseEntity<Page<ConsultaSummaryResponse>> buscarConsulta(@PageableDefault Pageable page);

        @PostMapping
        @Operation(summary = "Criar Consulta", description = "Retorna uma Consulta Criada")
        ResponseEntity<ConsultaDetailedResponse> criarConsulta(@RequestBody @Valid CreateConsultaRequest request);

        @GetMapping("{id}")
        @Operation(summary = "Buscar Consulta ID", description = "Retorna uma Consulta que foi buscada pelo ID")
        ResponseEntity<ConsultaDetailedResponse> buscarConsultaPorId(@PathVariable UUID id);

        @PatchMapping("{id}")
        @Operation(summary = "Atualizar Consulta", description = "Atualiza campos da consulta por ID")
        ResponseEntity<ConsultaDetailedResponse> atualizarConsultaPorId(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

        @DeleteMapping("{id}")
        @Operation(summary = "Excluir Consulta", description = "Excluir Consulta selecionada por ID")
        ResponseEntity<Void> excluirConsultaPorId(@PathVariable UUID id);

    }

