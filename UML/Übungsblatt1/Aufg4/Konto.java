
public class Konto {
    private String bezeichnung;
    private Kunde[] zeichnungsberechtigter; //oder ArrayList

    public Konto(Kunde[] zeichnungsberechtigter) {
        this.zeichnungsberechtigter = zeichnungsberechtigter;
    }

    public GeldBetrag saldo() {
        return null;
    }

    public void einzahlen(GeldBetrag eingezahlterBetrag) {

    }
}
