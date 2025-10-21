package com.example.demo.service;

import com.example.demo.exception.ValidacaoException;
import com.example.demo.dto.CadastroSalaDTO;
import com.example.demo.dto.SalaDTO;
import com.example.demo.model.Sala;
import com.example.demo.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository repository;

    public List<SalaDTO> listar() {
        return repository.findAll()
                .stream()
                .map(SalaDTO::new)
                .toList();
    }

    public SalaDTO listarPorId(Long id) {
        Sala sala =  repository.findById(id).orElseThrow(()-> new ValidacaoException("Sala não encontrada"));
        return new SalaDTO(sala);
    }

    @Transactional
    public void criarSala(CadastroSalaDTO dto) {
        boolean jaCadastrado = repository.existsByCodigo(dto.codigo());

        if (jaCadastrado) {
            throw new ValidacaoException("Dados de sala já cadastrado");
        }

        if(dto.capacidade() <= 0){
            throw new ValidacaoException("Capacidade da sala deve ser maior que 0");
        }

        repository.save(new Sala(dto));
    }

    @Transactional
    public void remover(@PathVariable Long id) {
        Sala sala = repository.findById(id).orElseThrow(() -> new ValidacaoException("Sala não encontrada"));
        repository.delete(sala);
    }
}
