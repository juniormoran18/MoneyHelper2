package com.example.junior.moneyhelper.repositories;

import com.example.junior.moneyhelper.models.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior on 14/09/17.
 */

public class OpeRepo {

    private static List<Operation> operaciones = new ArrayList<>();

    public  static List<Operation> getOperaciones() {
        return operaciones;
    }

    public static void agregarOpe(Operation operacion){
        operaciones.add(operacion);
    }
}
