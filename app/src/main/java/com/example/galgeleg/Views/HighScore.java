package com.example.galgeleg.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.galgeleg.MainActivity;
import com.example.galgeleg.R;

import java.util.ArrayList;
import java.util.Collections;

public class HighScore extends AppCompatActivity {

    Button tilbage;

    private ArrayList<String> highscores = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String username = PreferenceManager.getDefaultSharedPreferences(this).getString("Brugernavn", "defaultStringIfNothingFound");
        int score = PreferenceManager.getDefaultSharedPreferences(this).getInt("Score", 0);
        String ordet = PreferenceManager.getDefaultSharedPreferences(this).getString("Ordet", "defaultStringIfNothingFound");

        this.highscores.add(username);
        this.highscores.add(String.valueOf(score));
        this.highscores.add(ordet);

    }
}
