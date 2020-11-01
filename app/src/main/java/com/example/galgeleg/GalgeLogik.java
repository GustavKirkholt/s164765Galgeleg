package com.example.galgeleg;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class GalgeLogik {
    ArrayList<String> muligeOrd = new ArrayList();
    private String ordet;
    private ArrayList<String> brugteBogstaver = new ArrayList();
    private String synligtOrd;
    private int antalForkerteBogstaver;
    private boolean sidsteBogstavVarKorrekt;
    private boolean spilletErVundet;
    private boolean spilletErTabt;
    public String valgtSværhed;

    public GalgeLogik() {
        OrdFactory ordFactory = new OrdFactory();
        ord sværtOrd = ordFactory.lavOrd("Svært");
        ord nemtOrd = ordFactory.lavOrd("Nemt");
        this.muligeOrd.add(nemtOrd);
        this.muligeOrd.add(sværtOrd);
        this.muligeOrd.add("");
        this.muligeOrd.add("bil");
        this.muligeOrd.add("computer");
        this.muligeOrd.add("programmering");
        this.muligeOrd.add("motorvej");
        this.muligeOrd.add("busrute");
        this.muligeOrd.add("gangsti");
        this.muligeOrd.add("skovsnegl");
        this.muligeOrd.add("solsort");
        this.muligeOrd.add("tyve");

        this.startNytSpil();
    }

    public static void valgtSværhed(String nemt) {
    }

    public ArrayList<String> getBrugteBogstaver() {
        return this.brugteBogstaver;
    }

    public String getSynligtOrd() {
        return this.synligtOrd;
    }

    public String getOrdet() {
        return this.ordet;
    }

    public int getAntalForkerteBogstaver() {
        return this.antalForkerteBogstaver;
    }

    public boolean erSidsteBogstavKorrekt() {
        return this.sidsteBogstavVarKorrekt;
    }

    public boolean erSpilletVundet() {
        return this.spilletErVundet;
    }

    public boolean erSpilletTabt() {
        return this.spilletErTabt;
    }

    public boolean erSpilletSlut() {
        return this.spilletErTabt || this.spilletErVundet;
    }

    public void startNytSpil() {
        this.brugteBogstaver.clear();
        this.antalForkerteBogstaver = 0;
        this.spilletErVundet = false;
        this.spilletErTabt = false;
        if (this.muligeOrd.isEmpty()) {
            throw new IllegalStateException("Listen over mulige ord er tom!");
        } else {
            this.ordet = (String)this.muligeOrd.get((new Random()).nextInt(this.muligeOrd.size()));
            System.out.println("Nyt spil - det skjulte ord er: " + this.ordet);
            this.opdaterSynligtOrd();
        }
    }

    private void opdaterSynligtOrd() {
        this.synligtOrd = "";
        this.spilletErVundet = true;

        for(int n = 0; n < this.ordet.length(); ++n) {
            String bogstav = this.ordet.substring(n, n + 1);
            if (this.brugteBogstaver.contains(bogstav)) {
                this.synligtOrd = this.synligtOrd + bogstav;
            } else {
                this.synligtOrd = this.synligtOrd + " _ ";
                this.spilletErVundet = false;
            }
        }

    }
    
    public void gætBogstav(String bogstav) {
        if (bogstav.length() == 1) {
            System.out.println("Der gættes på bogstavet: " + bogstav);
            if (!this.brugteBogstaver.contains(bogstav)) {
                if (!this.spilletErVundet && !this.spilletErTabt) {
                    this.brugteBogstaver.add(bogstav);
                    if (this.ordet.contains(bogstav)) {
                        this.sidsteBogstavVarKorrekt = true;
                        System.out.println("Bogstavet var korrekt: " + bogstav);
                    } else {
                        this.sidsteBogstavVarKorrekt = false;
                        System.out.println("Bogstavet var IKKE korrekt: " + bogstav);
                        ++this.antalForkerteBogstaver;
                        if (this.antalForkerteBogstaver > 6) {
                            this.spilletErTabt = true;
                        }
                    }

                    this.opdaterSynligtOrd();
                }
            }
        }
    }

    public void logStatus() {
        System.out.println("---------- ");
        System.out.println("- ordet (skult) = " + this.ordet);
        System.out.println("- synligtOrd = " + this.synligtOrd);
        System.out.println("- forkerteBogstaver = " + this.antalForkerteBogstaver);
        System.out.println("- brugeBogstaver = " + this.brugteBogstaver);
        if (this.spilletErTabt) {
            System.out.println("- SPILLET ER TABT");
        }

        if (this.spilletErVundet) {
            System.out.println("- SPILLET ER VUNDET");
        }

        System.out.println("---------- ");
    }

    public static String hentUrl(String url) throws IOException {
        System.out.println("Henter data fra " + url);
        BufferedReader br = new BufferedReader(new InputStreamReader((new URL(url)).openStream()));
        StringBuilder sb = new StringBuilder();

        for(String linje = br.readLine(); linje != null; linje = br.readLine()) {
            sb.append(linje + "\n");
        }

        return sb.toString();
    }

    public void hentOrdFraDr() throws Exception {
        String data = hentUrl("https://dr.dk");
        data = data.substring(data.indexOf("<body")).replaceAll("<.+?>", " ").toLowerCase().replaceAll("&#198;", "æ").replaceAll("&#230;", "æ").replaceAll("&#216;", "ø").replaceAll("&#248;", "ø").replaceAll("&oslash;", "ø").replaceAll("&#229;", "å").replaceAll("[^a-zæøå]", " ").replaceAll(" [a-zæøå] ", " ").replaceAll(" [a-zæøå][a-zæøå] ", " ");
        System.out.println("data = " + data);
        System.out.println("data = " + Arrays.asList(data.split("\\s+")));
        this.muligeOrd.clear();
        this.muligeOrd.addAll(new HashSet(Arrays.asList(data.split(" "))));
        System.out.println("muligeOrd = " + this.muligeOrd);
        this.startNytSpil();
    }

    public void hentOrdFraRegneark(String sværhedsgrader) throws Exception {
        String id = "1RnwU9KATJB94Rhr7nurvjxfg09wAHMZPYB3uySBPO6M";
        System.out.println("Henter data som kommasepareret CSV fra regnearket https://docs.google.com/spreadsheets/d/" + id + "/edit?usp=sharing");
        String data = hentUrl("https://docs.google.com/spreadsheets/d/" + id + "/export?format=csv&id=" + id);
        int linjeNr = 0;
        this.muligeOrd.clear();
        String[] var5 = data.split("\n");
        int var6 = var5.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            String linje = var5[var7];
            if (linjeNr < 20) {
                System.out.println("Læst linje = " + linje);
            }

            if (linjeNr++ >= 1) {
                String[] felter = linje.split(",", -1);
                String sværhedsgrad = felter[0].trim();
                String ordet = felter[1].trim().toLowerCase();
                if (!sværhedsgrad.isEmpty() && !ordet.isEmpty() && sværhedsgrader.contains(sværhedsgrad)) {
                    System.out.println("Tilføjer " + ordet + ", der har sværhedsgrad " + sværhedsgrad);
                    this.muligeOrd.add(ordet);
                }
            }
        }

        System.out.println("muligeOrd = " + this.muligeOrd);
        this.startNytSpil();
    }

    public static void main(String[] args) throws Exception {
        (new GalgeLogik()).hentOrdFraRegneark("2");
    }
}

