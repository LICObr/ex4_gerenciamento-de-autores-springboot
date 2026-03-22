package com.example.ex4.service;

import com.example.ex4.entity.Autor;
import com.example.ex4.repository.AutorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarPorId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor salvar(Autor autor) {
        return autorRepository.save(autor);
    }

    public void deletar(Long id) {
        autorRepository.deleteById(id);
    }

    public Autor atualizar(Long id, Autor autor) {
        autor.setId(id);
        return autorRepository.save(autor);
    }
}
