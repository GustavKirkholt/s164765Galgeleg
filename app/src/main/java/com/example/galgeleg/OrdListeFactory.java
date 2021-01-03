package com.example.galgeleg;

public class OrdListeFactory {

    public ordListe lavOrd (String nytOrd) {

        if(nytOrd.equals("Nemt")){
            return new NemmeOrd();

        } else if (nytOrd.equals("Svært")){
            return new SværeOrd();

        } else if (nytOrd.equals("Hent fra DR")){
            return new OrdDR();
        } else return null;
    }
}
