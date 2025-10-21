package com.example.demo.validacoes;

import com.example.demo.dto.CriarReservaDTO;
import com.example.demo.exception.ValidacaoException;
import com.example.demo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoUsuarioTemReserva implements ValidacaoCriacaoReserva {

    @Autowired
    private ReservaRepository repository;

    @Override
    public void validar(CriarReservaDTO dto) {
        boolean usuarioTemReserva = repository.existsByUsuarioId(dto.usuarioId());
        if (usuarioTemReserva) {
            throw new ValidacaoException("O usuário já possui uma reserva ativa.");
        }
    }
}
