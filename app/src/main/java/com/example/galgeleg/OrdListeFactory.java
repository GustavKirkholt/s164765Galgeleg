package com.example.galgeleg;

//Her styres hvilken ord type der vælges, ud fra brugerens valg.

public class OrdListeFactory {

    public ordListe lavOrd (String nytOrd) throws InterruptedException {

        if(nytOrd.equals("Nemt")){
            return new NemmeOrd();

        } else if (nytOrd.equals("Svært")){
            return new SværeOrd();

        } else if (nytOrd.equals("Hent fra DR")){
            return new OrdDR();
        } else return null;
    }
}
