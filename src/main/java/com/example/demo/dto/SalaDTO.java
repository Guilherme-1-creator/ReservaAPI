package com.example.demo.dto;

import com.example.demo.model.Sala;

public record SalaDTO(Long id, String codigo, Integer capacidade, boolean ativa) {

    public SalaDTO(Sala sala){
        this(sala.getId(),sala.getCodigo(), sala.getCapacidade(), sala.isAtiva());
    }
}
