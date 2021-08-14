package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Comentario
    private TextView numeros;
    private Button btn_i, btn_r;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    private void inicializar() {
        numeros = (TextView)findViewById(R.id.txt_contador);
        btn_i = findViewById(R.id.button);
        btn_r = findViewById(R.id.button2);

        btn_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementar();
                //Log.i("n: ",String.valueOf(n));
            }
        });

        btn_r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    private void incrementar(){
        ++n;
        numeros.setText(Integer.toString(n));
    }

    private void reset(){
        n=0;
        numeros.setText(Integer.toString(0));
    }

}