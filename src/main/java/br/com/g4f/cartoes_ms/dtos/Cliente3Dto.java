package br.com.g4f.cartoes_ms.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Cliente3Dto(
        String     nomeCompleto  ,
        String     cpf           ,
        @Past(message = "A data de nascimento deve ser anterior a data atual")
        LocalDate  dataNascimento,
        String     estadoCivil   ,
        String     email         ,
        @DecimalMin(value = "100", inclusive = true, message = "Valor insuficiente, valor precisa ser superior a  100")
        BigDecimal rendaMensal   ,
        @Past(message = "A data de abertura da conta deve ser anterior a data atual")
        LocalDate  contaAberta
) {
}
