package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button knap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        knap = findViewById(R.id.knap);
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

        }
    }
}