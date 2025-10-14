package com.example.demo.validacoes;

import com.example.demo.dto.CriarReservaDto;
import com.example.demo.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoDataInicioEFim implements ValidacaoCriacaoReserva {

    @Override
    public void validar(CriarReservaDto dto) {
        if (dto.inicioReserva().isAfter(dto.finalReserva())) {
            throw new ValidacaoException("A data de início deve ser anterior à data de fim.");
        }
    }
}
