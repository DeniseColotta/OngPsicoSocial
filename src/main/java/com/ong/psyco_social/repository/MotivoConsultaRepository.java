package com.ong.psyco_social.repository;

import com.ong.psyco_social.models.MotivoConsulta;
import com.ong.psyco_social.models.Persona;
import com.ong.psyco_social.models.Profesional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface MotivoConsultaRepository extends CrudRepository<MotivoConsulta,Integer> {



}
