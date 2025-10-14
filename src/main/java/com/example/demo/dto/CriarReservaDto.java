package com.example.demo.dto;

import com.example.demo.model.enums.StatusReserva;
import java.time.LocalDateTime;

public record CriarReservaDto(String codigo, LocalDateTime dataReserva, LocalDateTime inicioReserva, LocalDateTime finalReserva, StatusReserva status, Long usuarioId, Long salaId) {
}
