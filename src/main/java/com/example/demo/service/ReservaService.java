package com.example.demo.service;

import com.example.demo.dto.CriarReservaDTO;
import com.example.demo.dto.ReservaDTO;
import com.example.demo.exception.ValidacaoException;
import com.example.demo.model.Reserva;
import com.example.demo.model.Sala;
import com.example.demo.model.Usuario;
import com.example.demo.repository.ReservaRepository;
import com.example.demo.repository.SalaRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.validacoes.ValidacaoCriacaoReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private List<ValidacaoCriacaoReserva> validacoes;


    public List<ReservaDTO> listar() {
        return repository.findAll()
                .stream()
                .map(ReservaDTO::new).
                toList();
    }

    public ReservaDTO listarPorId(Long id) {
        Reserva reserva = repository.findById(id).orElseThrow(() -> new ValidacaoException("Reserva não encontrada"));
        return new ReservaDTO(reserva);
    }


    @Transactional
    public void criarReserva(CriarReservaDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.usuarioId()).orElseThrow(() -> new ValidacaoException("Usuário não encontrado"));
        Sala sala = salaRepository.findById(dto.salaId()).orElseThrow(() -> new ValidacaoException("Sala não encontrada"));

        validacoes.forEach(v -> v.validar(dto));

        repository.save(new Reserva(dto.codigo(), dto.dataReserva(), dto.inicioReserva(), dto.finalReserva(), usuario, sala));
    }


    @Transactional
    public void cancelarReserva(Long id) {
        Reserva reserva = repository.findById(id).orElseThrow(() -> new ValidacaoException("Reserva não encontrada"));
        repository.delete(reserva);
    }
}
