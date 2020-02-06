import java.io.*;
import java.util.ArrayList;

public class InternetProvajder {

    private String imeProvajdera;
    private ArrayList<Korisnik> listaKorisnika;

    public InternetProvajder(String imeProvajdera){
        this.imeProvajdera = imeProvajdera;
        this.listaKorisnika = new ArrayList<>();
    }

    public void generisiRacune(){

        for (Korisnik k : this.listaKorisnika){
            if (k instanceof PostpaidKorisnik){
                System.out.println(((PostpaidKorisnik) k).generisiRacun());
            }
        }

    }

    public void zabeleziSaobracaj(Korisnik korisnik, String url, int mb){

        StringBuilder sb = new StringBuilder();

        sb.append(korisnik.getBrojUgovora())
                .append(url)
                .append(mb);

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("log.txt", true)));
            out.println(sb.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void prikazPrepaidKorisnika(){
        for (Korisnik k : listaKorisnika){
            if (k instanceof PrepaidKorisnik){
                System.out.println(k);
            }
        }
    }

    public void prikazPostpaidKorisnika(){
        for (Korisnik k : listaKorisnika){
            if (k instanceof PostpaidKorisnik){
                System.out.println(k);
            }
        }
    }

    public void dodajKorisnika(Korisnik k){
        this.listaKorisnika.add(k);
    }

    public String getImeProvajdera() {
        return imeProvajdera;
    }

    @Override
    public String toString() {
        return "InternetProvajder{" +
                "imeProvajdera='" + getImeProvajdera() + '\'' +
                '}';
    }


}
