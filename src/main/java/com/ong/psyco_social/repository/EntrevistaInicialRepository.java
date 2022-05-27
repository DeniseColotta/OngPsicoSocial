package com.ong.psyco_social.repository;

import com.ong.psyco_social.models.EntrevistaInicial;

import com.ong.psyco_social.models.reportes.ReporteEntrevistasMes;
import com.ong.psyco_social.models.reportes.ReporteMotivoConsulta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface EntrevistaInicialRepository extends CrudRepository <EntrevistaInicial,Integer> {

    //seleccionar informacion de entrevista inicial segun el nombre de la persona ingresado
    @Query(value = "select * from entrevista_inicial as ei, persona as p where  ei.persona_id=p.id and  p.nombres like %:nombrePersona%", nativeQuery = true)
    Collection<EntrevistaInicial> getEntrevistaByName(@Param("nombrePersona") String nombre);

    // cuantas personas se atendieron por mes

    @Query(value = "select MONTHNAME(STR_TO_DATE(month(fecha), '%m')) as mes, count(persona_id) as cantidad from entrevista_inicial group by month(fecha)", nativeQuery = true)
    Collection<ReporteEntrevistasMes> getEntrevistaByMonth();

    //agrupar segun motivo de consulta
    @Query(value = "select mc.nombre as motivoConsulta, count(*) as cantidadPersonas from entrevista_inicial as e right join motivo_consulta as mc on e.motivo_consulta_id= mc.id group by motivo_consulta_id;", nativeQuery = true)
    Collection<ReporteMotivoConsulta> getEntrevistaByMotivoConsulta();


}
