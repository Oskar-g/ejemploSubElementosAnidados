package com.ogaweb.bo;

import java.io.Serializable;
import java.util.List;

public class Dano implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigoDano;
    private String nombre;
    private List<Elemento> subElemento;

    public String getCodigoDano() {
        return codigoDano;
    }

    public void setCodigoDano(String codigoDano) {
        this.codigoDano = codigoDano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Elemento> getSubElemento() {
        return subElemento;
    }

    public void setSubElemento(List<Elemento> subElemento) {
        this.subElemento = subElemento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Dano{");
        sb.append("codigoDano=").append(codigoDano);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", subElemento=").append(subElemento);
        sb.append('}');
        return sb.toString();
    }
}
