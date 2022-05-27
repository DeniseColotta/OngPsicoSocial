package com.ong.psyco_social.models;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="entrevista_profesional")
public class EntrevistaProfesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "entrevista_inicial_id", referencedColumnName = "id")
    private EntrevistaInicial entrevistaInicial;

    @OneToOne
    @JoinColumn(name = "profesional_id", referencedColumnName = "id")
    private Profesional profesional;

    private Date fecha;

    @OneToOne
    @JoinColumn(name = "resultado_consulta_id", referencedColumnName = "id")
    private ResultadoConsulta resultadoConsulta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EntrevistaInicial getEntrevistaInicial() {
        return entrevistaInicial;
    }

    public void setEntrevistaInicial(EntrevistaInicial entrevistaInicial) {
        this.entrevistaInicial = entrevistaInicial;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ResultadoConsulta getResultadoConsulta() {
        return resultadoConsulta;
    }

    public void setResultadoConsulta(ResultadoConsulta resultadoConsulta) {
        this.resultadoConsulta = resultadoConsulta;
    }
}