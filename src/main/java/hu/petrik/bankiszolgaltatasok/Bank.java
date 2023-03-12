package hu.petrik.bankiszolgaltatasok;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
    private List<Szamla> szamlaLista;

    public Bank(){
        this.szamlaLista = new ArrayList<Szamla>();
    }

    public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret){
        if (hitelKeret < 0){
            throw new IllegalArgumentException();
        }
        if(hitelKeret > 0){
            HitelSzamla hitelSzamla = new HitelSzamla(tulajdonos, hitelKeret);
            szamlaLista.add(hitelSzamla);
            return hitelSzamla;
        }
        MegtakaritasiSzamla megtakaritasiSzamla = new MegtakaritasiSzamla(tulajdonos);
        szamlaLista.add(megtakaritasiSzamla);
        return megtakaritasiSzamla;
    }

    public int getOsszEgyenleg(Tulajdonos tulajdonos){
        String tNev = tulajdonos.getNev();
        int osszegyenleg = 0;
        for (Szamla szamla: szamlaLista) {
            if (szamla.getTulajdonos() == tulajdonos){
                osszegyenleg += szamla.getAktualisEgyenleg();
            }
        }
        return osszegyenleg;
    }

    public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos){
        Szamla legnagyobbEgyenleguSzamla = szamlaLista.get(0);
        for (Szamla szamla: szamlaLista) {
            if (tulajdonos == szamla.getTulajdonos()){
                if (szamla.getAktualisEgyenleg() > legnagyobbEgyenleguSzamla.getAktualisEgyenleg()){
                    legnagyobbEgyenleguSzamla = szamla;
                }
            }
        }
        return legnagyobbEgyenleguSzamla;
    }

    public long getOsszHitelkeret(){
        int osszHitelkeret = 0;
        for (Szamla szamla: szamlaLista) {
            if (szamla instanceof HitelSzamla){
                osszHitelkeret += ((HitelSzamla) szamla).getHitelKeret();
            }
        }
        return osszHitelkeret;
    }

}
