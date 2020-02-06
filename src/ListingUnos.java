public class ListingUnos implements Comparable<ListingUnos> {

    private String url;
    private int megabajti;

    public ListingUnos(String url, int megabajti){
        this.url = url;
        this.megabajti = megabajti;
    }

    @Override
    public int compareTo(ListingUnos o) {
        return o.getMegabajti() - this.megabajti;
    }

    public String getUrl() {
        return url;
    }

    public int getMegabajti() {
        return megabajti;
    }

    public void dodajMegabajte(int megabajti) {
        this.megabajti += megabajti;
    }

    @Override
    public String toString() {
        return "url = " + this.url + ", megabajti = " + this.megabajti;
    }
}
