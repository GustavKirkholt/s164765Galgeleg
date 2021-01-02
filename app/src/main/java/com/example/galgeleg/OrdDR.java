package com.example.galgeleg;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

import static com.example.galgeleg.Model.GalgeLogik.hentUrl;

public class OrdDR extends ordListe {

    public OrdDR () throws IOException {
        String data = hentUrl("https://dr.dk");
        data = data.substring(data.indexOf("<body")).replaceAll("<.+?>", " ").toLowerCase().replaceAll("&#198;", "æ").replaceAll("&#230;", "æ").replaceAll("&#216;", "ø").replaceAll("&#248;", "ø").replaceAll("&oslash;", "ø").replaceAll("&#229;", "å").replaceAll("[^a-zæøå]", " ").replaceAll(" [a-zæøå] ", " ").replaceAll(" [a-zæøå][a-zæøå] ", " ");
        System.out.println("data = " + data);
        System.out.println("data = " + Arrays.asList(data.split("\\s+")));
        this.ordListe.addAll(new HashSet(Arrays.asList(data.split(" "))));

    }
}
