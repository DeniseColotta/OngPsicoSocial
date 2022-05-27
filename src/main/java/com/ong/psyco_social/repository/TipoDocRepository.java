package com.ong.psyco_social.repository;

import com.ong.psyco_social.models.TipoDoc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface TipoDocRepository extends CrudRepository<TipoDoc,Integer> {
    @Query(value = "select * from tipo_doc where nombre like %:name%",nativeQuery = true)
    Collection<TipoDoc> getTipoDocByName(@Param("name") String nombre);
}
