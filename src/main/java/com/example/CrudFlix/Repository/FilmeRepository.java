package com.example.CrudFlix.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CrudFlix.Model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long>{
    
}
