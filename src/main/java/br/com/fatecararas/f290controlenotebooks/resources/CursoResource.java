package br.com.fatecararas.f290controlenotebooks.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecararas.f290controlenotebooks.domain.entities.Curso;
import br.com.fatecararas.f290controlenotebooks.domain.repositories.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoResource {

    private final CursoRepository repository;

    @Autowired
    public CursoResource(CursoRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Curso create(@RequestBody Curso curso) {
        return repository.save(curso);
    }

    @PutMapping
    public Curso update(@RequestBody Curso curso) throws Exception{
        Optional<Curso> optional = repository.findById(curso.getId());

        if(optional.isEmpty()) {
            throw new Exception("Curso não localizado.");
        }

        Curso updated = optional.get();
        updated.setDescricao(curso.getDescricao());


        return repository.save(updated);
    }

    @GetMapping("/all")
    public List<Curso> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Curso findById(@PathVariable("id") Integer id) throws Exception {

        Optional<Curso> optional = repository.findById(id);

        if (optional.isEmpty()) {
            throw new Exception("Id não localizado");
        }

        return optional.get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

}
