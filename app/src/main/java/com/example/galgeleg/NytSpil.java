package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NytSpil extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    //Variabler
    TextView txwordToBeGuessed;
    EditText userInput;
    TextView nameOfUser;
    TextView txLettersTried;
    ImageView hangMan; //Galjen
    int forkerteBogstaver;
    Button guess;
    Button reset;
    String ordetSynligt;
    String heleOrdet;
    GalgeLogik logik;
    Boolean erSpilletVundet;


    //Nogle animationer
    Animation rotateAnimation;
    Animation scaleAnimation;
    Animation scaleAndRotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyt_spil);

        this.logik = new GalgeLogik();

        guess = findViewById(R.id.guessLetter);
        reset = findViewById(R.id.reset);
        nameOfUser = findViewById(R.id.userName);
        txwordToBeGuessed = findViewById(R.id.wordToGuess);
        userInput = findViewById(R.id.userInput);
        txLettersTried = findViewById(R.id.lettersUsed);
        hangMan = findViewById(R.id.gallowStart);

        guess.setOnClickListener(this);
        reset.setOnClickListener(this);
        userInput.setOnTouchListener(this);

        ordetSynligt = logik.getSynligtOrd();
        TextView tv1 = findViewById(R.id.wordToGuess);
        tv1.setText(ordetSynligt);

        heleOrdet = logik.getOrdet();

        String username = PreferenceManager.getDefaultSharedPreferences(this).getString("Brugernavn", "defaultStringIfNothingFound");
        TextView tv2 = findViewById(R.id.userName);
        tv2.setText(username +"'s galgelegspil");

        erSpilletVundet = logik.erSpilletVundet();

        //usedLetters = logik.getBrugteBogstaver();
        //TextView tv2 = findViewById(R.id.lettersUsed);
        //tv2.setText((CharSequence) usedLetters);


    }

    //public String letterChecker(){
        //checkInput = userInput.getText().toString();
        //if (checkInput.matches("[A-Za-z]{1}")) {
        //    return checkInput;
        //}
        //else {
          //  return null;
       // }


  //  }


    @Override
    public void onClick(View ButtonClick) {
        if (ButtonClick == reset){
            this.logik.startNytSpil();
        }
        if (ButtonClick == guess){
            this.logik.gætBogstav(userInput.getText().toString());
            ordetSynligt = logik.getSynligtOrd();
            TextView tv1 = findViewById(R.id.wordToGuess);
            tv1.setText(ordetSynligt);
            this.changeImage();

            if(erSpilletVundet == true){

                SharedPreferences preferencesbogstaver = PreferenceManager.getDefaultSharedPreferences(this);
                preferencesbogstaver.edit().putInt("Score", this.forkerteBogstaver).apply();

                SharedPreferences preferencesord = PreferenceManager.getDefaultSharedPreferences(this);
                preferencesord.edit().putString("Ordet", this.heleOrdet).apply();

                Intent i = new Intent(this, DuHarVundet.class);
                startActivity(i);

            }

            //TODO - INDSÆT OBERSERVER-PATTERN
        }


    }

    public void changeImage(){
        forkerteBogstaver = logik.getAntalForkerteBogstaver();
        switch (forkerteBogstaver){

            case 1: forkerteBogstaver = 1;
                    ImageView iv = findViewById(R.id.gallowStart);
                    iv.setImageResource(R.drawable.forkert1);
                    break;
            case 2: forkerteBogstaver = 2;
                    ImageView iv2 = findViewById(R.id.gallowStart);
                    iv2.setImageResource(R.drawable.forkert2);
                    break;
            case 3: forkerteBogstaver = 3;
                    ImageView iv3 = findViewById(R.id.gallowStart);
                    iv3.setImageResource(R.drawable.forkert3);
                    break;
            case 4: forkerteBogstaver = 4;
                    ImageView iv4 = findViewById(R.id.gallowStart);
                    iv4.setImageResource(R.drawable.forkert4);
                    break;
            case 5: forkerteBogstaver = 5;
                    ImageView iv5 = findViewById(R.id.gallowStart);
                    iv5.setImageResource(R.drawable.forkert5);
                    break;
            case 6: forkerteBogstaver = 6;
                    ImageView iv6 = findViewById(R.id.gallowStart);
                    iv6.setImageResource(R.drawable.forkert6);
                    Intent i = new Intent(this, DuHarTabt.class);
                    startActivity(i);
                    break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v == userInput){
            userInput.setText("");
        }
        return false;
    }
}