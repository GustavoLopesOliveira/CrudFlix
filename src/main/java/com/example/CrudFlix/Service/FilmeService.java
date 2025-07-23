package com.example.CrudFlix.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CrudFlix.Repository.FilmeRepository;
import com.example.CrudFlix.Model.Filme;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> listarFilmes(){
        return filmeRepository.findAll();
    }

    public Filme salvarFilme(Filme filme){
        return filmeRepository.save(filme);
    }

    public Filme buscarFilmePorId(Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    public void deletarFilme(Long id){
        filmeRepository.deleteById(id);
    }
}
