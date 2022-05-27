package com.ong.psyco_social.controller;

import com.ong.psyco_social.models.*;

import com.ong.psyco_social.models.reportes.ReporteEntrevistasEspecialidad;
import com.ong.psyco_social.repository.EntrevistaProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")
public class MainControllerEntrevistaProfesional {

        @Autowired
        private EntrevistaProfesionalRepository entrevistaProfesionalRepository;

        @GetMapping(path = "/entrevistaP/all")
        public @ResponseBody
        Iterable<EntrevistaProfesional> getAllEntrevistasP() {
            return entrevistaProfesionalRepository.findAll();
        }

        @GetMapping(path = "/entrevistaP/{id_entrevistaP}")
        public @ResponseBody
        Optional<EntrevistaProfesional> getEntrevistasPById(@PathVariable("id_entrevistaP") int id_ep) {
            return entrevistaProfesionalRepository.findById(id_ep);
        }


        @GetMapping(path = "/entrevistaP/cantidadPorEspecialidad")
         public @ResponseBody
         Collection<ReporteEntrevistasEspecialidad> getAllEntrevistasEspecialidad() {
            return entrevistaProfesionalRepository.getEntrevistaByProfesional();

         }


        @PostMapping(path = "/entrevistaP/create", consumes = "application/json", produces = "application/json")
        public EntrevistaProfesional createEntrevistaProfesional(@RequestBody EntrevistaProfesional newEntrevistaP) {
            return  entrevistaProfesionalRepository.save(newEntrevistaP);
        }

        @PutMapping(path = "/entrevistaP/update", consumes = "application/json", produces = "application/json")
        public EntrevistaProfesional updateEntrevistaP(@RequestBody EntrevistaProfesional updateEntrevistaP) {
            return entrevistaProfesionalRepository.save(updateEntrevistaP);

        }

        @DeleteMapping(path = "/entrevistaP/delete/{id_entrevistaP}")
        public @ResponseBody
        Iterable<EntrevistaProfesional> deleteEntrevistaPById(@PathVariable("id_entrevistaP") int id_ep) {
            try {
                entrevistaProfesionalRepository.deleteById(id_ep);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                return entrevistaProfesionalRepository.findAll();


            }
        }



    }
