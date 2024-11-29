package br.com.g4f.cartoes_ms.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long       id;
    private String     nome;
    private String     cpf;
    private LocalDate  dataNascimento;
    private String     stCivil;
    private BigDecimal rendaMensal;
    private String     eMail;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<PropostaCredito> propostaCreditos = new ArrayList<>();

}
