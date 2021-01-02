package com.example.galgeleg;

import java.io.IOException;

public class OrdListeFactory {

    public ordListe lavOrd (String nytOrd) throws IOException {

        if(nytOrd.equals("Nemt")){
            return new NemmeOrd();

        } else if (nytOrd.equals("Svært")){
            return new SværeOrd();

        } else if (nytOrd.equals("DR")) {
            return new OrdDR();
        }
        return null;
    }
}
