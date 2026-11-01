package org.example;

public class Monopattino extends Veicolo{
    public int velocita;
    public double tariffaM;

    public Monopattino(int codice, int batteria, String stato) {
        super(codice, batteria, stato);
    }

    @Override
    public double calcolaCosto(int minuti) {
        tariffaM = minuti * 0.25;
        return 0;
    }

    @Override
    public int consumoBatteriaPerMinuto(int minutiUsati) {
        return 0;
    }

    @Override
    public int VelocitaMassima(){
        return velocita;
    }
}
