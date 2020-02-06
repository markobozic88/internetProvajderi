import java.util.Map;

public class TarifniDodatak {

    private double cenaDodatka;
    private TipPodataka tipPodataka;

    public TarifniDodatak(double cenaDodatka, TipPodataka tipPodataka){
        this.cenaDodatka = cenaDodatka;
        this.tipPodataka = tipPodataka;
    }

    public double getCenaDodatka() {
        return cenaDodatka;
    }

    public TipPodataka getTipPodataka() {
        return tipPodataka;
    }

    @Override
    public String toString() {
        return "TarifniDodatak{" +
                "cenaDodatka=" + getCenaDodatka() +
                ", tipPodataka=" + getTipPodataka() +
                '}';
    }
}
