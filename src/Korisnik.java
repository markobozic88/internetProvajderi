import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Korisnik implements IzradaListinga {

    private String ime;
    private String prezime;
    private String adresa;
    private String brojUgovora;
    private TarifniPaket tarifniPaket;
    private InternetProvajder internetProvajder;
    private ArrayList<TarifniDodatak> tarifniDodaci;
    private List<ListingUnos> listingUnosi;

    public Korisnik(InternetProvajder internetProvajder, String ime, String prezime, String adresa, String brojUgovora,
                    TarifniPaket tarifniPaket){
        this.internetProvajder = internetProvajder;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.brojUgovora = brojUgovora;
        this.tarifniPaket = tarifniPaket;
        this.tarifniDodaci = new ArrayList<>();
        this.listingUnosi = new ArrayList<>();
        internetProvajder.dodajKorisnika(this);
    }

    public abstract boolean surfuj(String url, int megabajta);

    public abstract void dodajTarifniDodatak(TarifniDodatak tarifniDodatak);

    public void dodajListingUnos(ListingUnos listingUnos) {

        boolean duplikat = false;

        if (this.listingUnosi.isEmpty()){
            this.listingUnosi.add(listingUnos);
            return;
        }

        for (int i = 0; i < this.listingUnosi.size(); i++){
            if (this.listingUnosi.get(i).getUrl().equals(listingUnos.getUrl())){
                this.listingUnosi.get(i).dodajMegabajte(listingUnos.getMegabajti());
                duplikat = true;
                break;
            }
        }

        if (!duplikat){
            this.listingUnosi.add(listingUnos);
        }
    }

    @Override
    public String napraviListing() {

        Collections.sort(this.listingUnosi);

        StringBuilder sb = new StringBuilder("\nLISTING UNOS:\n");

        for (ListingUnos lu : this.listingUnosi){
            sb.append(lu.toString()).append("\n");
        }

        return sb.toString();
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public InternetProvajder getInternetProvajder() {
        return internetProvajder;
    }

    public TarifniPaket getTarifniPaket() {
        return tarifniPaket;
    }

    public ArrayList<TarifniDodatak> getTarifniDodaci() {
        return tarifniDodaci;
    }

    public List<ListingUnos> getListingUnosi() {
        return listingUnosi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Korisnik korisnik = (Korisnik) o;
        return Objects.equals(getIme(), korisnik.getIme()) &&
                Objects.equals(getPrezime(), korisnik.getPrezime()) &&
                Objects.equals(getAdresa(), korisnik.getAdresa()) &&
                Objects.equals(getBrojUgovora(), korisnik.getBrojUgovora()) &&
                Objects.equals(getTarifniPaket(), korisnik.getTarifniPaket()) &&
                Objects.equals(getInternetProvajder(), korisnik.getInternetProvajder()) &&
                Objects.equals(getTarifniDodaci(), korisnik.getTarifniDodaci()) &&
                Objects.equals(getListingUnosi(), korisnik.getListingUnosi());
    }

    public String getBrojUgovora() {
        return brojUgovora;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", adresa='" + adresa + '\'' +
                ", brojUgovora='" + brojUgovora + '\'' +
                ", tarifniPaket=" + tarifniPaket +
                ", internetProvajder=" + internetProvajder +
                ", tarifniDodaci=" + tarifniDodaci +
                ", listingUnosi=" + listingUnosi +
                '}';
    }


}
