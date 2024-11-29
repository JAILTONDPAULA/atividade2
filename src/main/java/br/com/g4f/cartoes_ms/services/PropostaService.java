package br.com.g4f.cartoes_ms.services;

import br.com.g4f.cartoes_ms.dtos.ClienteDto;
import br.com.g4f.cartoes_ms.entities.Cliente;
import br.com.g4f.cartoes_ms.entities.PropostaCredito;
import br.com.g4f.cartoes_ms.repositories.ClienteRepositoy;
import br.com.g4f.cartoes_ms.repositories.PropostaRepository;
import br.com.g4f.cartoes_ms.validation.CreditoValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@Service
public class PropostaService {

    private ClienteRepositoy clienteRepositoy;
    private PropostaRepository propostaRepository;
    private List<CreditoValidation> regras;

    @Autowired
    public PropostaService(ClienteRepositoy clienteRepositoy, PropostaRepository propostaRepository, List<CreditoValidation> regras) {
        this.clienteRepositoy = clienteRepositoy;
        this.propostaRepository = propostaRepository;
        this.regras = regras;
    }

    public ResponseEntity<String> get(ClienteDto clienteDto) {
        Cliente cliente =  clienteRepositoy.findByCpfAndDataNascimento(clienteDto.cpf(),clienteDto.dataNascimento());
        if(cliente == null) {
            throw new RuntimeException("Cliente não encontrado na base de dados");
        }
        regras.forEach(r->r.valid(cliente));
        return gerarProposta(cliente);
    }


    private ResponseEntity<String> gerarProposta(Cliente cliente) {
        PropostaCredito propostaCredito  = new PropostaCredito(null, LocalDate.now(), valorProposta(cliente.getRendaMensal()),"1",cliente);
        PropostaCredito propostaCredito1 = propostaRepository.save(propostaCredito);
        BigDecimal      valorAprovado    = propostaCredito1.getValorAprovado().setScale(2, RoundingMode.HALF_EVEN);
        NumberFormat    format           = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
        String          messageProposta  = "Proposta de crédito Nº\""+propostaCredito1.getId()+"\" aprovada com valor de R$ "+format.format(valorAprovado)+", deseja contratar?";
        return ResponseEntity.status(HttpStatus.CREATED).body(messageProposta);
    }

    public BigDecimal valorProposta(BigDecimal renda) {
        return renda.multiply(new BigDecimal("0.3"));
    }


    public ResponseEntity<List<PropostaCredito>> getById(Long id) {
        List<PropostaCredito> propostaCredito = propostaRepository.findByClienteId(id);
        return ResponseEntity.ok(propostaCredito);
    }
}
