package com.example.demo.dto;

import com.example.demo.model.Usuario;

public record UsuarioDto(Long id, String nome) {

    public UsuarioDto(Usuario usuario) {
        this(usuario.getId(), usuario.getNome());
    }
}
