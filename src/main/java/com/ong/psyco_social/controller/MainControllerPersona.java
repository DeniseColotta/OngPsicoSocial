package com.ong.psyco_social.controller;

import com.ong.psyco_social.models.Persona;
import com.ong.psyco_social.models.reportes.ConteoPersonaNac;
import com.ong.psyco_social.models.reportes.ReporteSituacionLaboral;
import com.ong.psyco_social.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")
public class MainControllerPersona {
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping(path = "persona/all")
    public @ResponseBody
    Iterable<Persona> getAllPersona() {
        return personaRepository.findAll();
    }

    @GetMapping(path = "persona/{id_persona}")
    public @ResponseBody
    Optional<Persona> getPersonaById(@PathVariable("id_persona") int id_p) {
        return personaRepository.findById(id_p);
    }


     @GetMapping(path = "persona/name/{nameGen}")
    public @ResponseBody
     Collection<Persona> getPersonaByGenero(@PathVariable("nameGen") String name) {
       return personaRepository.getPersonaByGenero(name);
   }

    @GetMapping(path = "/persona/name/{persona}")
    public @ResponseBody
    Collection<Persona> getPersonaByName(@PathVariable("persona") String name) {
        return personaRepository.getPersonaByName(name);
    }

    @GetMapping(path = "persona/reporte/situacionLaboral")
    public @ResponseBody
    Collection<ReporteSituacionLaboral> getPersonaByLaboral() {
        return personaRepository.getPersonaByLaboral();
    }

    @GetMapping(path = "persona/conteoNac")
    public @ResponseBody
    Collection<ConteoPersonaNac> getPersonaBymesNac() {
        return personaRepository.getPersonaBymesNac();
    }

    @GetMapping(path = "persona/conteoNac/{mesNac}")
    public @ResponseBody
    Collection <ConteoPersonaNac> getPersonaBymesNac2(@PathVariable("mesNac") int mesNac) {
        return personaRepository.getPersonaBymesN(mesNac);
    }

    @PostMapping(path = "persona/create", consumes = "application/json", produces = "application/json")
    public Persona createPersona(@RequestBody Persona newPersona) {
        return personaRepository.save(newPersona);
    }

    @PutMapping(path = "persona/update", consumes = "application/json", produces = "application/json")
    public Persona updatePersona(@RequestBody Persona updatePersona) {
        return personaRepository.save(updatePersona);
    }
    @DeleteMapping(path = "/persona/delete/{id_persona}")
    public @ResponseBody
    Iterable<Persona> deletePersonaById(@PathVariable("id_persona") int id_p) {
        try {
            personaRepository.deleteById(id_p);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            return personaRepository.findAll();

        }



    }
}
