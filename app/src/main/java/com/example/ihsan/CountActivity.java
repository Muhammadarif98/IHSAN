package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class CountActivity extends AppCompatActivity {
    TextView mColichestvo;
    Button count;
    Button reset;
    ImageView sotca;
    SharedPreferences mPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        count = findViewById(R.id.count);
        sotca = findViewById(R.id.sotka);
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
                resetImg(id);
            }
        });

          }


    public void updateValue(int newValue,String id){
        mPrefs.edit().putInt(id, newValue).apply();
        mColichestvo.setText(String.valueOf(newValue));
        sotka(id);
    }
    public int getValue(String id){
        sotka(id);
        return mPrefs.getInt(id,0);
    }

    public void sotka(String id) {
        if (mColichestvo.getText().toString().equals("100")) {
            sotca.setImageResource(R.drawable.sotka1);
        } else if (mColichestvo.getText().toString().equals("200")) {
            sotca.setImageResource(R.drawable.sotka2);
        } else if (mColichestvo.getText().toString().equals("300")) {
            sotca.setImageResource(R.drawable.sotka3);
        } else if (mColichestvo.getText().toString().equals("400")) {
            sotca.setImageResource(R.drawable.sotka4);
        } else if (mColichestvo.getText().toString().equals("500")) {
            sotca.setImageResource(R.drawable.sotka5);
        } else if (mColichestvo.getText().toString().equals("600")) {
            sotca.setImageResource(R.drawable.sotka6);
        } else if (mColichestvo.getText().toString().equals("700")) {
            sotca.setImageResource(R.drawable.sotka7);
        } else if (mColichestvo.getText().toString().equals("800")) {
            sotca.setImageResource(R.drawable.sotka8);
        } else if (mColichestvo.getText().toString().equals("900")) {
            sotca.setImageResource(R.drawable.sotka9);
        } else if (mColichestvo.getText().toString().equals("1000")) {
            sotca.setImageResource(R.drawable.sotka10);
        }

        else if (mColichestvo.getText().toString().equals("1001")) {
            sotca.setImageResource(R.drawable.tisyach);
        } else if (mColichestvo.getText().toString().equals("1100")) {
            sotca.setImageResource(R.drawable.tisyach1);
        } else if (mColichestvo.getText().toString().equals("1200")) {
            sotca.setImageResource(R.drawable.tisyach2);
        } else if (mColichestvo.getText().toString().equals("1300")) {
            sotca.setImageResource(R.drawable.tisyach3);
        } else if (mColichestvo.getText().toString().equals("1400")) {
            sotca.setImageResource(R.drawable.tisyach4);
        } else if (mColichestvo.getText().toString().equals("1500")) {
            sotca.setImageResource(R.drawable.tisyach5);
        } else if (mColichestvo.getText().toString().equals("1600")) {
            sotca.setImageResource(R.drawable.tisyach6);
        } else if (mColichestvo.getText().toString().equals("1700")) {
            sotca.setImageResource(R.drawable.tisyach7);
        } else if (mColichestvo.getText().toString().equals("1800")) {
            sotca.setImageResource(R.drawable.tisyach8);
        } else if (mColichestvo.getText().toString().equals("1900")) {
            sotca.setImageResource(R.drawable.tisyach9);
        }else if (mColichestvo.getText().toString().equals("2000")) {
            sotca.setImageResource(R.drawable.dvatisyach);
        }

        else if (mColichestvo.getText().toString().equals("2001")) {
            sotca.setImageResource(R.drawable.dvat);
        } else if (mColichestvo.getText().toString().equals("2100")) {
            sotca.setImageResource(R.drawable.dvat1);
        } else if (mColichestvo.getText().toString().equals("2200")) {
            sotca.setImageResource(R.drawable.dvat2);
        } else if (mColichestvo.getText().toString().equals("2300")) {
            sotca.setImageResource(R.drawable.dvat3);
        } else if (mColichestvo.getText().toString().equals("2400")) {
            sotca.setImageResource(R.drawable.dvat4);
        } else if (mColichestvo.getText().toString().equals("2500")) {
            sotca.setImageResource(R.drawable.dvat5);
        } else if (mColichestvo.getText().toString().equals("2600")) {
            sotca.setImageResource(R.drawable.dvat6);
        } else if (mColichestvo.getText().toString().equals("2700")) {
            sotca.setImageResource(R.drawable.dvat7);
        } else if (mColichestvo.getText().toString().equals("2800")) {
            sotca.setImageResource(R.drawable.dvat8);
        } else if (mColichestvo.getText().toString().equals("2900")) {
            sotca.setImageResource(R.drawable.dvat9);
        }else if (mColichestvo.getText().toString().equals("3000")) {
            sotca.setImageResource(R.drawable.trit);
        }
        }

        public void resetImg(String id){
            if (mColichestvo.getText().toString().equals("0")) {
                sotca.setImageResource(R.drawable.sotka);
        }
    }
}
