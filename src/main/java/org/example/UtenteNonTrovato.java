package org.example;

public class UtenteNonTrovato extends RossiGoException{
    public UtenteNonTrovato(int batteria,String messaggio, Throwable causa){
        super(messaggio, causa);
    }

    public UtenteNonTrovato(String haiLaBatteriaScarica) {
        super();
    }
}
