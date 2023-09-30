package br.com.digitalhouse.Clinica.odontologica.app.api;

import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.consulta.CreateConsultaRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.dentista.CreateDentistaRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.clinica.ClinicaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta.ConsultaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.consulta.ConsultaSummaryResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.dentista.DentistaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.dentista.DentistaSummaryResponse;
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


    @RequestMapping("v1/dentista")
    @Tag(name = "dentista", description = "dentista API")

    public interface DentistaApi {
        @GetMapping
        @Operation(summary = "Buscar todos dentista por paginação", description = "Retorna uma lista paginada de dentista")
        @ApiResponse(responseCode = "200", description = "Sucesso!", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Clinica.class))})
        @ApiResponse(responseCode = "401", description = "Requer Autorização", content = {@Content(schema = @Schema())})
        @ApiResponse(responseCode = "500", description = "Erro no servidor", content = {@Content(schema = @Schema())})
        ResponseEntity<Page<DentistaSummaryResponse>> buscarDentista(@PageableDefault Pageable page);

        @PostMapping
        @Operation(summary = "Criar Dentista", description = "Retorna um Dentista criado")
        ResponseEntity<DentistaDetailedResponse> criarDentista(@RequestBody @Valid CreateDentistaRequest request);

        @GetMapping("{id}")
        @Operation(summary = "Buscar dentista por ID", description = "Retorna uma Dentista que foi buscado pelo ID")
        ResponseEntity<DentistaDetailedResponse> buscarDentistaPorID(@PathVariable UUID id);

        @PatchMapping("{id}")
        @Operation(summary = "Atualizar Dentista", description = "Atualiza campos do dentista por ID")
        ResponseEntity<DentistaDetailedResponse> atualizarDentistaporID(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

        @DeleteMapping("{id}")
        @Operation(summary = "Excluir Dentista", description = "Excluir Dentista selecionado por ID")
        ResponseEntity<Void> excluirDentistaPorID(@PathVariable UUID id);
    }

