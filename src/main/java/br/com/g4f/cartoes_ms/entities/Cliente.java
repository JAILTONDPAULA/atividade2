package br.com.g4f.cartoes_ms.entities;

import br.com.g4f.cartoes_ms.dtos.Cliente3Dto;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "cliente")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long       id;
    private String     nomeCompleto;
    private String     cpf;
    private LocalDate  dataNascimento;
    private String     stCivil;
    private BigDecimal rendaMensal;
    private String     eMail;
    private LocalDate  aberturaConta;

    public void update(Cliente3Dto cliente) {
        if( cliente.nomeCompleto()   != null ) { this.nomeCompleto  = cliente.nomeCompleto(); }
        if( cliente.cpf()            != null ) { this.cpf           = cliente.cpf();          }
        if( cliente.estadoCivil()    != null ) { this.stCivil       = cliente.estadoCivil();  }
        if( cliente.rendaMensal()    != null ) { this.rendaMensal   = cliente.rendaMensal();  }
        if( cliente.email()          != null ) { this.eMail         = cliente.email();        }
        if( cliente.contaAberta()    != null ) { this.aberturaConta = cliente.contaAberta();  }
    }

    @OneToMany(mappedBy = "cliente")
    private List<PropostaCredito> propostaCreditos = new ArrayList<>();

}
