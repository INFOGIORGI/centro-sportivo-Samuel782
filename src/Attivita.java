import java.sql.Date;

public class Attivita {
    private Socio socioAtt;
    private Istruttore istruttAtt;

    private String data;
    private String oraInizio;
    private String oraFine;


    public Attivita(Socio socioAtt, Istruttore istruttAtt, String data, String oraInizio, String oraFine) {
        this.socioAtt = socioAtt;
        this.istruttAtt = istruttAtt;
        this.data = data;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
    }


    public Socio getSocioAtt() {
        return socioAtt;
    }


    public Istruttore getIstruttAtt() {
        return istruttAtt;
    }


    public String getData() {
        return data;
    }


    public String getOraInizio() {
        return oraInizio;
    }


    public String getOraFine() {
        return oraFine;
    }

    

    
}
