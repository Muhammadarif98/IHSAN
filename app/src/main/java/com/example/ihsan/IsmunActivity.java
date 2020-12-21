package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageView;
import android.widget.MediaController;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class IsmunActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ismun);
        Toast.makeText(this,"Требуется подключение к интернету",Toast.LENGTH_LONG).show();
        String imageUri ="https://i.ibb.co/zQcVqW0/ismun.png";
        imageView = findViewById(R.id.ismun);
        Picasso.get().load(imageUri).fit().into(imageView);

    }
}