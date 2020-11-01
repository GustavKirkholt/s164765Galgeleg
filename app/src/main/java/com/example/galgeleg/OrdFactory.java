package com.example.galgeleg;

public class OrdFactory {

    public ord lavOrd (String nytOrd){
        ord gætOrd = null;

        if(nytOrd.equals("Nemt")){
            return new NemtOrd();

        } else if (nytOrd.equals("Svært")){
            return new SværtOrd();

        } else return null;
    }

}
