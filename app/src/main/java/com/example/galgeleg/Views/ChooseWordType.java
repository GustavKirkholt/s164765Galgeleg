package com.example.galgeleg.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.galgeleg.MainActivity;
import com.example.galgeleg.NemmeOrd;
import com.example.galgeleg.R;
import com.example.galgeleg.SværeOrd;

import java.util.ArrayList;


public class ChooseWordType extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_word_type);

        final ArrayList<String> valgmuligheder = new ArrayList<>();
        valgmuligheder.add("Nemt");
        valgmuligheder.add("Svært");
        valgmuligheder.add("Hent fra DR");


        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, valgmuligheder));

        spinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            Intent i = new Intent(ChooseWordType.this, NytSpil.class);
            i.putExtra("ord", (new NemmeOrd()).getOrdet());
            startActivity(i);
        } if (position == 1) {
            Intent i = new Intent(this, NytSpil.class);
            i.putExtra("ord", (new SværeOrd()).getOrdet());
            startActivity(i);
        } if (position == 2){
            //TODO Hente ord fra DR
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        return;
    }
}