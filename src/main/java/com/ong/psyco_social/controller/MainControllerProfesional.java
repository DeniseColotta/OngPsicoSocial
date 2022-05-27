package com.ong.psyco_social.controller;

import com.ong.psyco_social.models.Profesional;

import com.ong.psyco_social.models.reportes.ProfesionalFuncion;
import com.ong.psyco_social.models.reportes.ProfesionalPorTipo;
import com.ong.psyco_social.repository.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")
public class MainControllerProfesional {

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @GetMapping(path = "Profesional/all")
    public @ResponseBody
    Iterable<Profesional> getAllProfesionales() {
        return profesionalRepository.findAll();
    }

    @GetMapping(path = "Profesional/{id_profesional}")
    public @ResponseBody
    Optional<Profesional> getProfesionalById(@PathVariable("id_profesional") int profesionalId) {
        return profesionalRepository.findById(profesionalId);
    }

    @GetMapping(path = "/Profesional/name/{profesional}")
    public @ResponseBody
    Collection<Profesional> getProfesionalByName(@PathVariable("profesional") String name) {
        return profesionalRepository.getProfesionalByName(name);
    }
    @GetMapping(path = "Profesional/funcion")
    public @ResponseBody
    Collection<ProfesionalFuncion> getProfesionalFuncion() {
        return profesionalRepository.getInfoEmpleados();
    }

    @GetMapping(path = "Profesional/name/tipo")
    public @ResponseBody
    Collection<ProfesionalPorTipo> getProfesionalTipo() {
        return profesionalRepository.getProfesionalByTipo();
    }

    @PostMapping(path = "Profesional/create", consumes = "application/json", produces = "application/json")
    public Profesional createProfesional(@RequestBody Profesional newProfesional) {
        return profesionalRepository.save(newProfesional);
    }

    @PutMapping(path = "Profesional/update", consumes = "application/json", produces = "application/json")
    public Profesional updateProfesional(@RequestBody Profesional updateProfesional) {
        return profesionalRepository.save(updateProfesional);
    }

    @DeleteMapping(path = "/Profesional/delete/{id_profesional}")
    public @ResponseBody
    Iterable<Profesional> deleteProfesionalById(@PathVariable("id_profesional") int id_profesional) {
        try {
            profesionalRepository.deleteById(id_profesional);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return profesionalRepository.findAll();

        }
    }
}

