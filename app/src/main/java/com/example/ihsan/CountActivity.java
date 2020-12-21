package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;


public class CountActivity extends AppCompatActivity  {
    private TextView mColichestvo;
    private Button count, reset,reset2;
    private ImageView sotca;
    private SharedPreferences mPrefs;
    private MediaPlayer sound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        count = findViewById(R.id.count);
        sotca = findViewById(R.id.sotka);
        reset = findViewById(R.id.reset);
        reset2 = findViewById(R.id.reset2);
        mColichestvo = findViewById(R.id.colichestvo);
        String id = "ID";
        //click = MediaPlayer.create(this,R.raw.klik);
        sound = MediaPlayer.create(this,R.raw.zwuk);
        mPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        updateValue(getValue(id),id);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(getValue(id) + 1, id);
                soundic();
                //soundPlay(click);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateValue(getValue(id) - getValue(id), id);
                resetImg(id);
                //soundPlay(click);
            }
        });
        reset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mColichestvo.getText().toString().equals("0")){
                    updateValue(getValue(id) - getValue(id), id);
                }else {
                updateValue(getValue(id) - 1, id);
                }
                resetImg(id);
                //soundPlay(click);
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
    public void soundic() {
        if (mColichestvo.getText().toString().equals("100")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("200")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("300")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("400")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("500")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("600")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("700")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("800")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("900")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("1000")) {
            soundPlay(sound);
        }

        else if (mColichestvo.getText().toString().equals("1001")) {
        } else if (mColichestvo.getText().toString().equals("1100")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("1200")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("1300")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("1400")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("1500")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("1600")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("1700")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("1800")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("1900")) {
            soundPlay(sound);
        }else if (mColichestvo.getText().toString().equals("2000")) {
            soundPlay(sound);
        }

        else if (mColichestvo.getText().toString().equals("2001")) {
        } else if (mColichestvo.getText().toString().equals("2100")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("2200")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("2300")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("2400")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("2500")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("2600")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("2700")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("2800")) {
            soundPlay(sound);
        } else if (mColichestvo.getText().toString().equals("2900")) {
            soundPlay(sound);
        }else if (mColichestvo.getText().toString().equals("3000")) {
            soundPlay(sound);
        }
    }


    public void soundPlay(MediaPlayer sound){
        sound.start();
    }


}
