package br.com.g4f.cartoes_ms.controllers;

import br.com.g4f.cartoes_ms.dtos.ClienteDto;
import br.com.g4f.cartoes_ms.entities.PropostaCredito;
import br.com.g4f.cartoes_ms.services.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/propostas")
public class AnaliseCreditoController {

    @Autowired
    private PropostaService propostaService;

    @GetMapping
    public ResponseEntity<List<PropostaCredito>> findAll() {
        return propostaService.findAll();
    }
    @PostMapping(value = "/{idClient}")
    public ResponseEntity<PropostaCredito> generate(@PathVariable Long idClient) {
        return propostaService.generate(idClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id) {
        return propostaService.getCard(id);
    }
}
