package com.example.galgeleg.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.media.SoundPool.Builder;

import com.example.galgeleg.MainActivity;
import com.example.galgeleg.R;

public class DuHarVundet extends AppCompatActivity implements View.OnClickListener {

    Button knap;
    Button knap2;
    TextView ordetVar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du_har_vundet);

        MediaPlayer play = MediaPlayer.create(DuHarVundet.this, R.raw.applause2);
        play.start();

        knap = findViewById(R.id.vundet_return);
        knap2 = findViewById(R.id.button2);
        ordetVar = findViewById(R.id.ordetVarVundet);

        knap.setOnClickListener(this);
        knap2.setOnClickListener(this);

        String ordet = PreferenceManager.getDefaultSharedPreferences(this).getString("Ordet", "defaultStringIfNothingFound");
        TextView tv = findViewById(R.id.ordetVarVundet);
        tv.setText("Ordet du skulle gætte var: " + ordet);
    }

    @Override
    public void onClick(View ClickButton) {
        if (ClickButton == knap) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        } if(ClickButton == knap2){
            Intent i = new Intent(this, HighScore.class);
            startActivity(i);
        }

    }
}
