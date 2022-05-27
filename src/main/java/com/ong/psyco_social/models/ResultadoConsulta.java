package com.ong.psyco_social.models;

import javax.persistence.*;


    @Entity
    @Table(name="resultado_consulta")
    public class ResultadoConsulta{
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private int id;

        private String nombre;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }
