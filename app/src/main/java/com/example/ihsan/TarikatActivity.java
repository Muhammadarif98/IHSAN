package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class TarikatActivity extends AppCompatActivity {
   private Button counter,rabita,vird,silsila,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarikat);
        counter = findViewById(R.id.count);
        rabita = findViewById(R.id.rabita);
        vird = findViewById(R.id.vird);
        silsila = findViewById(R.id.silsila);
        home = findViewById(R.id.hometarikat);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home();
            }
        });
        vird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vird();
            }
        });
        silsila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                silsila();
            }
        });
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
    public void home(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    public void vird(){
        Intent intent = new Intent(this,VirdActivity.class);
        startActivity(intent);
    }
    public void silsila(){
        Intent intent = new Intent(this,SilsilyaActivity.class);
        startActivity(intent);
    }
}