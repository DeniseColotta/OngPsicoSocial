package com.ong.psyco_social.controller;


import com.ong.psyco_social.models.TipoDoc;

import com.ong.psyco_social.repository.TipoDocRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/ong/Social")
public class MainControllerTipoDoc {
    @Autowired
    private TipoDocRepository tipoDocRepository;

    @GetMapping(path = "tipoDoc/all")
    public @ResponseBody
    Iterable<TipoDoc> getAllTipoDoc() {
        return tipoDocRepository.findAll();
    }

    @GetMapping(path = "tipoDoc/{id_tipo_doc}")
    public @ResponseBody
    Optional<TipoDoc> getTipoDocById(@PathVariable("id_tipo_doc") int id_doc) {
        return tipoDocRepository.findById(id_doc);
    }
    @GetMapping(path = "tipoDoc/name/{tipo_doc}")
    public @ResponseBody
    Collection<TipoDoc> getTipoDocByName(@PathVariable("tipo_doc") String name) {
        return tipoDocRepository.getTipoDocByName(name);
    }

    @PostMapping(path = "tipoDoc/create", consumes = "application/json", produces = "application/json")
    public TipoDoc createTipoDoc(@RequestBody TipoDoc newTipoDoc) {
        return tipoDocRepository.save(newTipoDoc);
    }

    @PutMapping(path = "tipoDoc/update", consumes = "application/json", produces = "application/json")
    public TipoDoc updateTipoDoc(@RequestBody TipoDoc updateTipoDoc) {
        return tipoDocRepository.save(updateTipoDoc);
    }
    @DeleteMapping(path = "/TipoDoc/delete/{id_tipo_doc}")
    public @ResponseBody
    Iterable<TipoDoc> deleteTipoDocById(@PathVariable("id_tipo_doc") int id_td) {
        try {
            tipoDocRepository.deleteById(id_td);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            return tipoDocRepository.findAll();

        }



    }
}


