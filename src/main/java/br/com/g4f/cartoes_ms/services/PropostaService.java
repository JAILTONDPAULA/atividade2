package br.com.g4f.cartoes_ms.services;

import br.com.g4f.cartoes_ms.dtos.CartaoDto;
import br.com.g4f.cartoes_ms.entities.Cliente;
import br.com.g4f.cartoes_ms.entities.PropostaCredito;
import br.com.g4f.cartoes_ms.repositories.ClienteRepositoy;
import br.com.g4f.cartoes_ms.repositories.PropostaRepository;
import br.com.g4f.cartoes_ms.services.clients.CartaoClient;
import br.com.g4f.cartoes_ms.validation.ValidationDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PropostaService {

    private final PropostaRepository               propostaRepository;
    private final ClienteRepositoy                 clienteRepositoy;
    private final List<ValidationDefault<Cliente>> regras;
    private final CartaoClient                     cartaoClient;

    @Autowired
    public PropostaService(ClienteRepositoy clienteRepositoy, PropostaRepository propostaRepository, List<ValidationDefault<Cliente>> regras, CartaoClient cartaoClient) {
        this.clienteRepositoy   = clienteRepositoy;
        this.propostaRepository = propostaRepository;
        this.regras             = regras;
        this.cartaoClient       = cartaoClient;
    }

    public ResponseEntity<List<PropostaCredito>> findAll() {
        return ResponseEntity.ok(propostaRepository.findAll());
    }

    public ResponseEntity<PropostaCredito> generate(Long idCliente) {
        Cliente cliente = clienteRepositoy.findById(idCliente).orElseThrow(()->new RuntimeException("Cliente não encontrado na base de dados"));
        regras.forEach(r->r.validate(cliente));
        return ResponseEntity.status(HttpStatus.CREATED).body(gerarProposta(cliente));
    }

    public ResponseEntity<String> getCard(Long id) {
        Mono<CartaoDto> cartao = this.cartaoClient.getCard(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartao.block().message());
    }

    private PropostaCredito gerarProposta(Cliente cliente) {
        PropostaCredito propostaCredito  = new PropostaCredito(null, LocalDate.now(), valorProposta(cliente.getRendaMensal()),"1",cliente);
        return propostaRepository.save(propostaCredito);
    }

    private BigDecimal valorProposta(BigDecimal renda) {
        return renda.multiply(new BigDecimal("0.3"));
    }

}
