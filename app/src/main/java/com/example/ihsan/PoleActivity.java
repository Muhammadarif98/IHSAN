package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PoleActivity extends AppCompatActivity {

    private Button dua,tavbu,hizbu,istihara,ismun,salavat,home2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pole);

        home2 = findViewById(R.id.home2);
        dua= findViewById(R.id.dua);
        tavbu = findViewById(R.id.tavbu);
        hizbu = findViewById(R.id.hizbu);
        istihara = findViewById(R.id.istihara);
        ismun = findViewById(R.id.ismun);
        salavat = findViewById(R.id.salavat);

        home2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                home2();
            }
        });

        dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dua();
            }
        });
        tavbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tavbu();
            }
        });
        hizbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hizbu();
            }
        });
        istihara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                istihara();
            }
        });
        ismun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ismun();
            }
        });
        salavat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salavat();
            }
        });
    }

    public void dua(){
        Intent intent = new Intent(this,DuaActivity.class);
        startActivity(intent);
    }
    public void tavbu(){
        Intent intent = new Intent(this,TavbuActivity.class);
        startActivity(intent);
    }
    public void hizbu(){
        Intent intent = new Intent(this,HizbuActivity.class);
        startActivity(intent);
    }
    public void istihara(){
        Intent intent = new Intent(this,IstiharaActivity.class);
        startActivity(intent);
    }
    public void ismun(){
        Intent intent = new Intent(this,IsmunActivity.class);
        startActivity(intent);
    }
    public void salavat(){
        Intent intent = new Intent(this,SalavatActivity.class);
        startActivity(intent);
    }
    public void home2(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}