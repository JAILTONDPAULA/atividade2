package br.com.g4f.cartoes_ms.repositories;

import br.com.g4f.cartoes_ms.entities.PropostaCredito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropostaRepository extends JpaRepository<PropostaCredito,Long> {

    List<PropostaCredito> findByClienteId(Long id);

}
