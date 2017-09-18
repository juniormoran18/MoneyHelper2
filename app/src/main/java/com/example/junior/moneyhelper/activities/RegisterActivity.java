package com.example.junior.moneyhelper.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junior.moneyhelper.R;
import com.example.junior.moneyhelper.models.Operation;
import com.example.junior.moneyhelper.repositories.OpeRepo;

/**
 * Created by Junior on 11/09/17.
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText monto;
    private Spinner cuenta;
    private String t;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        monto = (EditText) findViewById(R.id.montoet);
        cuenta = (Spinner)findViewById(R.id.spcuenta);

    }

    public void tipo(View view){
        switch (((RadioButton) view).getText().toString()){
            case "Ingreso":
                t = "Ingreso";
                break;
            case "Egreso":
                t = "Egreso";
                break;
        }
    }


    public void register(View view ){


        double ahorroSaldo = 0;
        double creditoSaldo = 0;
        double efectivoSaldo = 0;
        String m = monto.getText().toString();
        String c = cuenta.getSelectedItem().toString();

        if(m.isEmpty() || c.isEmpty()){
            Toast.makeText(this, "Debes completar todos los datos", Toast.LENGTH_SHORT).show();
            return;
        }

        //Analizamos si va a sumar o restar a nuestros montos


        //Pasar a nuestro MainActivity nuestros Saldos Totales

        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        intent.putExtra("dato", ahorroSaldo);
        intent.putExtra("dato1", creditoSaldo);
        intent.putExtra("dato2", efectivoSaldo);
        startActivity(intent);


        //Guardar datos en un array
        Operation operacion = new Operation( Double.parseDouble(m),t ,c);
        OpeRepo opeRepo = OpeRepo.getInstance();
        opeRepo.agregarOpe(operacion);

        finish();

    }
}
