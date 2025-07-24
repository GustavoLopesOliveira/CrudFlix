package com.example.CrudFlix.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.CrudFlix.Repository.FilmeRepository;
import com.example.CrudFlix.Model.Filme;
import com.example.CrudFlix.Exception.FilmeNaoEncontradoException;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }


    //Crud

    public List<Filme> listarFilmes(){
        return filmeRepository.findAll();
    }

    public Filme buscarFilmePorId(Long id) {
        return filmeRepository.findById(id)
            .orElseThrow(() -> new FilmeNaoEncontradoException(id));
    }

    public Filme salvarFilme(Filme filme){
        return filmeRepository.save(filme);
    }

   public void atualizarFilme(Long id, Filme filmeAtualizado){
        Filme filmeExistente = buscarFilmePorId(id);
        if(filmeExistente == null) {
            throw new FilmeNaoEncontradoException(id);
        }
        filmeExistente.setTitulo(filmeAtualizado.getTitulo());
        filmeExistente.setGenero(filmeAtualizado.getGenero());
        filmeExistente.setAnoLancamento(filmeAtualizado.getAnoLancamento());
        filmeRepository.save(filmeExistente);
    }

    public void deletarFilme(Long id){
        if (!filmeRepository.existsById(id)) {
            throw new FilmeNaoEncontradoException(id);
        }
        filmeRepository.deleteById(id);
    }
}
