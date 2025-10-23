package com.example.demo.service;

import com.example.demo.exception.ValidacaoException;
import com.example.demo.dto.CadastroUsuarioDTO;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioDTO> listar() {
        return repository.findAll()
                .stream()
                .map(UsuarioDTO::new)
                .toList();
    }

    public UsuarioDTO listarPorId(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new ValidacaoException("Usuário não encontrado"));
        return new UsuarioDTO(usuario);
    }

    @Transactional
    public void criarUsuario(CadastroUsuarioDTO dto) {
        boolean jaCadastrado = repository.existsByNomeOrEmailOrTelefone(dto.nome(), dto.email(), dto.telefone());

        if (jaCadastrado) {
            throw new ValidacaoException("Dados de usúario já cadastrados");
        }

        repository.save(new Usuario(dto));
    }

    @Transactional
    public void remover(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new ValidacaoException("Usuário não encontrado"));
        repository.delete(usuario);
    }
}
