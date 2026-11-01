package org.example;

public class CodiceFiscaleNonValidoException extends RossiGoException{

    public CodiceFiscaleNonValidoException(String messaggio, Throwable causa){
        super(messaggio, causa);
    }

    public CodiceFiscaleNonValidoException(String haiLaBatteriaScarica) {
        super();
    }
}
