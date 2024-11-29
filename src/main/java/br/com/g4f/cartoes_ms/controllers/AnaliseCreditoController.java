package br.com.g4f.cartoes_ms.controllers;

import br.com.g4f.cartoes_ms.dtos.ClienteDto;
import br.com.g4f.cartoes_ms.entities.PropostaCredito;
import br.com.g4f.cartoes_ms.services.PropostaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/propostas")
public class AnaliseCreditoController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<String> consultar(@RequestBody @Valid ClienteDto clienteDto) {
        return propostaService.get(clienteDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<PropostaCredito>> getById(@PathVariable Long id) {
        return propostaService.getById(id);
    }

}
