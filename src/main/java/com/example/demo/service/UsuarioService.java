package com.example.demo.service;

import com.example.demo.exception.ValidacaoException;
import com.example.demo.dto.CadastroUsuarioDto;
import com.example.demo.dto.UsuarioDto;
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

    public List<UsuarioDto> listar() {
        return repository.findAll()
                .stream()
                .map(UsuarioDto::new)
                .toList();
    }

    public UsuarioDto listarPorId(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new ValidacaoException("Usuário não encontrado"));
        return new UsuarioDto(usuario);
    }

    @Transactional
    public void criarUsuario(CadastroUsuarioDto dto) {
        boolean jaCadastrado = repository.existsByNomeOrEmailOrTelefone(dto.nome(), dto.email(), dto.telefone());
        System.out.println("Verificação duplicado: " + jaCadastrado);
        if (jaCadastrado) {
            throw new ValidacaoException("Dados de usúario já cadastrados");
        }

        repository.save(new Usuario(dto));
    }

    public void remover(Long id) {
        Usuario usuario = repository.findById(id).orElseThrow(() -> new ValidacaoException("Usuário não encontrado"));
        repository.delete(usuario);
    }
}
