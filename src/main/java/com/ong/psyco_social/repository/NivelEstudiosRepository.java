package com.ong.psyco_social.repository;

import com.ong.psyco_social.models.NivelEstudios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface NivelEstudiosRepository extends CrudRepository<NivelEstudios,Integer> {
    @Query(value = "select * from nivel_estudios where nombre like %:name%",nativeQuery = true)
    Collection<NivelEstudios> getNivelEstudiosByName(@Param("name") String nombre);
}
