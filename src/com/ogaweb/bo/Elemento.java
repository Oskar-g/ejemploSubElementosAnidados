package com.ogaweb.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Elemento implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigoElemento;
    private int subNivel;
    private String nombre;
    private List<Elemento> subElementos;

    public Elemento() {
        this.codigoElemento = "";
        this.subNivel = 0;
        this.nombre = "";
        this.subElementos = new ArrayList<>();
    }

    public Elemento(String codigoElemento, int subNivel, String nombre, List<Elemento> subElemento) {
        this.codigoElemento = codigoElemento;
        this.subNivel = subNivel;
        this.nombre = nombre;
        this.subElementos = subElemento;
    }

    public String getCodigoElemento() {
        return codigoElemento;
    }

    public void setCodigoElemento(String codigoElemento) {
        this.codigoElemento = codigoElemento;
    }

    public int getSubNivel() {
        return subNivel;
    }

    public void setSubNivel(int subNivel) {
        this.subNivel = subNivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Elemento> getSubElementos() {
        return subElementos;
    }

    public void setSubElementos(List<Elemento> subElementos) {
        this.subElementos = subElementos;
    }
}
