package br.com.g4f.cartoes_ms.repositories;

import br.com.g4f.cartoes_ms.entities.Cliente;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ClienteRepositoy extends JpaRepository<Cliente,Long> {
    Cliente findByCpfAndDataNascimento(@Param("cpf") String cpf, @Param("dataNascimento") LocalDate dataNascimento);

    Cliente findByCpf(String cpf);
}
