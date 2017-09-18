package com.example.junior.moneyhelper.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.junior.moneyhelper.R;
import com.example.junior.moneyhelper.models.Operation;
import com.example.junior.moneyhelper.repositories.OpeRepo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt1;
    TextView txt2;
    TextView txt3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        txt1 = (TextView) findViewById(R.id.ahorrotxt);
        txt2 = (TextView) findViewById(R.id.efectivotxt);
        txt3 = (TextView) findViewById(R.id.creditotxt);

        OpeRepo opR = OpeRepo.getInstance();
        List <Operation> operations = opR.getOperaciones();

        double cont = 0;
        double ahorroSaldo = 0;
        double creditoSaldo = 0;
        double efectivoSaldo = 0;

        for (Operation op: operations){

            String tipoDinero = op.getTipo();
            Double monto = op.getMonto();
            String cuenta = op.getCuenta();

            if (tipoDinero.equals("Ingreso")){
                switch (cuenta){
                    case "Tarjeta de Credito":
                        creditoSaldo = creditoSaldo + monto;
                        break;
                    case "Ahorro":
                        ahorroSaldo = ahorroSaldo + monto;
                        break;
                    case "Efectivo":
                        efectivoSaldo = efectivoSaldo + monto;
                        break;
                }
            }else {
                switch (cuenta){
                    case "Tarjeta de Credito":
                        creditoSaldo = creditoSaldo - monto;
                        break;
                    case "Ahorro":
                        ahorroSaldo = ahorroSaldo - monto;
                        break;
                    case "Efectivo":
                        efectivoSaldo = efectivoSaldo - monto;
                        break;
                }
            }
        }

        txt1.setText(String.valueOf(ahorroSaldo));
        txt2.setText(String.valueOf(creditoSaldo));
        txt3.setText(String.valueOf(efectivoSaldo));


    }

    public void addItem(View view){
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
