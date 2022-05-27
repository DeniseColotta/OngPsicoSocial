package com.ong.psyco_social.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="persona")
public class Persona {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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
    private String nacionalidad;

    @OneToOne
    @JoinColumn(name = "zona_residencia_id", referencedColumnName = "id")
    private ZonaResidencia zonaResidencia;

    private int cantIntegrantesFamilia;

    @OneToOne
    @JoinColumn(name = "situacion_laboral_id", referencedColumnName = "id")
    private SituacionLaboral situacionLaboral;

    @OneToOne
    @JoinColumn(name = "nivel_estudios_id", referencedColumnName = "id")
    private NivelEstudios nivelEstudios;

    @OneToOne
    @JoinColumn(name = "cobertura_salud_id", referencedColumnName = "id")
    private CoberturaSalud coberturaSalud;

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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public ZonaResidencia getZonaResidencia() {
        return zonaResidencia;
    }

    public void setZonaResidencia(ZonaResidencia zonaResidencia) {
        this.zonaResidencia = zonaResidencia;
    }

    public int getCantIntegrantesFamilia() {
        return cantIntegrantesFamilia;
    }

    public void setCantIntegrantesFamilia(int cantIntegrantesFamilia) {
        this.cantIntegrantesFamilia = cantIntegrantesFamilia;
    }

    public SituacionLaboral getSituacionLaboral() {
        return situacionLaboral;
    }

    public void setSituacionLaboral(SituacionLaboral situacionLaboral) {
        this.situacionLaboral = situacionLaboral;
    }

    public NivelEstudios getNivelEstudios() {
        return nivelEstudios;
    }

    public void setNivelEstudios(NivelEstudios nivelEstudios) {
        this.nivelEstudios = nivelEstudios;
    }

    public CoberturaSalud getCoberturaSalud() {
        return coberturaSalud;
    }

    public void setCoberturaSalud(CoberturaSalud coberturaSalud) {
        this.coberturaSalud = coberturaSalud;
    }
}


