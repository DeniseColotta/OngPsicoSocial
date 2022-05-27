package com.ong.psyco_social.repository;

import com.ong.psyco_social.models.CoberturaSalud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface CoberturaSaludRepository extends CrudRepository<CoberturaSalud,Integer> {

    //buscar cobertura por nombre
    @Query(value = "select * from cobertura_salud where nombre like %:name%",nativeQuery = true)
    Collection<CoberturaSalud> getCoberturaSaludByName(@Param("name") String nombre);
}
