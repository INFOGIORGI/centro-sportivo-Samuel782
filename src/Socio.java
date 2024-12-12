import java.util.HashMap;

public class Socio {

    private String nome;
    private String cognome;
    private String codiceSocio;

    private HashMap<String, Istruttore> istruttoriAss;

    public Socio(String nome, String cognome, String codiceSocio) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceSocio = codiceSocio;
    }

    public boolean istrNotEmpty(){
        return istruttoriAss.size() < 1;
    }

    public String getCodiceSocio() {
        return codiceSocio;
    }

    public boolean AssegnaIstruttore(Istruttore i){
        if(istruttoriAss.containsValue(i)) return false;
        istruttoriAss.put(i.getCodiceIstruttore(), i);
        return true;
    }

    public boolean rimuoviIstruttore(Istruttore i){
        if(!istruttoriAss.containsValue(i)) return false;
        istruttoriAss.remove(i.getCodiceIstruttore());
        return true;
    }

    public boolean isIstSocio(String codIstr){
        return istruttoriAss.containsKey(codIstr);
    }


    @Override
    public String toString() {
        return nome + " " + cognome + " " + codiceSocio;
    }
}