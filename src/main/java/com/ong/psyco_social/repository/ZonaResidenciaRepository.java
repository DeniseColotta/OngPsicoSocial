package com.ong.psyco_social.repository;


import com.ong.psyco_social.models.ZonaResidencia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ZonaResidenciaRepository extends CrudRepository<ZonaResidencia, Integer> {

    @Query(value = "select * from zona_residencia where nombre like %:name%",nativeQuery = true)
    Collection<ZonaResidencia> getZonaResidenciaByName(@Param("name") String nombre);
}
