package com.ogaweb.exec;

import com.ogaweb.bo.Elemento;
import com.ogaweb.bos.ElementoGenerico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Type1 {

    //Constantes
    private static final String vacio = "";

    //Lista generica "devuelta por el servicio"
    public static ElementoGenerico[] elementos = {
            new ElementoGenerico("1", vacio, vacio, vacio, vacio, vacio, "Cocina"),
            new ElementoGenerico("1", "2", vacio, vacio, vacio, vacio, "Frigorifico"),
            new ElementoGenerico("1", "3", vacio, vacio, vacio, vacio, "Lavadora"),
            new ElementoGenerico("1", "4", vacio, vacio, vacio, vacio, "Silla"),
            new ElementoGenerico("1", "4", "5", vacio, vacio, vacio, "Unidad 1"),
            new ElementoGenerico("1", "4", "6", vacio, vacio, vacio, "Unidad 2"),
            new ElementoGenerico("7", vacio, vacio, vacio, vacio, vacio, "Baño"),
            new ElementoGenerico("7", "8", vacio, vacio, vacio, vacio, "Secador"),
            new ElementoGenerico("7", "8", "5", vacio, vacio, vacio, "Unidad 1"),
            new ElementoGenerico("7", "8", "6", vacio, vacio, vacio, "Unidad 2"),
            new ElementoGenerico("7", "9", vacio, vacio, vacio, vacio, "Ducha"),
            new ElementoGenerico("7", "10", vacio, vacio, vacio, vacio, "Retrete"),
            new ElementoGenerico("7", "10", "11", vacio, vacio, vacio, "Cañeria"),
            new ElementoGenerico("7", "10", "11", "12", vacio, vacio, "PVC"),
            new ElementoGenerico("7", "10", "11", "12", "13", vacio, "Junta"),
            new ElementoGenerico("7", "10", "11", "12", "13", "14", "Átomo"),
            new ElementoGenerico("7", "10", "15", vacio, vacio, vacio, "Tapa del bater"),
    };

    /**
     * Método de inicio de pruebas
     *
     * @return lista resultante
     */
    public List<Elemento> start() {
        Elemento danoHorigen = new Elemento();
        List<ElementoGenerico> elementosGenericos = new ArrayList<>(Arrays.asList(elementos));
        buscarSubelementos(danoHorigen, elementosGenericos);
        return danoHorigen.getSubElementos();
    }

    /**
     * Añadir nuevos elementos (si el elemento padre llega a subnivel 0)
     * o buscar subelementos del elemento padre actual
     *
     * @param elementoPadre elemento al que adherir subelementos relacionados consigo mismo
     *                      por el código de elemento de su nivel
     */
    private void buscarSubelementos(Elemento elementoPadre, List<ElementoGenerico> elementosGenericos) {
        int subNivelActual = elementoPadre.getSubNivel() + 1;

        for (ElementoGenerico elementoActual : elementosGenericos) {

            //codigos indizados para las validaciones de elemento
            String nuevoCodigoSiguiente = getCodigoByLevel(elementoActual, elementoPadre.getSubNivel() + 2);
            String nuevoCodigoActual = getCodigoByLevel(elementoActual, elementoPadre.getSubNivel() + 1);
            String nuevoCodigoAnterior = getCodigoByLevel(elementoActual, elementoPadre.getSubNivel());

            //Datos del subelemento a adherir
            Elemento nuevoSubElemento = rellenarDatosElemento(elementoActual, nuevoCodigoActual, subNivelActual);

            /*
             * Si es subnivel del padre es 0...
             * Si el indice del array generico no tiene subElementos...
             * --ES UN ELEMENTO RAIZ--
             *
             * O Bien...
             *
             * Si existe un codigo para este nivel...
             * Si el codigo del subnivel generico coincide con el del padre...
             * Si el indice del array generico no tiene subElementos...
             * --ES UN SUBELEMENTO--
             */
            if ((elementoPadre.getSubNivel() == 0 && null == nuevoCodigoSiguiente) ||
                    (nuevoCodigoActual != null &&
                            elementoPadre.getCodigoElemento().equals(nuevoCodigoAnterior) &&
                            null == nuevoCodigoSiguiente)) {

                elementoPadre.getSubElementos().add(nuevoSubElemento);
            }
        }

        //Buscar subElementos de los subElementos añadidos
        for (Elemento subElemento : elementoPadre.getSubElementos()) {
            buscarSubelementos(subElemento, elementosGenericos);
        }
    }

    /**
     * Fill de los datos del subelemento a adherir al elemento padre de turno
     *
     * @param elementoActual elementoGenérico actual del bucle a extraer los datos
     */
    private Elemento rellenarDatosElemento(ElementoGenerico elementoActual, String nuevoCodigoActual, int subNivelActual) {
        Elemento nuevoSubElemento = new Elemento();

        nuevoSubElemento.setCodigoElemento(nuevoCodigoActual);
        nuevoSubElemento.setNombre(elementoActual.getNombre());
        nuevoSubElemento.setSubNivel(subNivelActual);

        return nuevoSubElemento;
    }

    //---------------------------------------------------------------------------------------------------
    // Auxiliares
    //---------------------------------------------------------------------------------------------------

    /**
     * Indica si el valor ni es nulo ni vacío
     *
     * @param valor variable a verificar
     * @return true si se cumplen las condiciones false si no
     */
    private boolean estaInformado(String valor) {
        return (valor != null && !valor.trim().equals(vacio));
    }

    /**
     * Retorna el codigo del elemento genérico en el subnivel especificado
     *
     * @param elementoGenerico elemento generico del que substraer el código
     * @param subnivel         altura de subnivel del código a extraer
     * @return valor del codigo (null si no hay código en este subnivel o si está vacio)
     */
    private String getCodigoByLevel(ElementoGenerico elementoGenerico, int subnivel) {
        String codigo = null;
        switch (subnivel) {
            case 1:
                codigo = elementoGenerico.getCod1();
                break;
            case 2:
                codigo = elementoGenerico.getCod2();
                break;
            case 3:
                codigo = elementoGenerico.getCod3();
                break;
            case 4:
                codigo = elementoGenerico.getCod4();
                break;
            case 5:
                codigo = elementoGenerico.getCod5();
                break;
            case 6:
                codigo = elementoGenerico.getCod6();
                break;
            default:
                break;
        }

        //Si llega nulo o vacío devolver el codigo null
        if (!estaInformado(codigo)) {
            codigo = null;
        }

        return codigo;
    }
}
