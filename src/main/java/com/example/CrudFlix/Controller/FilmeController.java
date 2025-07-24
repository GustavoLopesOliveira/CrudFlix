package com.example.CrudFlix.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.example.CrudFlix.Service.FilmeService;
import com.example.CrudFlix.Model.Filme;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    
    private final FilmeService filmeService;
    
    public FilmeController(FilmeService filmeService){
        this.filmeService = filmeService;
    }

    //Endpoints

    @GetMapping
    public List<Filme> listarFilmes(){
        return filmeService.listarFilmes();
    }

    @GetMapping("/{id}")
    public Filme buscarFilmePorId(@PathVariable Long id){
        try{
            return filmeService.buscarFilmePorId(id);
        } catch (Exception e) {
            throw new RuntimeException("Filme não encontrado com o ID: " + id, e);
        }
    }

    @PostMapping
    public Filme salvarFilme(@RequestBody Filme filme){
        return filmeService.salvarFilme(filme);
    }

    @PutMapping("/{id}")
    public void atualizarFilme(@PathVariable Long id, @RequestBody Filme filmeAtualizado){
        filmeService.atualizarFilme(id, filmeAtualizado);
    }


    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id){
        filmeService.deletarFilme(id);
    }


}
