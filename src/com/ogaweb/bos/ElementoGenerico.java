package com.ogaweb.bos;

import java.io.Serializable;

public class ElementoGenerico implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cod1;
    private String cod2;
    private String cod3;
    private String cod4;
    private String cod5;
    private String cod6;
    private String nombre;


    public ElementoGenerico(String cod1, String cod2, String cod3, String cod4, String cod5, String cod6, String nombre) {
        this.cod1 = cod1;
        this.cod2 = cod2;
        this.cod3 = cod3;
        this.cod4 = cod4;
        this.cod5 = cod5;
        this.cod6 = cod6;
        this.nombre = nombre;
    }

    public String getCod1() {
        return cod1;
    }

    public void setCod1(String cod1) {
        this.cod1 = cod1;
    }

    public String getCod2() {
        return cod2;
    }

    public void setCod2(String cod2) {
        this.cod2 = cod2;
    }

    public String getCod3() {
        return cod3;
    }

    public void setCod3(String cod3) {
        this.cod3 = cod3;
    }

    public String getCod4() {
        return cod4;
    }

    public void setCod4(String cod4) {
        this.cod4 = cod4;
    }

    public String getCod5() {
        return cod5;
    }

    public void setCod5(String cod5) {
        this.cod5 = cod5;
    }

    public String getCod6() {
        return cod6;
    }

    public void setCod6(String cod6) {
        this.cod6 = cod6;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
