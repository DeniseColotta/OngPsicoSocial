package com.ong.psyco_social.repository;


import com.ong.psyco_social.models.Persona;
import com.ong.psyco_social.models.reportes.ConteoPersonaNac;
import com.ong.psyco_social.models.reportes.ReporteSituacionLaboral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {

    //buscar informacion de persona según nombre ingresado
    @Query(value = "select * from persona where nombres like %:name%",nativeQuery = true)
    Collection<Persona>getPersonaByName(@Param("name") String nombre);

    //buscar informacion de personas por genero ingresado
     @Query(value = "select * from persona as p, genero as g where p.genero_id = g.id and (p.genero_id like %:nameGen% or g.nombre like %:nameGen%)",nativeQuery = true)
    Collection<Persona> getPersonaByGenero(@Param("nameGen") String nombre);

     //buscar la cantidad de personas agrupadas por su situacion laboral
    @Query(value = "select sl.nombre as situacionLaboral, count(p.id) as cantidadPersonas from persona as p left join situacion_laboral as sl on p.situacion_laboral_id=sl.id group by sl.nombre",nativeQuery = true)
   Collection<ReporteSituacionLaboral> getPersonaByLaboral();

    //seleccionar la cantidad de personas que cumplen años por mes
    @Query(value =  "select MONTHNAME(STR_TO_DATE(month(fecha_nac), '%m')) as mes, count(*) as cantidad from persona group by month(fecha_nac) order by month(fecha_nac)",nativeQuery = true)
    Collection<ConteoPersonaNac> getPersonaBymesNac();

    //seleccionar la cantidad de personas que cumplen años segun el mes ingresado
    @Query(value =  "select MONTHNAME(STR_TO_DATE(month(fecha_nac), '%m'))as mes, count(*) as cantidad from persona where month (fecha_nac) = :mesNac group by month(fecha_nac)",nativeQuery = true)
    Collection<ConteoPersonaNac> getPersonaBymesN(@Param("mesNac") int mesNac);

}
