package org.example;

import com.github.lalyos.jfiglet.FigletFont;
import servizio.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            String asciiTitle = FigletFont.convertOneLine("RossiGo System");
            System.out.println(asciiTitle);
        } catch (Exception e) {
            System.out.println("=== ROSSIGO SYSTEM ===");
        }
        System.out.println("Benvenuto nel sistema di gestione della flotta!\n");

        FlottaService flotta = new FlottaService(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        Veicolo m1 = new Monopattino(1, 80, "disponibile");
        Veicolo m2 = new Monopattino(2, 10, "disponibile");
        Veicolo b1 = new Bici(3, 90, "occupato");
        Veicolo b2 = new Bici(4, 100, "disponibile");

        flotta.registraVeicolo(m1);
        flotta.registraVeicolo(m2);
        flotta.registraVeicolo(b1);
        flotta.registraVeicolo(b2);

        char[] emailDefault = {'t', 'e', 's', 't', '@', 'm', 'a', 'i', 'l', '.', 'i', 't'};
        Utente utenteValido = new Utente(1, "Mario", "RSSMRA80A01H501W", 15.0, emailDefault);

        try {
            flotta.registraUtente(utenteValido);
        } catch (Exception e) {
            System.out.println("Errore nella registrazione utente base.");
        }

        System.out.println("inizio");

        System.out.println("utente prova a sbloccare un monopattino con 0,50 € di credito:");
        try {
            Utente utentePovero = new Utente(2, "Luigi", "RSSMRA80A01H501W", 0.50, emailDefault);
            flotta.SbloccaVeicolo(1, 10, utentePovero, 2);
        } catch (Exception e) {
            System.out.println("Attenzione: " + e.getMessage());
        }
        System.out.println();

        System.out.println("registrazione di un utente con codice fiscale errato:");
        try {
            Utente utenteCFErrato = new Utente(3, "Anna", "CF_FALSO_123", 20.0, emailDefault);
            flotta.registraUtente(utenteCFErrato);
        } catch (Exception e) {
            System.out.println("attenzione: " + e.getMessage());
        }
        System.out.println();

        System.out.println("[Tentativo di sbloccare una bici già occupata:");
        try {
            flotta.SbloccaVeicolo(3, 15, utenteValido, 1);
        } catch (Exception e) {
            System.out.println("attenzione: " + e.getMessage());
        }
        System.out.println();

        System.out.println("tentativo di sbloccare un monopattino con batteria al 10%:");
        try {
            flotta.SbloccaVeicolo(2, 10, utenteValido, 1);
        } catch (Exception e) {
            System.out.println("attenzione: " + e.getMessage());
        }
        System.out.println();

        System.out.println("Sblocco regolare del monopattino id=1 con utente valido:");
        try {
            String esito = flotta.SbloccaVeicolo(1, 20, utenteValido, 1);
            System.out.println("Successo: " + esito);
        } catch (Exception e) {
            System.out.println(" Errore inaspettato: " + e.getMessage());
        }
        System.out.println();

        System.out.println("Un utente termina la corsa del veicolo id=4 (Bici):");
        try {
            flotta.terminaNoleggio(4, 30);
            System.out.println("Successo: Noleggio terminato correttamente e veicolo liberato.");
        } catch (Exception e) {
            System.out.println("Errore inaspettato: " + e.getMessage());
        }

        System.out.println("\nfine");
    }
}
