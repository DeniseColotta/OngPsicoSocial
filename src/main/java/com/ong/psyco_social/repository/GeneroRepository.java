package com.ong.psyco_social.repository;

import com.ong.psyco_social.models.Genero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface GeneroRepository extends CrudRepository<Genero, Integer> {

    //buscar genero por nombre ingresado
    @Query(value = "select * from genero where nombre like %:name%",nativeQuery = true)
     Collection<Genero>getGeneroByName(@Param("name") String nombre);

    }


