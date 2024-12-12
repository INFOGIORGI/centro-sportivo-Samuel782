import java.util.HashMap;

public class Istruttore {
    private String nome;
    private String cognome;
    private String codiceIstruttore;

    private HashMap<String, Socio> sociAss;

    public Istruttore(String nome, String cognome, String codiceIstruttore) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceIstruttore = codiceIstruttore;
    }

    public String getCodiceIstruttore() {
        return codiceIstruttore;
    }
    
    public boolean sociNotEmpty(){
        return sociAss.size() < 1;
    }

    public boolean AssegnaSocio(Socio s){
        if(sociAss.containsValue(s)) return false;
        sociAss.put(s.getCodiceSocio(), s);
        return true;
    }

    public boolean rimuoviSocio(Socio s){
        if(!sociAss.containsValue(s)) return false;
        sociAss.remove(s.getCodiceSocio());
        return true;
    }

    public String getSoci(){
        String retValue = "";
        for (Socio s : sociAss.values()) {
            retValue += s +"\n";
        }
        return retValue;
    }

    
    public boolean isSocioIst(String codSocio){
        return sociAss.containsKey(codSocio);
    }


}