package com.ong.psyco_social.controller;


import com.ong.psyco_social.models.CoberturaSalud;

import com.ong.psyco_social.repository.CoberturaSaludRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")
public class MainControllerCoberturaSalud {
    @Autowired
    private CoberturaSaludRepository coberturaSaludRepository;

    @GetMapping(path = "coberturaSalud/all")
    public @ResponseBody
    Iterable<CoberturaSalud> getAllCoberturaSalud() {
        return coberturaSaludRepository.findAll();
    }

    @GetMapping(path = "coberturaSalud/{id_cobertura_salud}")
    public @ResponseBody
    Optional<CoberturaSalud> getCoberturaSaludById(@PathVariable("id_cobertura_salud") int id_cs) {
        return coberturaSaludRepository.findById(id_cs);
    }
    @GetMapping(path = "coberturaSalud/name/{cobertura_salud}")
    public @ResponseBody
    Collection<CoberturaSalud> getCoberturaSaludByName(@PathVariable("cobertura_salud") String name) {
        return coberturaSaludRepository.getCoberturaSaludByName(name);
    }

    @PostMapping(path = "coberturaSalud/create", consumes = "application/json", produces = "application/json")
    public CoberturaSalud createCoberturaSalud(@RequestBody CoberturaSalud newCoberturaSalud) {
        return coberturaSaludRepository.save(newCoberturaSalud);
    }

    @PutMapping(path = "coberturaSalud/update", consumes = "application/json", produces = "application/json")
    public CoberturaSalud updateCoberturaSalud(@RequestBody CoberturaSalud updateCoberturaSalud) {
        return coberturaSaludRepository.save(updateCoberturaSalud);
    }
    @DeleteMapping(path = "/coberturaSalud/delete/{id_cobertura_salud}")
    public @ResponseBody
    Iterable<CoberturaSalud> deleteCoberturaSaludById(@PathVariable("id_cobertura_salud") int id_cs) {
        try {
            coberturaSaludRepository.deleteById(id_cs);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            return coberturaSaludRepository.findAll();

        }



    }
}
