package org.example;

public class BatteriaScaricaException extends RossiGoException{
    public BatteriaScaricaException(int batteria,String messaggio, Throwable causa){
        super(messaggio, causa);
    }

    public BatteriaScaricaException(String haiLaBatteriaScarica) {
        super();
    }
}
