package com.example.junior.moneyhelper.repositories;

import com.example.junior.moneyhelper.models.Operation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Junior on 14/09/17.
 */

public class OpeRepo {

    private static OpeRepo _INSTANCE = null;

    private OpeRepo(){}

    public static OpeRepo getInstance(){
        if(_INSTANCE == null)
            _INSTANCE = new OpeRepo();
        return _INSTANCE;
    }

    public static List<Operation> operaciones = new ArrayList<>();

    public  static List<Operation> getOperaciones() {
        return operaciones;
    }

    public void agregarOpe(Operation operacion){
        this.operaciones.add(operacion);
    }
}
