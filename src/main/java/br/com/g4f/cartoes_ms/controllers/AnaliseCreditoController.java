package br.com.g4f.cartoes_ms.controllers;

import br.com.g4f.cartoes_ms.dtos.ClienteDto;
import br.com.g4f.cartoes_ms.entities.PropostaCredito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api/v1/propostas")
public class AnaliseCreditoController {

//    @Autowired
//    private PropostaService propostaService;

//    @PostMapping
    public ResponseEntity<String> consultar(@RequestBody  ClienteDto clienteDto) {
        return null; //propostaService.get(clienteDto);
    }

//    @GetMapping("/{id}")
    public ResponseEntity<List<PropostaCredito>> getById(@PathVariable Long id) {
        return null; //propostaService.getById(id);
    }

}
