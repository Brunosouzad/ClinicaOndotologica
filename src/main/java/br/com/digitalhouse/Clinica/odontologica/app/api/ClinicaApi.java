package br.com.digitalhouse.Clinica.odontologica.app.api;

import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.clinica.CreateClinicaRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.clinica.ClinicaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.clinica.ClinicaSummaryResponse;
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

@RequestMapping("v1/clinicas")
@Tag(name = "Clinica", description = "Clinica API")

public interface ClinicaApi {
    @GetMapping
    @Operation(summary = "Buscar todas Clinica", description = "Retorna uma lista de Clinicas")
    @ApiResponse(responseCode = "200", description = "Sucesso!", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Clinica.class))})
    @ApiResponse(responseCode = "401", description = "Requer Autorização", content = {@Content(schema = @Schema())})
    @ApiResponse(responseCode = "500", description = "Erro no servidor", content = {@Content( schema = @Schema())})
    ResponseEntity<Page<ClinicaSummaryResponse>> buscarClinica(@PageableDefault Pageable page);
    @PostMapping
    @Operation(summary = "Criar Clinica", description = "Retorna uma Clinica Criada")

    ResponseEntity<ClinicaDetailedResponse> criarClinica(@RequestBody @Valid CreateClinicaRequest request);

    @GetMapping("{id}")
    @Operation(summary = "Buscar Clinica", description = "Retorna uma Clinica que foi buscada pelo ID")
    ResponseEntity<ClinicaDetailedResponse> buscarClinicaPorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    @Operation(summary = "Atualizar Clinica", description = "Autliza cliica por ID")
    ResponseEntity<ClinicaDetailedResponse> atualizarClinicaPorId(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

    @DeleteMapping("{id}")
    @Operation(summary = "Excluir Clinica", description = "Exclui Clinica selecionada por ID")
    ResponseEntity<Void> excluirClinicaPorId(@PathVariable UUID id);
}
