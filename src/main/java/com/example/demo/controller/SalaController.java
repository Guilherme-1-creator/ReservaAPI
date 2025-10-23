package com.example.demo.controller;

import com.example.demo.dto.CadastroSalaDTO;
import com.example.demo.dto.SalaDTO;
import com.example.demo.exception.ValidacaoException;
import com.example.demo.service.SalaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@SecurityRequirement(name = "bearer-key")
public class SalaController {

    @Autowired
    private SalaService service;

    @GetMapping
    public ResponseEntity<List<SalaDTO>> listar() {
        List<SalaDTO> salas = service.listar();
        return ResponseEntity.ok().body(salas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> listarPorId(@PathVariable Long id) {
        SalaDTO sala = service.listarPorId(id);
        return ResponseEntity.ok().body(sala);
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastroSalaDTO dto) {
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
