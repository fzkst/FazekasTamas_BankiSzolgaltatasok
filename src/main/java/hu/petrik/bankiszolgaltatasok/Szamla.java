package hu.petrik.bankiszolgaltatasok;

public abstract class Szamla extends BankiSzolgaltatas{
    protected int aktualisEgyenleg;

    public Szamla(Tulajdonos tulajdonos){

    }

    public int getAktualisEgyenleg() {
        return aktualisEgyenleg;
    }
    public void befizet(int osszeg){
        aktualisEgyenleg += osszeg;
    }
    public abstract boolean kivesz(int osszeg);

    public Kartya ujKartya(String kartyaszam){
        return new Kartya(this.getTulajdonos(), this, kartyaszam);
    }
}
