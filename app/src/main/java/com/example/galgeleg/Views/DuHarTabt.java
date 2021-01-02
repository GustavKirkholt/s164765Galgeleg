package com.example.galgeleg.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ComputableLiveData;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.galgeleg.MainActivity;
import com.example.galgeleg.R;


public class DuHarTabt extends AppCompatActivity implements View.OnClickListener{

    Button knap;
    TextView ordetVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du_har_tabt);

        MediaPlayer play = MediaPlayer.create(DuHarTabt.this, R.raw.boohiss);
        play.start();

        knap = findViewById(R.id.return_tabt);
        ordetVar = findViewById(R.id.ordetVarTabt);

        knap.setOnClickListener(this);


        String ordet = PreferenceManager.getDefaultSharedPreferences(this).getString("Ordet", "defaultStringIfNothingFound");
        TextView tv = findViewById(R.id.ordetVarTabt);
        tv.setText("ordet du skulle gætte var: " + ordet);

    }

    @Override
    public void onClick(View ClickButton) {
        if (ClickButton == knap){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }
}