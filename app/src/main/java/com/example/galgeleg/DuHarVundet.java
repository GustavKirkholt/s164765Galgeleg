package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DuHarVundet extends AppCompatActivity implements View.OnClickListener {

    Button knap;
    TextView ordetVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du_har_vundet);

        knap = findViewById(R.id.vundet_return);
        ordetVar = findViewById(R.id.ordetVarVundet);

        knap.setOnClickListener(this);

        String ordet = PreferenceManager.getDefaultSharedPreferences(this).getString("Ordet", "defaultStringIfNothingFound");
        TextView tv = findViewById(R.id.ordetVarVundet);
        tv.setText("ordet du skulle gætte var: " + ordet);
    }

    @Override
    public void onClick(View ClickButton) {
        if (ClickButton == knap) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
    }
}