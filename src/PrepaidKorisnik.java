public class PrepaidKorisnik extends Korisnik {

    private double kredit;

    public PrepaidKorisnik(InternetProvajder internetProvajder, String ime, String prezime, String adresa, String brojUgovora,
                           TarifniPaket tarifniPaket){
        super(internetProvajder, ime, prezime, adresa, brojUgovora, tarifniPaket);
        this.kredit = 500;
    }

    public void dopuniKredit(double iznos){
        this.kredit += iznos;
    }

    @Override
    public boolean surfuj(String url, int megabajta) {

        boolean izlaz = false;

        if (super.getTarifniDodaci().isEmpty()){
            double potroseniKredit = megabajta * super.getTarifniPaket().getCenaPoMegabajtu();
            if (potroseniKredit < this.kredit){
                this.kredit -= potroseniKredit;
                super.getInternetProvajder().zabeleziSaobracaj(this, url, megabajta);
                this.dodajListingUnos(new ListingUnos(url, megabajta));
            } else {
                System.out.println("nema dovoljno kredita");
            }
            izlaz = true;
        }

        for (TarifniDodatak td : getTarifniDodaci()){
            if (url.equals(td.getTipPodataka().name())){
                super.getInternetProvajder().zabeleziSaobracaj(this, url, megabajta);
                this.dodajListingUnos(new ListingUnos(url, megabajta));
                izlaz = true;
            } else {
                double potroseniKredit = megabajta * super.getTarifniPaket().getCenaPoMegabajtu();
                if (potroseniKredit < this.kredit){
                    this.kredit -= potroseniKredit;
                    super.getInternetProvajder().zabeleziSaobracaj(this, url, megabajta);
                    this.dodajListingUnos(new ListingUnos(url, megabajta));
                    izlaz = true;
                }
            }
        }

        return izlaz;

    }

    @Override
    public void dodajTarifniDodatak(TarifniDodatak tarifniDodatak) {

        if (tarifniDodatak.getTipPodataka() == TipPodataka.IPTV || tarifniDodatak.getTipPodataka() == TipPodataka.FIKSNA_TELEFONIJA){

            System.out.println("prepaid korisnici ne mogu da kupe dodatak za IPTV ili fiksnu telefoniju");

        } else {

            if (tarifniDodatak.getCenaDodatka() > this.kredit){

                System.out.println("korisnik nema dovoljno kredita za tarifni dodatak");

            } else {

                this.kredit -= tarifniDodatak.getCenaDodatka();

                super.getTarifniDodaci().add(tarifniDodatak);

            }
        }
    }

    public double getKredit() {
        return kredit;
    }

    @Override
    public String toString() {
        return "PrepaidKorisnik{" +
                "kredit=" + kredit +
                "} " + super.toString();
    }
}
