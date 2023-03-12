package hu.petrik.bankiszolgaltatasok;

public class Kartya extends BankiSzolgaltatas{
    private Szamla szamla;
    private String kartyaSzam;

    public Kartya(Tulajdonos tulajdonos, Szamla szamla, String kartyaSzam){
        this.szamla = szamla;
        this.kartyaSzam = kartyaSzam;
    }
    public String getKartyaSzam() {
        return kartyaSzam;
    }

    public boolean vasarlas(int osszeg){
        if(this.szamla.getAktualisEgyenleg() < osszeg){
            return false;
        }
        this.szamla.aktualisEgyenleg -= osszeg;
        return true;
    }
}
