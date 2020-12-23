package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;

import android.net.Uri;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class IsmunActivity extends AppCompatActivity {
    private ImageView imageView;
    private  ImageView imagePlayPause;
    private TextView textCurentTime,textTotalDuration;
    private SeekBar playerSeekBar;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ismun);
        Toast.makeText(this,"Для просмотра изображения подключите интернет",Toast.LENGTH_LONG).show();
        String imageUri ="https://i.ibb.co/zQcVqW0/ismun.png";
        imageView = findViewById(R.id.ismun);
        Picasso.get().load(imageUri).fit().into(imageView);

        imagePlayPause = findViewById(R.id.imagePlayPause2);
        textCurentTime = findViewById(R.id.textCurrentTime2);
        textTotalDuration = findViewById(R.id.textTotalDuration2);
        playerSeekBar = findViewById(R.id.playerSeekBar2);
        mediaPlayer = MediaPlayer.create(this,R.raw.asmaulhusna);
        playerSeekBar.setMax(100);

        imagePlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    handler.removeCallbacks(updater);
                    mediaPlayer.pause();
                    imagePlayPause.setImageResource(R.drawable.playi);

                }else {
                    mediaPlayer.start();
                    textTotalDuration.setText(R.string.zero3);
                    imagePlayPause.setImageResource(R.drawable.pausei);
                    updateSeekBar();
                }
            }
        });

        prepareMediaPlayer();

        playerSeekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                SeekBar seekBar = (SeekBar) v;
                int playposition = (mediaPlayer.getDuration() / 100) * seekBar.getProgress();
                mediaPlayer.seekTo(playposition);
                textCurentTime.setText(milliSecondsToTimer(mediaPlayer.getCurrentPosition()));
                return false;
            }
        });

        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                playerSeekBar.setSecondaryProgress(percent);
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                playerSeekBar.setProgress(0);
                imagePlayPause.setImageResource(R.drawable.playi);
                textCurentTime.setText(R.string.zero);
                textTotalDuration.setText(R.string.zero);
                prepareMediaPlayer();
            }
        });


    }
    private void prepareMediaPlayer(){
        try{
            mediaPlayer.prepare();
            textTotalDuration.setText(milliSecondsToTimer(mediaPlayer.getDuration()));
        }catch(Exception exception){
            Toast.makeText(this, exception.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private Runnable updater = new Runnable() {
        @Override
        public void run() {
            updateSeekBar();
            long currentDuration = mediaPlayer.getCurrentPosition();
            textCurentTime.setText(milliSecondsToTimer(currentDuration));

        }
    };

    private void updateSeekBar(){
        if (mediaPlayer.isPlaying()){
            playerSeekBar.setProgress((int)(((float) mediaPlayer.getCurrentPosition() / mediaPlayer.getDuration()) * 100));
            handler.postDelayed(updater,1000);
        }
    }

    private String milliSecondsToTimer(long milliseconds){
        Long timeLefts = milliseconds;
        String timerString = "";
        String secondsString ;

        int minutes = (int)(timeLefts % (1000*3600)) / (1000*60);
        int seconds = (int)(timeLefts / 1000) % 60;

        if(seconds < 10){
            secondsString = "0" + seconds;
        }
        else {

            secondsString = "" + seconds;
        }
        timerString = timerString + minutes + ":" + secondsString ;

        return  timerString;
    }
    public void home4(){
        Intent intent = new Intent(this,PoleActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        home4();
        mediaPlayer.pause();

    }
}