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

import com.example.galgeleg.R;

import java.util.ArrayList;
import java.util.Collections;

public class HighScore extends AppCompatActivity implements R {

    private ArrayList<String> highscore = new ArrayList<>();
    private SharedPreferences prefs;
    MyRecipeListAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        prefs = PreferenceHelper.getApplicationPreferences(this);
        updateListOfBrews();

        RecyclerView listView = this.findViewById(R.id.myrecipes_List);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.scrollToPosition(0);

        recyclerViewAdapter = new MyRecipeListAdapter(brews, this);

        listView.setAdapter(recyclerViewAdapter);

    }
}
