package com.example.calcular_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextPeso, editTextAltura;
    TextView textViewIMC, textViewSituacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        textViewIMC = findViewById(R.id.textViewIMC);
        textViewSituacao = findViewById(R.id.textViewSituacao);

        Button buttonCalcular = findViewById(R.id.buttonCalcular);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double peso = Double.parseDouble(editTextPeso.getText().toString());
                double altura = Double.parseDouble(editTextAltura.getText().toString());

                double imc = peso / (altura * altura);

                textViewIMC.setText(String.format("%.2f", imc));

                String situacao;
                if (imc < 18.5) {
                    situacao = "Abaixo do peso";
                } else if (imc < 25) {
                    situacao = "Peso normal";
                } else if (imc < 30) {
                    situacao = "Sobrepeso";
                } else if (imc < 35) {
                    situacao = "Obesidade grau I";
                } else if (imc < 40) {
                    situacao = "Obesidade grau II";
                } else {
                    situacao = "Obesidade grau III";
                }

                textViewSituacao.setText(situacao);

            }
        });
    }
}


