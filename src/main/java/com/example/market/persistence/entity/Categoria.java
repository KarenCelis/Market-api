package com.example.market.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class Categoria {

    @Entity
    @Table(name = "categorias")
    public class Categorias{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(name = "id_categoria")
        private Integer idCategoria;
        @Basic(optional = false)
        @Column(name = "descripcion")
        private String descripcion;
        @Basic(optional = false)
        @Column(name = "estado")
        private boolean estado;


        @OneToMany(mappedBy = "categoria")
        private List<Producto> productos;

        public Integer getIdCategoria() {
            return idCategoria;
        }

        public void setIdCategoria(Integer idCategoria) {
            this.idCategoria = idCategoria;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public boolean getEstado() {
            return estado;
        }

        public void setEstado(boolean estado) {
            this.estado = estado;
        }


    }
}
