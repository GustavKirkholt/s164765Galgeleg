package com.example.galgeleg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import static com.example.galgeleg.Model.GalgeLogik.hentUrl;

//Her henter jeg ORD fra dr.dk og tilføjer dem som mulige ord til ordlisten.


public class OrdDR extends ordListe {

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
        ordListe.addAll(new HashSet(Arrays.asList(data.split(" "))));
    });

    public OrdDR() throws InterruptedException {

        t1.start();
        Thread.sleep(3000);
    }
}
