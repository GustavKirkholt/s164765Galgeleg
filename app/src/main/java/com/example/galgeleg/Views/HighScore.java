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

public class HighScore extends AppCompatActivity implements View.OnClickListener {

    Button tilbage;

    private ArrayList<String> highscores = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String username = PreferenceManager.getDefaultSharedPreferences(this).getString("Brugernavn", "defaultStringIfNothingFound");
        int score = PreferenceManager.getDefaultSharedPreferences(this).getInt("Score", 0);


        this.highscores.add(username);
        this.highscores.add(String.valueOf(score));

        adapter = () //indsæt min recyclerview adapter her.

        RecyclerView listView = this.findViewById(R.id.highscore);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.scrollToPosition(0);

        listView.setAdapter(ListeelemAdapter) = new RecyclerView.(usernames, scores, this);

        listView.setAdapter(ListeelemAdapter);

        setContentView(listView);

        tilbage = findViewById(R.id.tilbagehighscore);
        tilbage.setOnClickListener(this);


    }

    @Override
    public void onClick(View ButtonClick) {
            if (ButtonClick == tilbage) {
                Intent i = new Intent(this, MainActivity.class);
                finishAffinity();
                startActivity(i);
    }

    class ListeelemAdapter extends RecyclerView.Adapter<ListeelemViewholder> {
        @Override
        public int getItemCount() {
            return highscores.size();
        }

        @Override
        public ListeelemViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View listeelementViews = getLayoutInflater().inflate(R.layout.activity_high_score, parent, false);
            ListeelemViewholder vh = new ListeelemViewholder(listeelementViews);
            return vh;
        }

        @Override
        public void onBindViewHolder(ListeelemViewholder vh, int position) {
            vh.overskrift.setText(highscores.get(position));
            if (position > 0) vh.overskrift.append(" (flyt op)");

        }
    }

    ;

    class ListeelemViewholder extends RecyclerView.ViewHolder {
        TextView overskrift;

        public ListeelemViewholder(View listeelementViews) {
            super(listeelementViews);
            overskrift = listeelementViews.findViewById(R.id.listeelem_overskrift);
            // Gør listeelementer klikbare og vis det ved at deres baggrunsfarve ændrer sig ved berøring
            overskrift.setBackgroundResource(android.R.drawable.list_selector_background);
            overskrift.setOnClickListener(this);

        }
        }
    }
}
