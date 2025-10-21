package com.example.demo.validacoes;

import com.example.demo.dto.CriarReservaDTO;
import com.example.demo.exception.ValidacaoException;
import com.example.demo.model.Sala;

import com.example.demo.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoSalaCapacidade implements ValidacaoCriacaoReserva {

    @Autowired
    private SalaRepository repository;

    @Override
    public void validar(CriarReservaDTO dto) {
        Sala sala = repository.findById(dto.salaId()).orElseThrow(() -> new ValidacaoException("Sala não encontrada"));
        if (sala.getCapacidade() <= 0) {
            throw new ValidacaoException("A capacidade da sala deve ser maior que 0");
        }
    }
}
