package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CountActivity extends AppCompatActivity {
    TextView mColichestvo;
    Button count;
    Button reset;
    SharedPreferences mPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        count = findViewById(R.id.count);
        reset = findViewById(R.id.reset);
        mColichestvo = findViewById(R.id.colichestvo);
        String id = "ID";
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        updateValue(getValue(id),id);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(getValue(id) + 1, id);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(getValue(id) - getValue(id), id);
            }
        });
    }


    public void updateValue(int newValue,String id){
        mPrefs.edit().putInt(id, newValue).apply();
        mColichestvo.setText(String.valueOf(newValue));
    }
    public int getValue(String id){
        return mPrefs.getInt(id,0);
    }
}