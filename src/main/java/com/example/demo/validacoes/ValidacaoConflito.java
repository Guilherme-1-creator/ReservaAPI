package com.example.demo.validacoes;

import com.example.demo.dto.CriarReservaDTO;
import com.example.demo.exception.ValidacaoException;
import com.example.demo.model.Reserva;
import com.example.demo.model.enums.StatusReserva;
import com.example.demo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoConflito implements ValidacaoCriacaoReserva {

    @Autowired
    private ReservaRepository repository;

    @Override
    public void validar(CriarReservaDTO dto) {
        List<Reserva> reservasExistentes = repository.findAll();
        for (Reserva existente : reservasExistentes) {

            if (existente.getStatus() != StatusReserva.ATIVA) continue;

            if (!existente.getSala().getId().equals(dto.salaId())) continue;

            boolean conflita = dto.inicioReserva().isBefore(existente.getFinalReserva())
                    && existente.getInicioReserva().isBefore(dto.finalReserva());

            if (conflita) {
                throw new ValidacaoException("Conflito de reserva: já existe uma reserva ativa sobreposta para esta sala.");
            }
        }
    }
}

