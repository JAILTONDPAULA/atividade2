package br.com.g4f.cartoes_ms.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ClienteDto(
        @NotBlank(message = "necessário informar o cpf do cliente")
        String cpf,
        @NotNull(message = "necessário informar a data de nascimento do cliente")
        LocalDate dataNascimento
) {
}
