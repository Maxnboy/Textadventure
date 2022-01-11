package com.company.NPC;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class Voiceline {

    private final String line1;
    private final String line2;
    private final String line3;
    private int auswahl;


    public Voiceline (String line1, String line2, String line3, int auswahl) {


        this.auswahl = auswahl;
        this.line1 = "\"" + line1 + "\"";
        this.line2 = "\"" + line2 + "\"";
        this.line3 = "\"" + line3 + "\"";

    }

    public Voiceline (String line1, String line2, String line3) {


        this.auswahl = 1;
        this.line1 = "\"" + line1 + "\"";
        this.line2 = "\"" + line2 + "\"";
        this.line3 = "\"" + line3 + "\"";

    }


    public String talking(){

        if(auswahl==1) {

            auswahl++;
            return line1;

        }else if(auswahl==2){

            auswahl++;
            return line2;

        }else if(auswahl==3){

            return line3;

        }

        return null;

    }



}
