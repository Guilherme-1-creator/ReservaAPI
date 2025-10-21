package com.example.demo.dto;

import com.example.demo.model.enums.StatusReserva;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CriarReservaDTO(@NotBlank String codigo, @NotNull LocalDateTime dataReserva, @NotNull LocalDateTime inicioReserva, @NotNull LocalDateTime finalReserva, @NotNull StatusReserva status, @NotNull Long usuarioId, @NotNull Long salaId) {
}
