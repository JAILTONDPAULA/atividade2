package br.com.g4f.cartoes_ms.services;

import br.com.g4f.cartoes_ms.dtos.ClienteDto;
import br.com.g4f.cartoes_ms.entities.Cliente;
import br.com.g4f.cartoes_ms.repositories.ClienteRepositoy;
import br.com.g4f.cartoes_ms.validation.CreditoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositoy clienteRepositoy;

    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteRepositoy.findAll());
    }

}
