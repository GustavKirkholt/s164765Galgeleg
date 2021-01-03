package com.example.galgeleg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import static com.example.galgeleg.Model.GalgeLogik.hentUrl;


public class OrdDR extends ordListe {

    ArrayList<String> ordListeDR = new ArrayList();
    Random randomGenerator;

    Thread t1 = new Thread(() -> {
        String data = null;
        try {
            data = hentUrl("https://dr.dk");
        } catch (IOException e) {
            e.printStackTrace();
        }
        data = data.substring(data.indexOf("<body")).replaceAll("<.+?>", " ").toLowerCase().replaceAll("&#198;", "æ").replaceAll("&#230;", "æ").replaceAll("&#216;", "ø").replaceAll("&#248;", "ø").replaceAll("&oslash;", "ø").replaceAll("&#229;", "å").replaceAll("[^a-zæøå]", " ").replaceAll(" [a-zæøå] ", " ").replaceAll(" [a-zæøå][a-zæøå] ", " ");
        System.out.println("data = " + data);
        System.out.println("data = " + Arrays.asList(data.split("\\s+")));
        ordListeDR.addAll(new HashSet(Arrays.asList(data.split(" "))));
    });

    public OrdDR() {

        t1.start();
    }
}
