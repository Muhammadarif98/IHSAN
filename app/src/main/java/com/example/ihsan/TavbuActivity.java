package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class TavbuActivity extends AppCompatActivity {
    private ImageView imageView,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tavbu);
        Toast.makeText(this,"Требуется подключение к интернету",Toast.LENGTH_LONG).show();
        String imageUri2 ="https://i.ibb.co/n64Wj8V/tavbukh.png";
        String imageUri ="https://i.ibb.co/SRk8FVv/tavbus.png";
        imageView2 = findViewById(R.id.tavbukh);
        imageView = findViewById(R.id.tavbus);
        Picasso.get().load(imageUri2).fit().into(imageView2);
        Picasso.get().load(imageUri).fit().into(imageView);
    }
}