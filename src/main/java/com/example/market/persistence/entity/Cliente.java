package com.example.market.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

public class Cliente {
    @Entity
    @Table(name = "clientes")
    public class Clientes{

        @Id
        @Basic(optional = false)
        @Column(name = "id")
        private String id;
        @Column(name = "nombre")
        private String nombre;
        @Column(name = "apellidos")
        private String apellidos;
        @Column(name = "celular")
        private BigInteger celular;
        @Column(name = "direccion")
        private String direccion;
        @Column(name = "correo_electronico")
        private String correoElectronico;



        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public BigInteger getCelular() {
            return celular;
        }

        public void setCelular(BigInteger celular) {
            this.celular = celular;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getCorreoElectronico() {
            return correoElectronico;
        }

        public void setCorreoElectronico(String correoElectronico) {
            this.correoElectronico = correoElectronico;
        }


    }


}
