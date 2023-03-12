package hu.petrik.bankiszolgaltatasok;

public class HitelSzamla extends Szamla{

    private int hitelKeret;

    public HitelSzamla(Tulajdonos tulajdonos, int hitelkeret) {
        super(tulajdonos);
        this.hitelKeret = hitelkeret;
    }

    public int getHitelKeret() {
        return hitelKeret;
    }

    public boolean kivesz(int osszeg){ //10000
        if (getHitelKeret() + getAktualisEgyenleg() < osszeg){
            return false;
        } else {
            aktualisEgyenleg = getAktualisEgyenleg() - osszeg;
            return true;
        }
    }




}
