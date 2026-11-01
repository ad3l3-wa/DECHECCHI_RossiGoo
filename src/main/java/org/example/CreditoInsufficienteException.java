package org.example;

public class CreditoInsufficienteException extends RossiGoException{
    public double credito;

    public CreditoInsufficienteException(double credito, String messaggio, Throwable causa){
        super(messaggio, causa);
        this.credito = credito;
    }

    public CreditoInsufficienteException(String nonHaiAbbatsanzaSoldi) {
    }

    public String CreditoTot(){
        return "il tuo credito è di:" + credito;
    }
}
