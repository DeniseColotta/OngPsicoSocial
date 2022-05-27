package com.ong.psyco_social.repository;


import com.ong.psyco_social.models.Profesional;
import com.ong.psyco_social.models.reportes.ProfesionalFuncion;
import com.ong.psyco_social.models.reportes.ProfesionalPorTipo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ProfesionalRepository extends CrudRepository<Profesional,Integer> {

    //seleccionar profesionales ingresando el nombre
    @Query(value = "select * from profesional where nombres like %:name%", nativeQuery = true)
    Collection<Profesional> getProfesionalByName(@Param("name") String nombre);

    //seleccionar nombre y apellido de los empleados, tipo de función y horario.
    @Query(value = "select pr.nombres as nombres,pr.apellidos as apellidos,tpr.nombre as funcion,ha.nombre as horario from profesional as pr left join tipo_profesional as tpr on pr.tipo_profesional_id=tpr.id join horario_atencion as ha on pr.horario_atencion_id=ha.id", nativeQuery = true)
    Collection<ProfesionalFuncion> getInfoEmpleados();


    // agrupar profesionales segun su funcion

    @Query(value = "select tp.nombre, count(pr.tipo_profesional_id) as cantidad from profesional as pr,tipo_profesional as tp where pr.tipo_profesional_id=tp.id group by tp.nombre", nativeQuery = true)
    Collection<ProfesionalPorTipo> getProfesionalByTipo();
}