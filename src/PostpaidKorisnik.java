public class PostpaidKorisnik extends Korisnik {

    private double prekoracenje;

    public PostpaidKorisnik(InternetProvajder internetProvajder, String ime, String prezime, String adresa, String brojUgovora,
                            TarifniPaket tarifniPaket){
        super(internetProvajder, ime, prezime, adresa, brojUgovora, tarifniPaket);
    }

    public double ukupnoZaNaplatu(){

        double ukupnoZaNaplatu = 0;

        double cenaTarifnogDodatka = 0;

        for (int i = 0; i < this.getTarifniDodaci().size(); i++){
            cenaTarifnogDodatka += this.getTarifniDodaci().get(i).getCenaDodatka();
        }

        ukupnoZaNaplatu = super.getTarifniPaket().getCenaPaketa() + cenaTarifnogDodatka + this.prekoracenje;

        return ukupnoZaNaplatu;
    }

    public String generisiRacun(){

        StringBuilder sb = new StringBuilder();

        sb.append(this.getBrojUgovora())
                .append(", ")
                .append(this.getIme())
                .append(", ")
                .append(this.getPrezime())
                .append(", ")
                .append(this.getTarifniPaket().getCenaPaketa())
                .append(", ")
                .append(super.getTarifniDodaci().toString())
                .append(", ")
                .append(this.prekoracenje)
                .append(", ")
                .append(ukupnoZaNaplatu());

        return sb.toString();
    }

    @Override
    public boolean surfuj(String url, int megabajta) {
        return false;
    }

    @Override
    public void dodajTarifniDodatak(TarifniDodatak tarifniDodatak) {

        if (this.getTarifniPaket().isNeogranicenSaobracaj()){

            if (tarifniDodatak.getTipPodataka() == TipPodataka.IPTV || tarifniDodatak.getTipPodataka() == TipPodataka.FIKSNA_TELEFONIJA){

                this.getTarifniDodaci().add(tarifniDodatak);

            } else {

                System.out.println("korisnici sa neogranicenim saobracajem mogu kupiti samo dodatak za IPTV ili " +
                        "fiksnu telefoniju");

            }

        } else {

            this.getTarifniDodaci().add(tarifniDodatak);

        }





    }

    public double getPrekoracenje() {
        return prekoracenje;
    }

    @Override
    public String toString() {
        return "PostpaidKorisnik{" +
                "prekoracenje=" + prekoracenje +
                "} " + super.toString();
    }
}
