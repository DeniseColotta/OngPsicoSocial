package com.ong.psyco_social.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="entrevista_inicial")
public class EntrevistaInicial {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "persona_id", referencedColumnName = "id")
    private Persona personaId;

    private Date fecha;

    @OneToOne
    @JoinColumn(name = "motivo_consulta_id", referencedColumnName = "id")
    private MotivoConsulta motivoConsulta;

    @OneToOne
    @JoinColumn(name = "profesional_id", referencedColumnName = "id")
    private Profesional Profesional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Persona personaId) {
        this.personaId = personaId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public MotivoConsulta getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(MotivoConsulta motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public com.ong.psyco_social.models.Profesional getProfesional() {
        return Profesional;
    }

    public void setProfesional(com.ong.psyco_social.models.Profesional profesional) {
        Profesional = profesional;
    }
}

