package br.com.g4f.cartoes_ms.validation.cliente;

import br.com.g4f.cartoes_ms.entities.Cliente;
import br.com.g4f.cartoes_ms.validation.ValidationDefault;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class IdadeCreditoValidation implements ValidationDefault<Cliente> {

    @Override
    public void validate(Cliente cliente) {
        if(18 >= Period.between(cliente.getDataNascimento(),LocalDate.now()).getYears()){
            throw new RuntimeException("Idade inferior a permitida");
        }
    }

}

