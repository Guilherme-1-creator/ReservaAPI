package com.example.demo.dto;

import com.example.demo.model.Usuario;

public record UsuarioDTO(Long id, String nome) {

    public UsuarioDTO(Usuario usuario) {
        this(usuario.getId(), usuario.getNome());
    }
}
