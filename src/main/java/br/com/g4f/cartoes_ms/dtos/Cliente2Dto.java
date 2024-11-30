package br.com.g4f.cartoes_ms.dtos;

import br.com.g4f.cartoes_ms.entities.Cliente;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Cliente2Dto(
        @NotBlank(message = "Informe o nome completo do cliete")
        String nomeCompleto,
        @NotBlank(message = "Informe o cpf do cliente")
        String cpf,
        @NotNull(message = "Informa a data de nascimento do cliente")
        @Past(message = "A data de nascimento deve ser anterior a data atual")
        LocalDate dataNascimento,
        @NotNull(message = "Informe o estado civil do cliente - (1.:SOLTEIRO(A) / 2.:CASADO(A) / 3.:VIUVO(A) / 4.:DIVOCIADO(A))")
        String estadoCivil,
        @NotBlank(message = "E-mail do cliente deve ser informado")
        String email,
        @NotNull(message = "Informe a valor da renda mensal do cliente")
        @DecimalMin(value = "100", inclusive = true, message = "Valor insuficiente, valor precisa ser superior a  100")
        BigDecimal rendaMensal,
        @NotNull(message = "Informe a data que o cliente abriu sua conta")
        @Past(message = "A data de abertura da conta deve ser anterior a data atual")
        LocalDate contaAberta
) {

    public Cliente getCliente() {
        return new Cliente(null, this.nomeCompleto, this.cpf, this.dataNascimento, this.estadoCivil, this.rendaMensal, this.email,this.contaAberta);
    }

}
