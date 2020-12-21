package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DuaActivity extends AppCompatActivity {
    private ImageView imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);
        Toast.makeText(this,"Требуется подключение к интернету",Toast.LENGTH_LONG).show();
        String imageUri10 ="https://i.ibb.co/YDzj9vQ/duax10.png";
        String imageUri9 ="https://i.ibb.co/0jqJR7Q/duax9.png";
        String imageUri8 ="https://i.ibb.co/M9TZfBv/duax8.png";
        String imageUri7 ="https://i.ibb.co/34JsnbP/duax7.png";
        String imageUri6 ="https://i.ibb.co/nPP1Dtq/duax6.png";
        String imageUri5 ="https://i.ibb.co/84xKX5t/duax5.png";
        String imageUri4 ="https://i.ibb.co/kGQLw1w/duax4.png";
        String imageUri3 ="https://i.ibb.co/LZWyY7p/duax3.png";
        String imageUri2 ="https://i.ibb.co/khCWCNQ/duax2.png";
        String imageUri ="https://i.ibb.co/djTxpFN/duax.png";
        imageView10 = findViewById(R.id.duax10);
        imageView9 = findViewById(R.id.duax9);
        imageView8 = findViewById(R.id.duax8);
        imageView7 = findViewById(R.id.duax7);
        imageView6 = findViewById(R.id.duax6);
        imageView5 = findViewById(R.id.duax5);
        imageView4 = findViewById(R.id.duax4);
        imageView3 = findViewById(R.id.duax3);
        imageView2 = findViewById(R.id.duax2);
        imageView = findViewById(R.id.duax);
        Picasso.get().load(imageUri10).fit().into(imageView10);
        Picasso.get().load(imageUri9).fit().into(imageView9);
        Picasso.get().load(imageUri8).fit().into(imageView8);
        Picasso.get().load(imageUri7).fit().into(imageView7);
        Picasso.get().load(imageUri6).fit().into(imageView6);
        Picasso.get().load(imageUri5).fit().into(imageView5);
        Picasso.get().load(imageUri4).fit().into(imageView4);
        Picasso.get().load(imageUri3).fit().into(imageView3);
        Picasso.get().load(imageUri2).fit().into(imageView2);
        Picasso.get().load(imageUri).fit().into(imageView);

    }
}