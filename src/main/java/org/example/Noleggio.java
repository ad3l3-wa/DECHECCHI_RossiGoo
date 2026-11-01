package org.example;

public class Noleggio {
    public Utente utente;
    public Veicolo veicolo;
    public double inizio;
    public double fine;

    public Noleggio(Utente utente, Veicolo veicolo, double inizio, double fine){
        this.utente = utente;
        this.veicolo=veicolo;
        this.inizio = inizio;
        this.fine = fine;
    }

}
