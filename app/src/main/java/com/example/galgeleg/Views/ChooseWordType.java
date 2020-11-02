package com.example.galgeleg.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.galgeleg.NemmeOrd;
import com.example.galgeleg.R;
import com.example.galgeleg.SværeOrd;

public class ChooseWordType extends AppCompatActivity implements View.OnClickListener{

    Button knap1;
    Button knap2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_word_type);

        knap1 = findViewById(R.id.nemtOrd);
        knap2 = findViewById(R.id.sværtOrd);

        knap1.setOnClickListener(this);
        knap2.setOnClickListener(this);

    }

    @Override
    public void onClick(View ClickButton) {
        if(ClickButton == knap1){

            Intent i = new Intent(this, NytSpil.class);
            i.putExtra("ord", (new NemmeOrd()).getOrdet());
            startActivity(i);

        } else if (ClickButton == knap2){

            Intent i = new Intent(this, NytSpil.class);
            i.putExtra("ord", (new SværeOrd()).getOrdet());
            startActivity(i);


        }

    }
}