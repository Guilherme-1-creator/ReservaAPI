package com.example.demo.model;

import com.example.demo.dto.CadastroSalaDto;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "salas")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private Integer capacidade;

    private Boolean ativa = true;

    public Sala(String codigo, Integer capacidade, boolean ativa) {
        this.codigo = codigo;
        this.capacidade = capacidade;
        this.ativa = ativa;
    }

    public Sala(CadastroSalaDto dto) {
        this.codigo = dto.codigo();
        this.capacidade = dto.capacidade();
        this.ativa = dto.ativa();
    }

    public Sala() {
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Sala sala = (Sala) object;
        return Objects.equals(id, sala.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

}
