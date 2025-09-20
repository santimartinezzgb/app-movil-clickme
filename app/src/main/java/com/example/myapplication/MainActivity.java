package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button button_back = findViewById(R.id.button_back);
        TextView textView = findViewById(R.id.textView);
        EditText input = findViewById(R.id.input);

        button.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String texto = input.getText().toString().trim();

                if(texto.trim().equals("cabron")){
                    Toast.makeText(MainActivity.this, "Palabra prohibida detectada" , Toast.LENGTH_SHORT).show();

                }else if(texto.isEmpty()){
                    Toast.makeText(MainActivity.this, "Por favor ingresa tu nombre", Toast.LENGTH_SHORT).show();

                } else{
                    button_back.setVisibility(View.VISIBLE);
                    input.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    textView.setVisibility(View.VISIBLE);
                    textView.setText("Hola" + " " + texto);
                }

            }
        });

        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                button_back.setVisibility(View.GONE);
                input.setText("");
                input.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
            }
        });
    }
}