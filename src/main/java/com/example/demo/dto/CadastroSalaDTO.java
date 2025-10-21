package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroSalaDTO(@NotBlank String codigo, @NotBlank Integer capacidade, @NotBlank Boolean ativa) {
}
