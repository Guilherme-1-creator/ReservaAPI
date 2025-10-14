package com.example.demo.controller;

import com.example.demo.dto.CadastroSalaDto;
import com.example.demo.dto.SalaDto;
import com.example.demo.exception.ValidacaoException;
import com.example.demo.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService service;

    @GetMapping
    public ResponseEntity<List<SalaDto>> listar() {
        List<SalaDto> salas = service.listar();
        return ResponseEntity.ok().body(salas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDto> listarPorId(@PathVariable Long id) {
        SalaDto sala = service.listarPorId(id);
        return ResponseEntity.ok().body(sala);
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody CadastroSalaDto dto) {
        try {
            service.criarSala(dto);
            return ResponseEntity.ok("Sala criada!");
        } catch (ValidacaoException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            service.remover(id);
            return ResponseEntity.ok().body("Sala deletada");
        } catch (ValidacaoException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
