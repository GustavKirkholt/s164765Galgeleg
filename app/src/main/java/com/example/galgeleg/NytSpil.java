package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NytSpil extends AppCompatActivity implements View.OnClickListener {

    //Variabler
    TextView txwordToBeGuessed;
    EditText userInput;
    TextView nameOfUser;
    TextView txLettersTried;
    ImageView hangMan; //Galjen
    Button guess;
    String ordet;
    ArrayList<String> usedLetters;

    //Nogle animationer
     Animation rotateAnimation;
     Animation scaleAnimation;
     Animation scaleAndRotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyt_spil);

        GalgeLogik logik = new GalgeLogik();
        logik.startNytSpil();

        guess = findViewById(R.id.guessLetter);
        nameOfUser = findViewById(R.id.userName);
        txwordToBeGuessed = findViewById(R.id.wordToGuess);
        userInput = findViewById(R.id.userInput);
        txLettersTried = findViewById(R.id.lettersUsed);
        hangMan = findViewById(R.id.gallowStart);

        guess.setOnClickListener(this);

        ordet = logik.getSynligtOrd();
        TextView tv1 = findViewById(R.id.wordToGuess);
        tv1.setText(ordet);

        //usedLetters = logik.getBrugteBogstaver();
        //TextView tv2 = findViewById(R.id.lettersUsed);
        //tv2.setText((CharSequence) usedLetters);


    }

    public void letterChecker(){
        //Indsæt metode til at tjekke om bogstavet er korrekt indtastet
    }

    @Override
    public void onClick(View ButtonClick) {
        if (ButtonClick == guess){

        }

    }

    public void changeImage(){
        //SwitchCase
    }
}