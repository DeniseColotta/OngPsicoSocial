package com.ong.psyco_social.controller;

import com.ong.psyco_social.models.SituacionLaboral;

import com.ong.psyco_social.repository.SituacionLaboralRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")
public class MainControllerSituacionLaboral {
    @Autowired
    private SituacionLaboralRepository situacionLaboralRepository;

    @GetMapping(path = "situacionLaboral/all")
    public @ResponseBody
    Iterable<SituacionLaboral> getSituacionLaboralDoc() {
        return situacionLaboralRepository.findAll();
    }

    @GetMapping(path = "situacionLaboral/{id_situacion_laboral}")
    public @ResponseBody
    Optional<SituacionLaboral> getSituacionLaboralById(@PathVariable("id_situacion_laboral") int id_sl) {
        return situacionLaboralRepository.findById(id_sl);
    }
    @GetMapping(path = "situacionLaboral/name/{situacion_laboral}")
    public @ResponseBody
    Collection<SituacionLaboral> getSituacionLaboralByName(@PathVariable("situacion_laboral") String name) {
        return situacionLaboralRepository.getSituacionLaboralByName(name);
    }

    @PostMapping(path = "situacionLaboral/create", consumes = "application/json", produces = "application/json")
    public SituacionLaboral createSituacionLaboral(@RequestBody SituacionLaboral newSituacionLaboral) {
        return situacionLaboralRepository.save(newSituacionLaboral);
    }

    @PutMapping(path = "situacionLaboral/update", consumes = "application/json", produces = "application/json")
    public SituacionLaboral updateSituacionLaboral(@RequestBody SituacionLaboral updateSituacionLaboral) {
        return situacionLaboralRepository.save(updateSituacionLaboral);
    }
    @DeleteMapping(path = "/situacionLaboral/delete/{id_situacion_laboral}")
    public @ResponseBody
    Iterable<SituacionLaboral> deleteSituacionLaboralById(@PathVariable("id_situacion_laboral") int id_sl) {
        try {
            situacionLaboralRepository.deleteById(id_sl);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            return situacionLaboralRepository.findAll();

        }



    }
}
