package com.example.galgeleg;

import java.util.ArrayList;
import java.util.Random;


public abstract class ordListe {

        ArrayList<String> ordListe = new ArrayList();
        Random randomGenerator;

        public String getOrdet() {

            randomGenerator = new Random();
            int index = randomGenerator.nextInt(ordListe.size());
            String ordet = ordListe.get(index);
            return (ordet);
        }
    }

