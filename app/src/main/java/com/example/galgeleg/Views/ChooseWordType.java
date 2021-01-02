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


public class ChooseWordType extends AppCompatActivity implements AdapterView.OnItemClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final String[] valgmuligheder = {"Nemt", "Svært", "Hent Fra DR"};

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_choose_word_type, R.id.listeelement, valgmuligheder);

        ListView listView = new ListView(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);

        setContentView(listView);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
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
}