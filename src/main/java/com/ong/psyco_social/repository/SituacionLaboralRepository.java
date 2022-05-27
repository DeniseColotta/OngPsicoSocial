package com.ong.psyco_social.repository;

import com.ong.psyco_social.models.SituacionLaboral;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SituacionLaboralRepository extends CrudRepository<SituacionLaboral,Integer> {
    @Query(value = "select * from situacion_laboral where nombre like %:name%",nativeQuery = true)
    Collection<SituacionLaboral> getSituacionLaboralByName(@Param("name") String nombre);
}
