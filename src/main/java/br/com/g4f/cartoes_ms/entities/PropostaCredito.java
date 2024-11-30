package br.com.g4f.cartoes_ms.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"cliente"})
//@Entity
//@Table
public class PropostaCredito implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long       id;
    private LocalDate  data;
    private BigDecimal valorAprovado;
    private String     status;

//    @ManyToOne
//    @JoinColumn(name = "fk_cliente")
//    @JsonBackReference
//    private Cliente cliente;




}
