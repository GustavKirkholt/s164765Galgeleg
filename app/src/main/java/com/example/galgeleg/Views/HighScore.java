package com.example.galgeleg.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.galgeleg.MainActivity;
import com.example.galgeleg.R;

import java.util.ArrayList;
import java.util.Collections;

public class HighScore extends AppCompatActivity implements View.OnClickListener {

    Button tilbage;

    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<Integer> scores = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String username = PreferenceManager.getDefaultSharedPreferences(this).getString("Brugernavn", "defaultStringIfNothingFound");
        int score = PreferenceManager.getDefaultSharedPreferences(this).getInt("Score", 0);

        this.usernames.add(username);
        this.scores.add(score);

        adapter = () //indsæt min recyclerview adapter her.

        RecyclerView listView = this.findViewById(R.id.highscore);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.scrollToPosition(0);

        listView.setAdapter(); = new RecyclerView.(usernames, scores, this);

        listView.setAdapter(adapter);

        setContentView(listView);

        tilbage = findViewById(R.id.tilbagehighscore);
        tilbage.setOnClickListener(this);


    }

    @Override
    public void onClick(View ButtonClick) {
        if(ButtonClick == tilbage){
            Intent i = new Intent(this, MainActivity.class);
            finishAffinity();
            startActivity(i);
        }
    }
}
