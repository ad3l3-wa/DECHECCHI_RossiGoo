package org.example;

public class Bici extends Veicolo{
    public int marce;
    public double tariffa;

    public Bici(int marce,double tariffa,int codice, int batteria, String stato){
        super(codice,batteria,stato);
        this.marce = marce;
        this.tariffa = tariffa;
    }

    public Bici(int marce, int tariffa, String occupato) {
        super();
    }

    @Override
    public int consumoBatteriaPerMinuto(int minutiUsati) {
        return 0;
    }

    @Override
    public int VelocitaMassima() {
        return 0;
    }

    @Override
    public double calcolaCosto(int minuti){
        return 0;
    }


}
