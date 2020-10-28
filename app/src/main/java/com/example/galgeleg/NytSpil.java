package com.example.galgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class NytSpil extends AppCompatActivity {

    //Variabler
    TextView txwordToBeGuessed;
    String wordToBeGuessed; //Dette er hele ordet
    String wordDisplayed; //Dette er order med underscores ved de bogstaver man endnu ikke har gættet
    char[] wordDisplayedCharArray; //Et character array med ordet, det er nogengange nemmer at arbejde med
    ArrayList<String> listOfWords; // Alle mulige ord
    EditText userInput;
    TextView txLettersTried;
    String lettersTried;
    final String MESSAGE_WITH_LETTERS_TRIED = "Letters tried: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyt_spil);



    }
}