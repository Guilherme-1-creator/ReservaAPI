package com.example.demo.controller;

import com.example.demo.dto.CriarReservaDTO;
import com.example.demo.dto.ReservaDTO;
import com.example.demo.exception.ValidacaoException;
import com.example.demo.service.ReservaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@SecurityRequirement(name = "bearer-key")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<ReservaDTO>> listar() {
        List<ReservaDTO> reservas = service.listar();
        return ResponseEntity.ok().body(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDTO> listarPorId(@PathVariable Long id) {
        ReservaDTO dto = service.listarPorId(id);
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping
    public ResponseEntity<String> criarReserva(@RequestBody @Valid CriarReservaDTO dto) {
        try {
            service.criarReserva(dto);
            return ResponseEntity.ok().body("Reserva realizada!");
        } catch (ValidacaoException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelarReserva(@PathVariable Long id) {
        try {
            service.cancelarReserva(id);
            return ResponseEntity.ok().body("Reserva cancelada");
        } catch (ValidacaoException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
