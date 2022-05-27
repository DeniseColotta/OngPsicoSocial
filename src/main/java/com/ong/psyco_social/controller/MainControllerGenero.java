
package com.ong.psyco_social.controller;

import com.ong.psyco_social.models.Genero;
import com.ong.psyco_social.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")

public class MainControllerGenero {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping(path = "/genero/all")
    public @ResponseBody
    Iterable<Genero> getAllGenero() {
        return generoRepository.findAll();
    }


    @GetMapping(path = "/genero/{id_genero}")
    public @ResponseBody
    Optional<Genero> getGeneroById(@PathVariable("id_genero") int id_gn) {
        return generoRepository.findById(id_gn);
    }

    @GetMapping(path = "/genero/name/{genero}")
    public @ResponseBody
    Collection<Genero> getGeneroByName(@PathVariable("genero") String name) {
        return generoRepository.getGeneroByName(name);
    }

    @PostMapping(path = "/genero/create", consumes = "application/json", produces = "application/json")
    public Genero createGenero(@RequestBody Genero newGenero) {
        return generoRepository.save(newGenero);
    }

    @PutMapping(path = "/genero/update", consumes = "application/json", produces = "application/json")
    public Genero updateGenero(@RequestBody Genero updateGenero) {
        return generoRepository.save(updateGenero);

    }

    @DeleteMapping(path = "/genero/delete/{id_genero}")
    public @ResponseBody
    Iterable<Genero> deleteGeneroById(@PathVariable("id_genero") int id_gn) {
        try {
            generoRepository.deleteById(id_gn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return generoRepository.findAll();


        }
    }
}


