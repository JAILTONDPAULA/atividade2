package br.com.g4f.cartoes_ms.controllers;

import br.com.g4f.cartoes_ms.entities.Cliente;
import br.com.g4f.cartoes_ms.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    private ResponseEntity<List<Cliente>> findAll() {
        return clienteService.findAll();
    }

}
