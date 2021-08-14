package com.example.calculadora_imc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.icu.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText kg,a;
    private TextView resul,catego;
    private Button btn;
    private Double c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                calcularIMC();
                categoriaIMC();
            }
        });


    }

    private void inicializar() {
        kg = findViewById(R.id.campo_peso);
        a = findViewById(R.id.campo_altura);
        btn = findViewById(R.id.button);
        resul = findViewById(R.id.textView_resultado);
        catego = findViewById(R.id.textView_categoria);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void calcularIMC(){
        double mass = Double.parseDouble(kg.getText().toString());
        double height = Double.parseDouble(a.getText().toString());
        double f = mass/Math.pow(height,2.0);
        c = f;
        DecimalFormat df = new DecimalFormat("#.##");
        double imc_formato = Double.parseDouble(df.format(f));
        resul.setText(Double.toString(imc_formato));
    }

    private void categoriaIMC(){
        if(c>=0 && c<=15){
            catego.setText("muy gravemente por debajo del peso normal");
        }else if(c>=15 && c<=16){
            catego.setText("severamente bajo de peso");
        }else if(c>=16 && c<=18.5){
            catego.setText("bajo de peso");
        }else if(c>=18.5 && c<=25){
            catego.setText("Normal(peso saludable)");
        }else if(c>=25 && c<=30){
            catego.setText("Sobrepeso");
        }else if(c>=30 && c<=35){
            catego.setText("Obesidad clase 1"+"\n"+"Moderadamente obeso");
        }else if(c>=35 && c<=40){
            catego.setText("Obesidad clase 2"+"\n"+"Severamente obeso");
        }else{
            catego.setText("Obesidad clase 3"+"\n"+"Muy severamente obeso");
        }
    }


}