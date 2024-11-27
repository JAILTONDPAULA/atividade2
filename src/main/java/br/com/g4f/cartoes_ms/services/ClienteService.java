package br.com.g4f.cartoes_ms.services;

import br.com.g4f.cartoes_ms.dtos.ClienteDto;
import br.com.g4f.cartoes_ms.entities.ClienteEntity;
import br.com.g4f.cartoes_ms.repositories.ClienteRepositoy;
import br.com.g4f.cartoes_ms.validation.CreditoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepositoy clienteRepositoy;

    private List<CreditoValidation> regras;

    @Autowired
    public ClienteService(List<CreditoValidation> regras) {
        this.regras = regras;
    }

    public ResponseEntity<String> solicitarCredito(ClienteDto clienteDto) {
        ClienteEntity cliente =  clienteRepositoy.findByCpfAndDataNascimento(clienteDto.cpf(),clienteDto.dataNascimento());
        if(cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado na base de dados");
        }
        regras.forEach(r -> r.valid(cliente));


        return null;
    }

}
