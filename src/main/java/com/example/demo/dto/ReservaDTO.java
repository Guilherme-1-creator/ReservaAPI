package com.example.demo.dto;

import com.example.demo.model.Reserva;
import com.example.demo.model.Sala;
import com.example.demo.model.Usuario;
import com.example.demo.model.enums.StatusReserva;

import java.time.LocalDateTime;

public record ReservaDTO(Long id, LocalDateTime dataReserva, LocalDateTime inicioReserva, LocalDateTime finalReserva, StatusReserva status, Usuario usuario, Sala sala) {

    public ReservaDTO(Reserva reserva) {
        this(reserva.getId(), reserva.getDataReserva(), reserva.getInicioReserva(), reserva.getFinalReserva(), reserva.getStatus(), reserva.getUsuario(), reserva.getSala());

    }

}
