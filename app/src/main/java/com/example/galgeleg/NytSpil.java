package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NytSpil extends AppCompatActivity {

    //Variabler
    TextView txwordToBeGuessed;
    String wordToBeGuessed; //Dette er hele ordet
    String wordDisplayed; //Dette er order med underscores ved de bogstaver man endnu ikke har gættet
    char[] wordDisplayedCharArray; //Et character array med ordet, det er nogengange nemmer at arbejde med
    ArrayList<String> muligeOrd = new ArrayList();  //Alle mulige ord
    EditText userInput;
    TextView nameOfUser;
    TextView txLettersTried;
    String lettersTried;
    ImageView hangMan; //Galjen
    final String MESSAGE_WITH_LETTERS_TRIED = "Letters tried: ";

    //Nogle animationer
     Animation rotateAnimation;
     Animation scaleAnimation;
     Animation scaleAndRotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyt_spil);

        NytSpil nytspil = new NytSpil();
        GalgeLogik logik = new GalgeLogik();

        nameOfUser = findViewById(R.id.userName);
        txwordToBeGuessed = findViewById(R.id.wordToGuess);
        userInput = findViewById(R.id.userInput);
        txLettersTried = findViewById(R.id.lettersUsed);
        hangMan = findViewById(R.id.gallowStart);






    }
}