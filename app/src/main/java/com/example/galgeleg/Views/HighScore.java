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
    RecyclerView recyclerView;

    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> scores = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        recyclerView = findViewById(R.id.recyclerView);

        String username = PreferenceManager.getDefaultSharedPreferences(this).getString("Brugernavn", "defaultStringIfNothingFound");
        int score = PreferenceManager.getDefaultSharedPreferences(this).getInt("Score", 1);
        String ordet = PreferenceManager.getDefaultSharedPreferences(this).getString("Ordet", "defaultStringIfNothingFound");

        this.usernames.add(username);
        this.scores.add(String.valueOf(score));
        this.scores.add(ordet);

        MyAdapter myAdapter = new MyAdapter(this, usernames, scores);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
