package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class SilsilyaActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silsilya);
        imageView = findViewById(R.id.imageView5);

        final String str[] = {"Шазалийская", "Накшубандийская"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(SilsilyaActivity.this, android.R.layout.simple_dropdown_item_1line, str);
        Spinner spinner = findViewById(R.id.spinner2);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (str[0].equals(spinner.getItemAtPosition(position).toString())) {
                    imageView.setImageResource(R.drawable.silsilash);
                } else if (str[1].equals(spinner.getItemAtPosition(position).toString())) {
                    imageView.setImageResource(R.drawable.silsilan);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}