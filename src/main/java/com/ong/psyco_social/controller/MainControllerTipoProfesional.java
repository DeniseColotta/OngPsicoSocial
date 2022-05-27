package com.ong.psyco_social.controller;
import com.ong.psyco_social.models.TipoProfesional;
import com.ong.psyco_social.repository.TipoProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")
public class MainControllerTipoProfesional {

        @Autowired
        private TipoProfesionalRepository tipoProfesionalRepository;

        @GetMapping(path = "tipoProfesional/all")
        public @ResponseBody
        Iterable<TipoProfesional> getAllTipoProfesional() {
            return tipoProfesionalRepository.findAll();
        }

        @GetMapping(path = "tipoProfesional/{id_tipoProfesional}")
        public @ResponseBody
        Optional<TipoProfesional> getTipoProfesionalById(@PathVariable("id_tipoProfesional") int tipoProfesionalId) {
            return tipoProfesionalRepository.findById(tipoProfesionalId);
        }

        @PostMapping(path = "tipoProfesional/create", consumes = "application/json", produces = "application/json")
        public TipoProfesional createTipoProfesional(@RequestBody TipoProfesional newTipoProfesional) {
            return tipoProfesionalRepository.save(newTipoProfesional);
        }

        @PutMapping(path = "tipoProfesional/update", consumes = "application/json", produces = "application/json")
        public TipoProfesional updateTipoProfesional(@RequestBody TipoProfesional updateTipoProfesional) {
            return tipoProfesionalRepository.save(updateTipoProfesional);
        }
        @DeleteMapping(path = "/TipoProfesional/delete/{id_tipoProfesionalId}")
        public @ResponseBody
        Iterable<TipoProfesional> deleteTipoProfesionalById(@PathVariable("id_tipoProfesionalId") int id_TipoProfesional) {
            try {
                tipoProfesionalRepository.deleteById(id_TipoProfesional);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }finally {
                return tipoProfesionalRepository.findAll();

            }



        }
    }


