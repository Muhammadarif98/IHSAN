package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class SalavatActivity extends AppCompatActivity {
    private ImageView imageView,imageView2,imageView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salavat);
        Toast.makeText(this,"Требуется подключение к интернету",Toast.LENGTH_LONG).show();
        String imageUri3 ="https://i.ibb.co/sVhSQ2c/salavatp.png";
        String imageUri2 ="https://i.ibb.co/rQTmKX8/salavatn.png";
        String imageUri ="https://i.ibb.co/9y3v1tt/salavatf.png";
        imageView3 = findViewById(R.id.salavatp);
        imageView2 = findViewById(R.id.salavatn);
        imageView = findViewById(R.id.salavatf);
        Picasso.get().load(imageUri3).fit().into(imageView3);
        Picasso.get().load(imageUri2).fit().into(imageView2);
        Picasso.get().load(imageUri).fit().into(imageView);
    }
}