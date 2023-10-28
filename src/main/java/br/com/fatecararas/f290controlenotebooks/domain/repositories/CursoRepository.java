package br.com.fatecararas.f290controlenotebooks.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatecararas.f290controlenotebooks.domain.entities.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
    
}
