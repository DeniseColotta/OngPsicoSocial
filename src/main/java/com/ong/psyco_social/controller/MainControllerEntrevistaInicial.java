package com.ong.psyco_social.controller;

import com.ong.psyco_social.models.EntrevistaInicial;

import com.ong.psyco_social.models.reportes.ReporteEntrevistasMes;
import com.ong.psyco_social.models.reportes.ReporteMotivoConsulta;
import com.ong.psyco_social.repository.EntrevistaInicialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")

public class MainControllerEntrevistaInicial {
    @Autowired
    private EntrevistaInicialRepository entrevistaInicialRepository;

    @GetMapping(path = "/entrevistaI/all")
    public @ResponseBody
    Iterable<EntrevistaInicial> getAllEntrevistas() {
        return entrevistaInicialRepository.findAll();
    }


    @GetMapping(path = "/entrevistaI/{id_entrevista}")
    public @ResponseBody
    Optional<EntrevistaInicial> getEntrevistasById(@PathVariable("id_entrevista") int id_en) {
        return entrevistaInicialRepository.findById(id_en);
    }

    @GetMapping(path = "/entrevistaI/name/{nombrePersona}")
    public @ResponseBody
    Collection<EntrevistaInicial> getEntrevistaByNamePersona(@PathVariable("nombrePersona") String name) {
        return entrevistaInicialRepository.getEntrevistaByName(name);
    }
    @GetMapping(path = "/entrevistaI/cantidadMes")
    public @ResponseBody
    Collection<ReporteEntrevistasMes> getAllEntrevistasMes() {
        return entrevistaInicialRepository.getEntrevistaByMonth();

    }

    //@GetMapping(path = "/entrevistaI/cantidadPorEspecialidad")
   // public @ResponseBody
   // Collection<ReporteEntrevistasEspecialidad> getAllEntrevistasEspecialidad() {
    //    return entrevistaInicialRepository.getEntrevistaByProfesional();

   // }
    @GetMapping(path = "/entrevistaI/cantidadPorMotivoConsulta")
    public @ResponseBody
    Collection<ReporteMotivoConsulta> getAllEntrevistasMotivoConsulta() {
        return entrevistaInicialRepository.getEntrevistaByMotivoConsulta();

    }

    @PostMapping(path = "/entrevistaI/create", consumes = "application/json", produces = "application/json")
    public EntrevistaInicial createEntrevistaInicial(@RequestBody EntrevistaInicial newEntrevista) {
        return  entrevistaInicialRepository.save(newEntrevista);
    }

    @PutMapping(path = "/entrevistaI/update", consumes = "application/json", produces = "application/json")
    public EntrevistaInicial updateEntrevista(@RequestBody EntrevistaInicial updateEntrevista) {
        return entrevistaInicialRepository.save(updateEntrevista);

    }

    @DeleteMapping(path = "/entrevistaI/delete/{id_entrevista}")
    public @ResponseBody
    Iterable<EntrevistaInicial> deleteEntrevistaById(@PathVariable("id_entrevista") int id_en) {
        try {
            entrevistaInicialRepository.deleteById(id_en);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return entrevistaInicialRepository.findAll();


        }
    }


}