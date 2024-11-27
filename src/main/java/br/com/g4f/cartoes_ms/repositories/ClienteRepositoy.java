package br.com.g4f.cartoes_ms.repositories;

import br.com.g4f.cartoes_ms.dtos.ClienteDto;
import br.com.g4f.cartoes_ms.entities.ClienteEntity;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ClienteRepositoy extends JpaRepository<ClienteEntity,Long> {
    ClienteEntity findByCpfAndDataNascimento(String cpf, LocalDate dataNascimento);
}
