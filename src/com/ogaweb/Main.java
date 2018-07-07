package com.ogaweb;

import com.ogaweb.bo.Elemento;
import com.ogaweb.exec.Type1;
import org.json.JSONObject;

import java.util.List;

public class Main {

    private static final JSONObject jsonObj = new JSONObject();

    public static void main(String[] args) {
        Type1 metodo1 = new Type1();
        List<Elemento> danosGerarquizados = metodo1.start();

        System.out.println(jsonObj.append("Daños", danosGerarquizados).toString(1));
    }
}
