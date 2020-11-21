package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    // Основная реализация программы
    ImageView h1;
    ImageView h2;
    ImageView h3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        h1 = findViewById(R.id.h1);
        h1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tovar1();
            }
        });
        h2=findViewById(R.id.h2);
        h2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tovar2();
            }
        });
        h3=findViewById(R.id.h3);
        h3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tovar3();
            }
        });
    }
    public void tovar1(){
        Intent intent = new Intent(this,TarikatActivity.class);
        startActivity(intent);
    }
    public void tovar2(){
        Intent intent = new Intent(this,PoleActivity.class);
        startActivity(intent);
    }
    public void tovar3(){
        Intent intent = new Intent(this,SpravkActivity.class);
        startActivity(intent);
    }

}
