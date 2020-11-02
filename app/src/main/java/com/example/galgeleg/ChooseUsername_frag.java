package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.galgeleg.R;

public class ChooseUsername_frag extends Fragment implements View.OnClickListener{
    private View rod;
    Button knap;

    EditText brugernavn;

    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        this.rod = i.inflate(R.layout.activity_choose_username_frag, container, false);

        knap = rod.findViewById(R.id.saveContinue);
        brugernavn = rod.findViewById(R.id.brugerNavn);

        knap.setOnClickListener(this);


        return rod;
    }

    @Override
    public void onClick(View v) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        preferences.edit().putString("Brugernavn", this.brugernavn.getText().toString()).apply();

        Intent intent = new Intent(getActivity(), com.example.galgeleg.ChooseWordType.class);
        startActivity(intent);
    }

}