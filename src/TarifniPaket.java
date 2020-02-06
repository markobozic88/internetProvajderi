public class TarifniPaket {

    private int brzina;
    private double cenaPaketa;
    private boolean neogranicenSaobracaj;
    private int megabajti;
    private double cenaPoMegabajtu;

    public TarifniPaket(int brzina, double cenaPaketa, boolean neogranicenSaobracaj, int megabajti,
                        double cenaPoMegabajtu){
        this.brzina = brzina;
        this.cenaPaketa = cenaPaketa;
        this.neogranicenSaobracaj = neogranicenSaobracaj;
        this.megabajti = megabajti;
        this.cenaPoMegabajtu = cenaPoMegabajtu;
    }

    public int getBrzina() {
        return brzina;
    }

    public double getCenaPaketa() {
        return cenaPaketa;
    }

    public boolean isNeogranicenSaobracaj() {
        return neogranicenSaobracaj;
    }

    public int getMegabajti() {
        return megabajti;
    }

    public double getCenaPoMegabajtu() {
        return cenaPoMegabajtu;
    }

    public void setMegabajti(int megabajti) {
        this.megabajti = megabajti;
    }

    @Override
    public String toString() {
        return "TarifniPaket{" +
                "brzina=" + brzina +
                ", cenaPaketa=" + cenaPaketa +
                ", neogranicenSaobracaj=" + neogranicenSaobracaj +
                ", megabajti=" + megabajti +
                ", cenaPoMegabajtu=" + cenaPoMegabajtu +
                '}';
    }
}
