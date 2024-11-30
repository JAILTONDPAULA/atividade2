package br.com.g4f.cartoes_ms.services;

import br.com.g4f.cartoes_ms.dtos.Cliente2Dto;
import br.com.g4f.cartoes_ms.dtos.Cliente3Dto;
import br.com.g4f.cartoes_ms.entities.Cliente;
import br.com.g4f.cartoes_ms.repositories.ClienteRepositoy;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepositoy clienteRepositoy;

    @Autowired
    public ClienteService(ClienteRepositoy clienteRepositoy) {
        this.clienteRepositoy = clienteRepositoy;
    }

    public ResponseEntity<List<Cliente>> findAll() {
        return ResponseEntity.ok(clienteRepositoy.findAll());
    }

    public ResponseEntity<Cliente> save(Cliente2Dto clienteDto) {
        Cliente cliente = clienteRepositoy.findByCpf(clienteDto.cpf());
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepositoy.save(clienteDto.getCliente()));
    }

    public ResponseEntity<Cliente> put(Long id, Cliente3Dto clienteDto) {
        Cliente cliente = clienteRepositoy.findById(id).orElseThrow(()->new EntityNotFoundException("Cliente não encontrado"));
        cliente.update(clienteDto);
        return ResponseEntity.ok(clienteRepositoy.save(cliente));
    }
}
