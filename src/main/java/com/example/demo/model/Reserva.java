package com.example.demo.model;

import com.example.demo.model.enums.StatusReserva;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private LocalDateTime dataReserva;

    private LocalDateTime inicioReserva;

    private LocalDateTime finalReserva;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    @ManyToOne
    private Usuario usuario;

    @OneToOne
    private Sala sala;

    public Reserva(String codigo, LocalDateTime dataReserva, LocalDateTime inicioReserva, LocalDateTime finalReserva, Usuario usuario, Sala sala) {
        this.codigo = codigo;
        this.dataReserva = dataReserva;
        this.inicioReserva = inicioReserva;
        this.finalReserva = finalReserva;
        this.status = StatusReserva.ATIVA;
        this.usuario = usuario;
        this.sala = sala;
    }

    public Reserva(){}

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Reserva reserva = (Reserva) object;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDateTime getInicioReserva() {
        return inicioReserva;
    }

    public void setInicioReserva(LocalDateTime inicioReserva) {
        this.inicioReserva = inicioReserva;
    }

    public LocalDateTime getFinalReserva() {
        return finalReserva;
    }

    public void setFinalReserva(LocalDateTime finalReserva) {
        this.finalReserva = finalReserva;
    }

    public StatusReserva getStatus() {
        return status;
    }

    public void setStatus(StatusReserva status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
}
