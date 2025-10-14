package com.example.demo.validacoes;

import com.example.demo.dto.CriarReservaDto;
import com.example.demo.exception.ValidacaoException;
import com.example.demo.model.Sala;
import com.example.demo.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoSalaInativa implements ValidacaoCriacaoReserva{

    @Autowired
    private SalaRepository salaRepository;

    @Override
    public void validar(CriarReservaDto dto) {
        Sala sala = salaRepository.findById(dto.salaId()).orElseThrow(() -> new ValidacaoException("Sala não encontrada"));
        if (!sala.isAtiva()) {
            throw new ValidacaoException("Não é possivel reservar uma sala inativa");
        }
    }
}
