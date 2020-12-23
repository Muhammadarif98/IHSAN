package com.example.ihsan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class HizbuActivity extends AppCompatActivity {
    private  ImageView imagePlayPause;
    private TextView textCurentTime,textTotalDuration;
    private SeekBar playerSeekBar;
    private MediaPlayer mediaPlayer;
    private Handler handler = new Handler();

    private ImageView imageView,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hizbu);

        imagePlayPause = findViewById(R.id.imagePlayPause);
        textCurentTime = findViewById(R.id.textCurrentTime);
        textTotalDuration = findViewById(R.id.textTotalDuration);
        playerSeekBar = findViewById(R.id.playerSeekBar);
        mediaPlayer = MediaPlayer.create(this,R.raw.hizbu1);
        playerSeekBar.setMax(100);

        imagePlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(mediaPlayer.isPlaying()){
                   handler.removeCallbacks(updater);
                   mediaPlayer.pause();
                   imagePlayPause.setImageResource(R.drawable.playh);

               }else {
                   mediaPlayer.start();
                   textTotalDuration.setText(R.string.zero2);
                   imagePlayPause.setImageResource(R.drawable.pauseh);
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
                imagePlayPause.setImageResource(R.drawable.playh);
                textCurentTime.setText(R.string.zero);
                textTotalDuration.setText(R.string.zero);
                //mediaPlayer.reset();
                prepareMediaPlayer();
            }
        });

        { Toast.makeText(this,"Для просмотра изображений подключите интернет",Toast.LENGTH_LONG).show();
        String imageUri11 ="https://i.ibb.co/z8GPZJF/hiz11.png";
        String imageUri10 ="https://i.ibb.co/jGxM8Y9/hiz10.png";
        String imageUri9 ="https://i.ibb.co/wpbG5C2/hiz9.png";
        String imageUri8 ="https://i.ibb.co/Jy4d6hS/hiz8.png";
        String imageUri7 ="https://i.ibb.co/b6PHcQS/hiz7.png";
        String imageUri6 ="https://i.ibb.co/k0sNW89/hiz6.png";
        String imageUri5 ="https://i.ibb.co/0FHLGhs/hiz5.png";
        String imageUri4 ="https://i.ibb.co/k4b05Y4/hiz4.png";
        String imageUri3 ="https://i.ibb.co/h8z3G7d/hiz3.png";
        String imageUri2 ="https://i.ibb.co/nBdkyn2/hiz2.png";
        String imageUri ="https://i.ibb.co/Jzffjpz/hiz1.png";
        imageView11 = findViewById(R.id.hiz11);
        imageView10 = findViewById(R.id.hiz10);
        imageView9 = findViewById(R.id.hiz9);
        imageView8 = findViewById(R.id.hiz8);
        imageView7 = findViewById(R.id.hiz7);
        imageView6 = findViewById(R.id.hiz6);
        imageView5 = findViewById(R.id.hiz5);
        imageView4 = findViewById(R.id.hiz4);
        imageView3 = findViewById(R.id.hiz3);
        imageView2 = findViewById(R.id.hiz2);
        imageView = findViewById(R.id.hiz1);
        Picasso.get().load(imageUri11).fit().into(imageView11);
        Picasso.get().load(imageUri10).fit().into(imageView10);
        Picasso.get().load(imageUri9).fit().into(imageView9);
        Picasso.get().load(imageUri8).fit().into(imageView8);
        Picasso.get().load(imageUri7).fit().into(imageView7);
        Picasso.get().load(imageUri6).fit().into(imageView6);
        Picasso.get().load(imageUri5).fit().into(imageView5);
        Picasso.get().load(imageUri4).fit().into(imageView4);
        Picasso.get().load(imageUri3).fit().into(imageView3);
        Picasso.get().load(imageUri2).fit().into(imageView2);
        Picasso.get().load(imageUri).fit().into(imageView);}
    }
    // https://files.fm/f/c9bwethkj
   private void prepareMediaPlayer(){
        try{
            //mediaPlayer.setDataSource("https://files.fm/pa/marip55598/hizbu_imama_an_Navavi__%28hewbi.com%29.mp3/hizbu_imama_an_Navavi__%28hewbi.com%29.mp3");
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
    public void home3(){
        Intent intent = new Intent(this,PoleActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        home3();
        mediaPlayer.pause();

    }
}