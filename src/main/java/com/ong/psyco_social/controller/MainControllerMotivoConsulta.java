package com.ong.psyco_social.controller;

import com.ong.psyco_social.models.HorarioAtencion;
import com.ong.psyco_social.models.MotivoConsulta;
import com.ong.psyco_social.repository.HorarioAtencionRepository;
import com.ong.psyco_social.repository.MotivoConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")
public class MainControllerMotivoConsulta {

        @Autowired
        private MotivoConsultaRepository motivoConsultaRepository;

        @GetMapping(path = "MotivoConsulta/all")
        public @ResponseBody
        Iterable<MotivoConsulta> getAllMotivoConsulta() {
            return motivoConsultaRepository.findAll();
        }

        @GetMapping(path = "MotivoConsulta/{id_motivoC}")
        public @ResponseBody
        Optional<MotivoConsulta> getMotivoConsultaById(@PathVariable("id_motivoC") int motivoConsultaId) {
            return motivoConsultaRepository.findById(motivoConsultaId);

        }


        @PostMapping(path = "MotivoConsulta/create", consumes = "application/json", produces = "application/json")
        public MotivoConsulta createMotivoConsulta(@RequestBody MotivoConsulta newMotivoConsulta) {
            return motivoConsultaRepository.save(newMotivoConsulta);
        }

        @PutMapping(path = "MotivoConsulta/update", consumes = "application/json", produces = "application/json")
        public MotivoConsulta updateMotivoConsulta(@RequestBody MotivoConsulta updateMotivoC) {
            return motivoConsultaRepository.save(updateMotivoC);
        }
        @DeleteMapping(path = "/MotivoConsulta/delete/{id_motivoC}")
        public @ResponseBody
        Iterable<MotivoConsulta> deleteMotivoConsultaById(@PathVariable("id_motivoC") int id_motivoConsulta) {
            try {
                motivoConsultaRepository.deleteById(id_motivoConsulta);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }finally {
                return motivoConsultaRepository.findAll();

            }



        }
    }


