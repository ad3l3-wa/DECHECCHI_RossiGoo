package org.example;

public class RossiGoException extends RuntimeException {
    public RossiGoException(String message) {
        super(message);
    }
    public RossiGoException(String messaggio, Throwable causa) {
        super(messaggio, causa);
    }

    public RossiGoException() {

    }
}
