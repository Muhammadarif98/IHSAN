package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class IstiharaActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istihara);
        Toast.makeText(this,"Требуется подключение к интернету",Toast.LENGTH_LONG).show();
        String imageUri ="https://i.ibb.co/dtjcC2h/istihara.png";
        imageView = findViewById(R.id.istiharaa);
        Picasso.get().load(imageUri).fit().into(imageView);
    }
}