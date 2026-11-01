package org.example;

public class Utente {
    public int id;
    public String nome;
    public String codiceF;
    public char[] email;
    public double credito;


    public Utente(int id, String nome, String codiceF, double credito, char[] email){
        this.id = id;
        this.nome = nome;
        this.codiceF = codiceF;
        this.email = email;
        this.credito = credito;
    }


    public int getId() {
        return id;
    }

    public String getCodiceFiscale() {
        return codiceF;
    }

    public double getCredito() {
        return credito;
    }



}
