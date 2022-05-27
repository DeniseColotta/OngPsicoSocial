package com.ong.psyco_social.controller;

import com.ong.psyco_social.models.HorarioAtencion;
import com.ong.psyco_social.repository.HorarioAtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")
public class MainControllerHorarioAtencion {
    @Autowired
    private HorarioAtencionRepository horarioAtencionRepository;

    @GetMapping(path = "HorarioAtencion/all")
    public @ResponseBody
    Iterable<HorarioAtencion> getAllHorarioAtencion() {
        return horarioAtencionRepository.findAll();
    }

    @GetMapping(path = "HorarioAtencion/{id_horario_atencion}")
    public @ResponseBody
    Optional<HorarioAtencion> getHorarioAtencionById(@PathVariable("id_horario_atencion") int horarioAtencionId) {
        return horarioAtencionRepository.findById(horarioAtencionId);
    }

    @PostMapping(path = "HorarioAtencion/create", consumes = "application/json", produces = "application/json")
    public HorarioAtencion createHorarioAtencion(@RequestBody HorarioAtencion newHorarioAtencion) {
        return horarioAtencionRepository.save(newHorarioAtencion);
    }

    @PutMapping(path = "HorarioAtencion/update", consumes = "application/json", produces = "application/json")
    public HorarioAtencion updateHorarioAtencion(@RequestBody HorarioAtencion updateHorario) {
        return horarioAtencionRepository.save(updateHorario);
    }
    @DeleteMapping(path = "/HorarioAtencion/delete/{id_horario_atencion}")
    public @ResponseBody
    Iterable<HorarioAtencion> deleteHorarioAtencionById(@PathVariable("id_horario_atencion") int id_horarioA) {
        try {
            horarioAtencionRepository.deleteById(id_horarioA);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            return horarioAtencionRepository.findAll();

        }



    }
}




