package com.example.demo.controller;

import com.example.demo.dto.CriarReservaDto;
import com.example.demo.dto.ReservaDto;
import com.example.demo.exception.ValidacaoException;
import com.example.demo.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping
    public ResponseEntity<List<ReservaDto>> listar() {
        List<ReservaDto> reservas = service.listar();
        System.out.println("Reservas encontradas: " + reservas.size());
        return ResponseEntity.ok().body(reservas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaDto> listarPorId(@PathVariable Long id) {
        ReservaDto dto = service.listarPorId(id);
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping
    public ResponseEntity<String> criarReserva(@RequestBody CriarReservaDto dto) {
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
