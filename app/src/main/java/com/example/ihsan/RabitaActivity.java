package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextPaint;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class RabitaActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener{
   private ImageView imageView;
   private TextView textV;
   private ProgressBar progressBar;
   private Button playpause, reset,home,set;
   private long mStartTimeInMillis;
   private EditText mEditTextInput;;
   private MediaPlayer sound;
   private boolean timerRunning;
   private long timeLeftImMillis;
   private CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabita);
        mEditTextInput = findViewById(R.id.editTextInput);
        imageView = findViewById(R.id.img);
        textV = findViewById(R.id.textV);
        playpause = findViewById(R.id.playpause);
        reset = findViewById(R.id.reset);
        home = findViewById(R.id.home);
        set = findViewById(R.id.set);
        sound = MediaPlayer.create(this,R.raw.soundtimer);

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mEditTextInput.getText().toString();
                if (input.length() == 0) {
                    Toast.makeText(RabitaActivity.this, "Поле не может быть пустым", Toast.LENGTH_SHORT).show();
                    return;
                }
                long millisInput = Long.parseLong(input) * 60000;
                if (millisInput == 0) {
                    Toast.makeText(RabitaActivity.this, "Пожалуйста, введите положительное число", Toast.LENGTH_SHORT).show();
                    return;
                }
                setTime(millisInput);
                mEditTextInput.setText("");
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        setTextGradientColour();

        {
            final String str[] = {"Шазалийский", "Накшубандийский"};
            ArrayAdapter arrayAdapter = new ArrayAdapter(RabitaActivity.this, android.R.layout.simple_dropdown_item_1line, str);
            Spinner spinner = findViewById(R.id.spinner);
            spinner.setAdapter(arrayAdapter);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (str[0].equals(spinner.getItemAtPosition(position).toString())) {
                        imageView.setImageResource(R.drawable.shaz);
                    } else if (str[1].equals(spinner.getItemAtPosition(position).toString())) {
                        imageView.setImageResource(R.drawable.nakshub);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }


        playpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timerRunning){
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

    }

    private void setTextGradientColour(){
        TextPaint paint = textV.getPaint();
        float width = paint.measureText("00:00");

        Shader shader = new LinearGradient(0,0,width,textV.getTextSize(),
                new int[]{
                        Color.parseColor("#F803C2"),
                        Color.parseColor("#F81203"),
                        Color.parseColor("#F89603"),
                        Color.parseColor("#F8DF03"),
                },null, Shader.TileMode.CLAMP);
                textV.getPaint().setShader(shader);
    }

    private void setTime(long milliseconds){
        mStartTimeInMillis = milliseconds;
        resetTimer();
        closeKeyboard();

    }

    private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeftImMillis,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftImMillis = millisUntilFinished;
                updateCountDownText();
                updateWatchInterface();
                reset.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onFinish() {
                timerRunning = false;
               // playpause.setVisibility(View.VISIBLE);
               Drawable d = getResources().getDrawable(R.drawable.playx);
               playpause.setBackgroundDrawable(d);
               reset.setVisibility(View.VISIBLE);
               updateWatchInterface();
               soundic();
            }
        }.start();
        updateWatchInterface();
        timerRunning = true;
        soundic();
       // Drawable s = getResources().getDrawable(R.drawable.pausex);
       // playpause.setBackgroundDrawable(s);
    }
    private void pauseTimer(){
        countDownTimer.cancel();
        updateWatchInterface();
        reset.setVisibility(View.VISIBLE);
        timerRunning = false;
        Drawable d = getResources().getDrawable(R.drawable.playx);
        playpause.setBackgroundDrawable(d);
    }
    private void resetTimer(){
        timeLeftImMillis = mStartTimeInMillis;
        updateCountDownText();
        updateWatchInterface();
      //  Drawable d = getResources().getDrawable(R.drawable.playx);
       // playpause.setBackgroundDrawable(d);
        //playpause.setVisibility(View.VISIBLE);
    }



    private void updateCountDownText() {
        int hours = (int) ((timeLeftImMillis / 1000) /3600);
        int minutes = (int) ((timeLeftImMillis / 1000) % 3600) / 60;
        int seconds = (int) (timeLeftImMillis / 1000 ) % 60;

        String timeLeftFormatted;
        if (hours > 0) {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds);
        }
        textV.setText(timeLeftFormatted);
    }
    private void updateWatchInterface(){
        if (timerRunning) {
            //reset.setVisibility(View.INVISIBLE);
            mEditTextInput.setVisibility(View.INVISIBLE);
            set.setVisibility(View.INVISIBLE);
            @SuppressLint("UseCompatLoadingForDrawables") Drawable q = getResources().getDrawable(R.drawable.pausex);
            playpause.setBackgroundDrawable(q);
            sound.pause();
        } else {
            mEditTextInput.setVisibility(View.VISIBLE);
            set.setVisibility(View.VISIBLE);
            @SuppressLint("UseCompatLoadingForDrawables") Drawable a = getResources().getDrawable(R.drawable.playx);
            playpause.setBackgroundDrawable(a);
        }

        if (timeLeftImMillis < 1000) {
            playpause.setVisibility(View.INVISIBLE);
        } else {
            playpause.setVisibility(View.VISIBLE);
        }

        if (timeLeftImMillis < mStartTimeInMillis) {
            reset.setVisibility(View.VISIBLE);
        } else {
            reset.setVisibility(View.INVISIBLE);
        }
    }
    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    public void home(){
        Intent intent = new Intent(this,TarikatActivity.class);
        startActivity(intent);
    }
    public void soundPlay(MediaPlayer sound){
        sound.start();
    }
    public void soundic(){
        soundPlay(sound);
    }
    public void openDialog() {
        ExampleDialog dialog = new ExampleDialog();
        dialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void onYesClicked() {
            home();
            sound.pause();
    }
    @Override
    public void onBackPressed(){
        openDialog();
    }
}