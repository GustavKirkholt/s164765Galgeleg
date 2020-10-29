package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    Button guess;
    String ordet;
    ArrayList<String> usedLetters;
    GalgeLogik logik;
    String checkInput;

    //Nogle animationer
    Animation rotateAnimation;
    Animation scaleAnimation;
    Animation scaleAndRotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyt_spil);

        this.logik = new GalgeLogik();
        this.logik.startNytSpil();

        guess = findViewById(R.id.guessLetter);
        nameOfUser = findViewById(R.id.userName);
        txwordToBeGuessed = findViewById(R.id.wordToGuess);
        userInput = findViewById(R.id.userInput);
        txLettersTried = findViewById(R.id.lettersUsed);
        hangMan = findViewById(R.id.gallowStart);

        guess.setOnClickListener(this);
        userInput.setOnTouchListener(this);

        ordet = logik.getSynligtOrd();
        TextView tv1 = findViewById(R.id.wordToGuess);
        tv1.setText(ordet);

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
        if (ButtonClick == guess){
            this.logik.gætBogstav(userInput.getText().toString());

        }

    }

    public void changeImage(){
        //SwitchCase
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v == userInput){
            userInput.setText("");
        }
        return false;
    }
}