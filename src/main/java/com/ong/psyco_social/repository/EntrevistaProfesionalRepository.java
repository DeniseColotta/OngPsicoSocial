package com.ong.psyco_social.repository;

import com.ong.psyco_social.models.EntrevistaProfesional;
import com.ong.psyco_social.models.reportes.ReporteEntrevistasEspecialidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface EntrevistaProfesionalRepository extends CrudRepository<EntrevistaProfesional,Integer> {
    //cuantas personas atendio cada especialidad

    @Query(value = "select tpr.nombre, count(*) as cantidad from  entrevista_profesional as ep left join profesional as pr on ep.profesional_id=pr.id join tipo_profesional as tpr on pr.tipo_profesional_id=tpr.id group by pr.tipo_profesional_id", nativeQuery = true)
    Collection<ReporteEntrevistasEspecialidad> getEntrevistaByProfesional();
}
