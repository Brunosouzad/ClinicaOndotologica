package br.com.digitalhouse.Clinica.odontologica.app.api;

import br.com.digitalhouse.Clinica.odontologica.app.api.dto.request.CreateClinicaRequest;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.ClinicaDetailedResponse;
import br.com.digitalhouse.Clinica.odontologica.app.api.dto.response.ClinicaSummaryResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/clinicas")
public interface ClinicaApi {
    @GetMapping
    ResponseEntity<Page<ClinicaSummaryResponse>> buscarClinica(@PageableDefault Pageable page);

    @PostMapping
    ResponseEntity<ClinicaDetailedResponse> criarClinica(@RequestBody @Valid CreateClinicaRequest request);

    @GetMapping("{id}")
    ResponseEntity<ClinicaDetailedResponse> buscarClinicaPorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    ResponseEntity<ClinicaDetailedResponse> atualizarClinicaPorId(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirClinicaPorId(@PathVariable UUID id);
}
