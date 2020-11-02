package com.example.galgeleg.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.Collections;

public class HighScore extends AppCompatActivity implements AdapterView.OnItemClickListener {


    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
    //super.onCreate(savedInstanceState);
// setContentView(R.layout.activity_high_score);

    // String username = PreferenceManager.getDefaultSharedPreferences(this).getString("Brugernavn", "defaultStringIfNothingFound");

    //String ordet = PreferenceManager.getDefaultSharedPreferences(this).getString("Ordet", "defaultStringIfNothingFound");

    // int score = PreferenceManager.getDefaultSharedPreferences(this).getInt("Score", 0);

    //ArrayAdapter adapter1 = new ArrayAdapter(this, R.layout.activity_high_score, R.id.listeelementUsername, Collections.singletonList(username));
    //ArrayAdapter adapter2 = new ArrayAdapter(this, R.layout.activity_high_score, R.id.listeelementOrd, Collections.singletonList(ordet));
    //ArrayAdapter adapter3 = new ArrayAdapter(this, R.layout.activity_high_score, R.id.listeelementScore, Collections.singletonList(score));

    // GridView gridView = new GridView(this);
    // gridView.setOnItemClickListener(this);
    //gridView.setNumColumns(GridView.AUTO_FIT);

    //gridView.setAdapter(adapter1);
    //gridView.setAdapter(adapter2);
    //gridView.setAdapter(adapter3);

    // setContentView(gridView);
    // }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }
}
