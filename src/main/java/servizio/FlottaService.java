package servizio;

import it.kamaladafrica.codicefiscale.CodiceFiscale; // Libreria esterna per il CF
import org.example.*;

import java.util.ArrayList;
import java.util.List;

public class FlottaService {

    private List<Veicolo> veicoli;
    private List<Utente> utenti;
    private List<Noleggio> noleggiAttivi;

    public FlottaService(List<Veicolo> veicoli, List<Utente> utenti, List<Noleggio> noleggiAttivi) {
        this.veicoli = new ArrayList<>();
        this.utenti = new ArrayList<>();
        this.noleggiAttivi = new ArrayList<>();
    }

    public void registraVeicolo(Veicolo v){
        veicoli.add(v);
        System.out.println("veicolo registrato: " + v.getCodice());
    }

    public void registraUtente(Utente u) throws CodiceFiscaleNonValidoException{
        try{
            CodiceFiscale.of(u.getCodiceFiscale());
        }catch(Exception e){
            throw new CodiceFiscaleNonValidoException("Il codice fiscale inserito non è valido: " + u.getCodiceFiscale());
        }
        utenti.add(u);
    }

    public Utente cercaId(int idcercato){
        for(Utente u : utenti) {
            if(u.getId() == idcercato){
                return u;
            }
        }
        return null;
    }


    public Veicolo cercaVeicoloPerCodice(int codiceCercato) throws VeicoloNonDisponibileException {

        for (Veicolo v : veicoli) {
            if (v.getCodice() == codiceCercato) {
                return v;
            }
        }
        throw new VeicoloNonDisponibileException("Veicolo con codice " + codiceCercato + " non trovato.");
    }

    public String SbloccaVeicolo(int codice, int minutiUsati, Utente u, int id) throws VeicoloNonDisponibileException{
        Veicolo v = cercaVeicoloPerCodice(codice);
        if(!v.getStato().equals("disponibile")){
        } else{
            throw new VeicoloNonDisponibileException("veicolo non disponibile");
        }

        if(v.getLivelloBatteria() < 15){
            throw new BatteriaScaricaException("hai la batteria scarica");
        }

        double creditominimo = 1.0;
        if(u.getCredito() < creditominimo){
            throw new CreditoInsufficienteException("non hai abbatsanza soldi");
        }

        Utente c = cercaId(id);

        if(c.getId() >0){
        } else{
            throw new UtenteNonTrovato("non abbiamo trovato l'utente");
        }

        try{
            CodiceFiscale.of(u.getCodiceFiscale());
        }catch(Exception e){
            throw new CodiceFiscaleNonValidoException("codice fiscale non trovato");
        }


        return "veicolo sbloccato";
    }

    public void terminaNoleggio(int codiceV, int minutiUsati){
        Veicolo v = cercaVeicoloPerCodice(codiceV);
        double costotot = 1+(v.calcolaCosto(minutiUsati));
        int batteriaAttuale =100-(v.consumoBatteriaPerMinuto(minutiUsati));
    }

    public void mettiInRicarica(String codice){
        System.out.println("metti in carica il veicolo");
    }
}
