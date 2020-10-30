package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class HighScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        String username = PreferenceManager.getDefaultSharedPreferences(this).getString("Brugernavn", "defaultStringIfNothingFound");

        String ordet = PreferenceManager.getDefaultSharedPreferences(this).getString("Ordet", "defaultStringIfNothingFound");

        int score = PreferenceManager.getDefaultSharedPreferences(this).getInt("Score", 0);

    }
}