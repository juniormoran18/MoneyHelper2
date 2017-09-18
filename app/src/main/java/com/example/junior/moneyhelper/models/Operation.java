package com.example.junior.moneyhelper.models;

/**
 * Created by Junior on 14/09/17.
 */

public class Operation {

    private double monto;
    private String tipo;
    private String cuenta;


    public Operation(){

    }

    public Operation(double monto, String tipo, String cuenta) {
        this.monto = monto;
        this.tipo = tipo;
        this.cuenta = cuenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "monto=" + monto +
                ", tipo='" + tipo + '\'' +
                ", cuenta='" + cuenta + '\'' +
                '}';
    }
}
