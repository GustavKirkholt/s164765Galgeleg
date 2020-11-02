package com.example.galgeleg;

// Gustav Kirkholt s164765

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.galgeleg.Views.ChooseUsername_frag;
import com.example.galgeleg.Views.HighScore;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button knap;
    Button knap2;
    ImageView billede;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        knap = findViewById(R.id.knap);
        knap2 = findViewById(R.id.highScoreknap);
        billede = findViewById(R.id.forsideBillede);

        knap2.setOnClickListener(this);
        knap.setOnClickListener(this);
    }

    @Override
    public void onClick(View ClickButton) {

        if (ClickButton == knap) {
            getFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                    .replace(R.id.fragmentindhold, new ChooseUsername_frag())
                    .addToBackStack(null)
                    .commit();
            knap.setVisibility(View.INVISIBLE);
            knap2.setVisibility(View.INVISIBLE);
            billede.setVisibility(View.GONE);


        } else if (ClickButton == knap2 ){
            Intent i = new Intent(this, HighScore.class);
            startActivity(i);
        }
    }
}