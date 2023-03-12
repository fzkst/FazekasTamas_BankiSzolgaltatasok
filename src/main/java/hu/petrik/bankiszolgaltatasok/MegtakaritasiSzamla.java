package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla{
    private static double kamat = 1.1;

    public static double alapKamat;

    public MegtakaritasiSzamla(Tulajdonos tulajdonos){
        super(tulajdonos);
        this.alapKamat = this.kamat;
    }

    public double getKamat() {
        return kamat;
    }

    public void setKamat(double kamat) {
        this.kamat = kamat;
    }
    public boolean kivesz(int osszeg){
        if(this.getAktualisEgyenleg() < osszeg){
            return false;
        }
        this.aktualisEgyenleg -= osszeg;
        return true;
    }
    public void kamatJovairas(){
        this.aktualisEgyenleg += (int) ((this.getAktualisEgyenleg() * this.alapKamat) - this.getAktualisEgyenleg());
    }

}
