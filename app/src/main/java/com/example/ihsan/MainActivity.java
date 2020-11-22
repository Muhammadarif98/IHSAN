package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    // Основная реализация программы
    ImageView h1x;
    ImageView h2x;
    ImageView h3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h1x = findViewById(R.id.h1x);
        h1x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarikat();
            }
        });
        h2x=findViewById(R.id.h2x);
        h2x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                poleznoe();
            }
        });
        h3=findViewById(R.id.h3);
        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sravka();
            }
        });
    }
    public void tarikat(){
        Intent intent = new Intent(this,TarikatActivity.class);
        startActivity(intent);
    }
    public void poleznoe(){
        Intent intent = new Intent(this,PoleActivity.class);
        startActivity(intent);
    }
    public void sravka(){
        Intent intent = new Intent(this,SpravkActivity.class);
        startActivity(intent);
    }

}
