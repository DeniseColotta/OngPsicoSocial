package com.ong.psyco_social.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="profesional")
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombres;
    private String apellidos;

    @OneToOne
    @JoinColumn(name = "tipo_doc_id", referencedColumnName = "id")
    private TipoDoc tipoDoc;


    private int numDoc;
    private Date fechaNac;
    private int edad;

    @OneToOne
    @JoinColumn(name = "genero_id", referencedColumnName = "id")
    private Genero genero;

    private int telefono;
    private String email;

    @OneToOne
    @JoinColumn(name = "zona_residencia_id", referencedColumnName = "id")
    private ZonaResidencia zonaResidencia;

    @OneToOne
    @JoinColumn(name = "horario_atencion_id", referencedColumnName = "id")
    private HorarioAtencion horarioAtencion;

    @OneToOne
    @JoinColumn(name = "tipo_profesional_id", referencedColumnName = "id")
    private TipoProfesional tipoProfesional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public TipoDoc getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(TipoDoc tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public int getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ZonaResidencia getZonaResidencia() {
        return zonaResidencia;
    }

    public void setZonaResidencia(ZonaResidencia zonaResidencia) {
        this.zonaResidencia = zonaResidencia;
    }

    public HorarioAtencion getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(HorarioAtencion horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public TipoProfesional getTipoProfesional() {
        return tipoProfesional;
    }

    public void setTipoProfesional(TipoProfesional tipoProfesional) {
        this.tipoProfesional = tipoProfesional;
    }
}

