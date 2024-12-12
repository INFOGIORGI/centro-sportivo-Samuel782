import java.util.HashMap;

public class CentroSportivo {

    private HashMap<String, Socio> soci;
    private HashMap<String, Istruttore> istruttori;

    // Chiave codice istruttore + data + ora
    private HashMap<String, Attivita> attivita;

    // --- Soci ---

    public boolean aggiungiSocio(String nome, String cognome, String codice) {
        if (soci.containsKey(codice))
            return false;

        soci.put(codice, new Socio(nome, cognome, codice));
        return true;
    }

    public boolean rimuoviSocio(String codice) {
        if (soci.containsKey(codice) || soci.get(codice).istrNotEmpty())
            return false;
        soci.remove(codice);
        return true;
    }

    public Socio getSocio(String codice) {
        return soci.get(codice);
    }

    // --- Istruttori ---

    public boolean aggiungiIStruttore(String nome, String Cognome, String Codice) {
        if (istruttori.containsKey(Codice))
            return false;

        istruttori.put(Codice, new Istruttore(nome, Cognome, Codice));
        return true;
    }

    public boolean rimuoviIstruttore(String codice) {
        if (istruttori.containsKey(codice) || istruttori.get(codice).sociNotEmpty())
            return false;
        istruttori.remove(codice);
        return true;
    }

    public Istruttore getIstruttore(String codice) {
        return istruttori.get(codice);
    }

    // --- Assegnazioni ---

    public boolean AssegnaIstruttore(String codiceSocio, String codiceIstruttore) {
        Socio s = soci.get(codiceSocio);
        Istruttore i = istruttori.get(codiceIstruttore);

        if (s == null || i == null || s.AssegnaIstruttore(i) || i.AssegnaSocio(s))
            return false;

        return true;
    }

    public boolean rimuoviAssegnazione(String codiceSocio, String codiceIstruttore) {
        Socio s = soci.get(codiceSocio);
        Istruttore i = istruttori.get(codiceIstruttore);

        if (s == null || i == null || s.rimuoviIstruttore(i) || i.rimuoviSocio(s))
            return false;

        return true;
    }

    public String getSoci(String codIstruttore) {
        return istruttori.get(codIstruttore).getSoci();
    }

    // --- Attività ---
    public boolean aggiungiAttivita(String codIst, String codSoc, String data, String oraInizio, String oraFine) {

        if (!soci.containsKey(codSoc) || !istruttori.containsKey(codIst))
            return false;

        Istruttore i = istruttori.get(codIst);
        Socio s = soci.get(codSoc);

        if (!i.isSocioIst(codIst) && !s.isIstSocio(codSoc))
            return false;

        String codiceAttività = codIst+data+oraInizio;

        if(attivita.containsKey(codiceAttività)) return false;

        for(Attivita a : attivita.values()){
            if(a.getData().equals(data)){
                if(a.getSocioAtt().getCodiceSocio().equals(codSoc) && a.getIstruttAtt().getCodiceIstruttore().equals(codIst)){
                    if(orariSovrapposti(a.getOraInizio(), a.getOraFine(), oraInizio, oraFine)) return false;
                }
            }
        }


        attivita.put(codiceAttività, new Attivita(s, i, data, oraInizio, oraFine));
        
        return true;
    }

    private boolean orariSovrapposti(String oraInizio1, String oraFine1, String oraInizio2, String oraFine2) {
        return (oraInizio1.compareTo(oraFine2) < 0 && oraFine1.compareTo(oraInizio2) > 0);
    }
}
