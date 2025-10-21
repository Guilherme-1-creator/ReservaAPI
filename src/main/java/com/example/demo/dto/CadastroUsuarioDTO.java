package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroUsuarioDTO(@NotBlank String nome, @NotBlank String email, @NotBlank String senha, @NotBlank String telefone) {
}
