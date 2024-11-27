package br.com.g4f.cartoes_ms.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
public class ClienteEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long       id;
    private String     nome;
    private String     cpf;
    private LocalDate  dataNascimento;
    private String     nomeSocial;
    private String     st_civil;
    private BigDecimal rendaMensal;

    public ClienteEntity() {
    }

    public ClienteEntity(Long id, String nome, String cpf, LocalDate dataNascimento, String nomeSocial, String st_civil, BigDecimal rendaMensal) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.nomeSocial = nomeSocial;
        this.st_civil = st_civil;
        this.rendaMensal = rendaMensal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getSt_civil() {
        return st_civil;
    }

    public void setSt_civil(String st_civil) {
        this.st_civil = st_civil;
    }

    public BigDecimal getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(BigDecimal rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nomeSocial='" + nomeSocial + '\'' +
                ", st_civil='" + st_civil + '\'' +
                ", rendaMensal=" + rendaMensal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClienteEntity that = (ClienteEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
