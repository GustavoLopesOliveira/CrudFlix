package com.example.CrudFlix.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudFlix.Service.FilmeService;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    
    private final FilmeService filmeService;
    
    public FilmeController(FilmeService filmeService){
        this.filmeService = filmeService;
    }

    @GetMapping("/oi")
    public String oi(){
        return "oi";
    }



}
