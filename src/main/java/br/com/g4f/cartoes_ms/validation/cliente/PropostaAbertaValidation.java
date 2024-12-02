package br.com.g4f.cartoes_ms.validation.cliente;

import br.com.g4f.cartoes_ms.entities.Cliente;
import br.com.g4f.cartoes_ms.entities.PropostaCredito;
import br.com.g4f.cartoes_ms.validation.ValidationDefault;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;

@Component
public class PropostaAbertaValidation implements ValidationDefault<Cliente> {

    @Override
    public void validate(Cliente cliente) {
        LocalDate dataLimite = LocalDate.now().minusDays(30);
        PropostaCredito propostaCredito = cliente.getPropostaCreditos()
                                                  .stream()
                                                  .filter(p->p.getData().isAfter(dataLimite))
                                                  .max(Comparator.comparing(PropostaCredito::getId))
                                                  .orElse(null);
        if(propostaCredito != null) {
            throw new RuntimeException("Existe uma proposta pendente, Proposta Nº"+propostaCredito.getId());
        }

    }

}
