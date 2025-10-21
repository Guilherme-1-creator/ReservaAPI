package com.example.demo.controller;


import com.example.demo.dto.CadastroUsuarioDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.exception.ValidacaoException;
import com.example.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listar(){
        List<UsuarioDTO> usuarios = service.listar();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> listarPorId(@PathVariable Long id){
        UsuarioDTO usuario = service.listarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<String> criarUsuario(@RequestBody @Valid CadastroUsuarioDTO dto){
        try {
            service.criarUsuario(dto);
            return ResponseEntity.ok("Usuário cadastrado!");
        } catch (ValidacaoException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        try {
            service.remover(id);
            return ResponseEntity.ok("Usuário deletado");
        } catch (ValidacaoException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

