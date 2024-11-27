package br.com.g4f.cartoes_ms.validation.impl;

import br.com.g4f.cartoes_ms.entities.ClienteEntity;
import br.com.g4f.cartoes_ms.validation.CreditoValidation;

import java.time.LocalDate;
import java.time.Period;

public class IdadeCreditoValidation implements CreditoValidation {

    @Override
    public void valid(ClienteEntity cliente) {
        if(!(18 >= Period.between(cliente.getDataNascimento(),LocalDate.now()).getYears())){
            throw new RuntimeException("Idade inferior a permitida");
        }
    }

}

