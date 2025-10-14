package com.example.demo.dto;

import com.example.demo.model.Sala;

public record SalaDto(Long id,String codigo,Integer capacidade, boolean ativa) {

    public SalaDto (Sala sala){
        this(sala.getId(),sala.getCodigo(), sala.getCapacidade(), sala.isAtiva());
    }
}
