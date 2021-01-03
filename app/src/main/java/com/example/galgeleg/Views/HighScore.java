package com.example.galgeleg.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.galgeleg.R;

import java.util.ArrayList;
import java.util.Collections;

public class HighScore extends AppCompatActivity implements {

    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<Integer> scores = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        String username = PreferenceManager.getDefaultSharedPreferences(this).getString("Brugernavn", "defaultStringIfNothingFound");
        int score = PreferenceManager.getDefaultSharedPreferences(this).getInt("Score", 0);

        this.usernames.add(username);
        this.scores.add(score);


        RecyclerView listView = this.findViewById(R.id.highScore);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.scrollToPosition(0);

        recyclerViewAdapter = new MyRecipeListAdapter(usernames, scores, this);

        listView.setAdapter(recyclerViewAdapter);

    }
}
