package org.example;

public abstract class Veicolo {
    public int codice;
    public int batteria;
    public String stato;
    private int livelloBatteria;

    public Veicolo(int codice, int batteria, String stato){
        this.codice=codice;
        this.batteria = batteria;
        this.stato= stato;
    }

    public Veicolo() {

    }

    public abstract double calcolaCosto(int minuti);
    public abstract int consumoBatteriaPerMinuto(int minutiUsati);

    public int getCodice() {
        return codice;
    }

    public int getLivelloBatteria() {
        return livelloBatteria;
    }


    public String getStato() {
        return stato;
    }


    public abstract int VelocitaMassima();
}
