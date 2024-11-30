package br.com.g4f.cartoes_ms.controllers;

import br.com.g4f.cartoes_ms.dtos.Cliente2Dto;
import br.com.g4f.cartoes_ms.dtos.Cliente3Dto;
import br.com.g4f.cartoes_ms.entities.Cliente;
import br.com.g4f.cartoes_ms.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<List<Cliente>> findAll() {
        return clienteService.findAll();
    }

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente2Dto clienteDto) {
        return clienteService.save(clienteDto);
    }

    @PutMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Cliente> put(@PathVariable Long id, @RequestBody @Valid Cliente3Dto clienteDto) {
        return clienteService.put(id,clienteDto);
    }



}
