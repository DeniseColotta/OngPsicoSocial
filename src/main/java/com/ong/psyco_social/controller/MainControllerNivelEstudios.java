package com.ong.psyco_social.controller;

import com.ong.psyco_social.models.NivelEstudios;

import com.ong.psyco_social.repository.NivelEstudiosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")
public class MainControllerNivelEstudios {
    @Autowired
    private NivelEstudiosRepository nivelEstudiosRepository;

    @GetMapping(path = "nivelEstudios/all")
    public @ResponseBody
    Iterable<NivelEstudios> getAllNivelEstudios() {
        return nivelEstudiosRepository.findAll();
    }

    @GetMapping(path = "nivelEstudios/{id_nivel_estudios}")
    public @ResponseBody
    Optional<NivelEstudios> getNivelEstudiosById(@PathVariable("id_nivel_estudios") int id_ne) {
        return nivelEstudiosRepository.findById(id_ne);
    }
    @GetMapping(path = "nivelEstudios/name/{nivel_estudios}")
    public @ResponseBody
    Collection<NivelEstudios> getNivelEstudiosByName(@PathVariable("nivel_estudios") String name) {
        return nivelEstudiosRepository.getNivelEstudiosByName(name);
    }

    @PostMapping(path = "nivelEstudios/create", consumes = "application/json", produces = "application/json")
    public NivelEstudios createNivelEstudios(@RequestBody NivelEstudios newNivelEstudios) {
        return nivelEstudiosRepository.save(newNivelEstudios);
    }

    @PutMapping(path = "nivelEstudios/update", consumes = "application/json", produces = "application/json")
    public NivelEstudios updateNivelEstudios(@RequestBody NivelEstudios updateNivelEstudios) {
        return nivelEstudiosRepository.save(updateNivelEstudios);
    }
    @DeleteMapping(path = "/nivelEstudios/delete/{id_nivel_estudios}")
    public @ResponseBody
    Iterable<NivelEstudios> deleteNivelEstudiosyId(@PathVariable("id_nivel_estudios") int id_ne) {
        try {
           nivelEstudiosRepository.deleteById(id_ne);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            return nivelEstudiosRepository.findAll();

        }



    }
}
