package com.ong.psyco_social.controller;

import com.ong.psyco_social.models.Genero;
import com.ong.psyco_social.models.ZonaResidencia;
import com.ong.psyco_social.repository.ZonaResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")

public class MainControllerResidencia {

    @Autowired
    private ZonaResidenciaRepository zonaResidenciaRepository;

    @GetMapping(path = "zonaResidencia/all")
    public @ResponseBody
    Iterable<ZonaResidencia> getAllResidencia() {
        return zonaResidenciaRepository.findAll();
    }

    @GetMapping(path = "zonaResidencia/{id_zona_residencia}")
    public @ResponseBody
    Optional<ZonaResidencia> getZonaResidenciaById(@PathVariable("id_zona_residencia") int id_zr) {
        return zonaResidenciaRepository.findById(id_zr);
    }
    @GetMapping(path = "zonaResidencia/name/{zona_residencia}")
    public @ResponseBody
    Collection<ZonaResidencia> getZonaResidenciaByName(@PathVariable("zona_residencia") String name) {
        return zonaResidenciaRepository.getZonaResidenciaByName(name);
    }

    @PostMapping(path = "zonaResidencia/create", consumes = "application/json", produces = "application/json")
    public ZonaResidencia createZonaResidencia(@RequestBody ZonaResidencia newZonaResidencia) {
        return zonaResidenciaRepository.save(newZonaResidencia);
    }

    @PutMapping(path = "zonaResidencia/update", consumes = "application/json", produces = "application/json")
    public ZonaResidencia updateZonaResidencia(@RequestBody ZonaResidencia updateZonaResidencia) {
        return zonaResidenciaRepository.save(updateZonaResidencia);
    }
    @DeleteMapping(path = "/zonaResidencia/delete/{id_zona_residencia}")
    public @ResponseBody
    Iterable<ZonaResidencia> deleteZonaResidenciaById(@PathVariable("id_zona_residencia") int id_zr) {
        try {
            zonaResidenciaRepository.deleteById(id_zr);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            return zonaResidenciaRepository.findAll();

        }



    }
}
