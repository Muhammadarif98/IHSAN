package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TarikatActivity extends AppCompatActivity {
    Button counter;
    Button rabita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarikat);
        counter = findViewById(R.id.count);
        rabita = findViewById(R.id.rabita);

        counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count();
            }
        });
        rabita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rabita();
            }
        });


    }
    public void count(){
        Intent intent = new Intent(this,CountActivity.class);
        startActivity(intent);
    }
    public void rabita(){
        Intent intent = new Intent(this,RabitaActivity.class);
        startActivity(intent);
    }
}