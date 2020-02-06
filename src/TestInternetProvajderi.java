public class TestInternetProvajderi {

    public static void main(String[] args) {

        InternetProvajder ip1 = new InternetProvajder("mts");
        InternetProvajder ip2 = new InternetProvajder("telenor");
        InternetProvajder ip3 = new InternetProvajder("orion");
        InternetProvajder ip4 = new InternetProvajder("sbb");

        TarifniPaket tp1 = new TarifniPaket(10, 1000, true, 300, 5);
        TarifniPaket tp2 = new TarifniPaket(5, 800, false, 100, 3);
        TarifniPaket tp3 = new TarifniPaket(20, 1800, false, 2000, 2);
        TarifniPaket tp4 = new TarifniPaket(15, 1300, true, 1000, 4);
        TarifniPaket tp5 = new TarifniPaket(30, 2500, true, 3000, 5);

        Korisnik kor1 = new PrepaidKorisnik(ip1, "Aleksandar", "Zikic", "Krunska 22", "az87452", tp1);
        Korisnik kor2 = new PrepaidKorisnik(ip2, "Ivona", "Miljkovic", "Glavna 4", "im12015", tp2);
        Korisnik kor3 = new PrepaidKorisnik(ip3, "Stefan", "Maksimovic", "Pozeska 41", "sm89452", tp3);
        Korisnik kor4 = new PrepaidKorisnik(ip4, "Mihajlo", "Obradovic", "BKA 250", "mo87222", tp4);
        Korisnik kor5 = new PrepaidKorisnik(ip2, "Sonja", "Sasic", "Balkanska 13", "ss00012", tp5);
        Korisnik kor6 = new PrepaidKorisnik(ip3, "Kristina", "Nesic", "Zahumska 20", "kn3214", tp3);
        Korisnik kor7 = new PrepaidKorisnik(ip4, "Zvonko", "Zdravkovic", "Nusiceva 50", "zz4712", tp1);

        Korisnik kor8 = new PostpaidKorisnik(ip1, "Marko", "Bozic", "Mokroluska 164", "mb0001", tp1);
        Korisnik kor9 = new PostpaidKorisnik(ip3, "Ivana", "Tosovic", "Ustanicka 210", "it2513", tp2);
        Korisnik kor10 = new PostpaidKorisnik(ip2, "Ksenija", "Vukovic", "Krfska 13", "kv65412", tp3);
        Korisnik kor11 = new PostpaidKorisnik(ip4, "Vladimir", "Stojakovic", "Nemanikuce bb", "vs1200", tp4);
        Korisnik kor12 = new PostpaidKorisnik(ip2, "Ljovisna", "Hezerbegovic", "Karton naselje 3", "ljh5555", tp5);
        Korisnik kor13 = new PostpaidKorisnik(ip1, "Mia", "Lepa", "Kuca 18", "ml54123", tp2);
        Korisnik kor14 = new PostpaidKorisnik(ip3, "Misa", "Kojic", "Kumodraska 12", "mk11114", tp3);

        ip1.prikazPrepaidKorisnika();
        ip1.prikazPostpaidKorisnika();

        System.out.println();

        ip1.generisiRacune();

        System.out.println();

        ip2.prikazPrepaidKorisnika();
        ip2.prikazPostpaidKorisnika();

        System.out.println();

        ListingUnos lu1 = new ListingUnos("google", 300);
        ListingUnos lu2 = new ListingUnos("facebook", 2000);
        ListingUnos lu3 = new ListingUnos("instagram", 400);
        ListingUnos lu4 = new ListingUnos("google", 500);

        kor8.dodajListingUnos(lu1);
        kor8.dodajListingUnos(lu2);
        kor8.dodajListingUnos(lu3);
        kor8.dodajListingUnos(lu4);
        kor8.dodajListingUnos(new ListingUnos("google", 500));

        System.out.println(kor8.getListingUnosi());

        System.out.println(kor8.napraviListing());

        TarifniDodatak td1 = new TarifniDodatak(250, TipPodataka.facebook);
        TarifniDodatak td2 = new TarifniDodatak(300, TipPodataka.instagram);
        TarifniDodatak td3 = new TarifniDodatak(350, TipPodataka.twitter);
        TarifniDodatak td4 = new TarifniDodatak(200, TipPodataka.viber);
        TarifniDodatak td5 = new TarifniDodatak(500, TipPodataka.IPTV);
        TarifniDodatak td6 = new TarifniDodatak(400, TipPodataka.FIKSNA_TELEFONIJA);

        ((PrepaidKorisnik) kor1).dopuniKredit(1000);

        kor1.dodajTarifniDodatak(td1);

        kor1.surfuj("facebook", 5);
        kor1.surfuj("instagram", 20);
        kor1.surfuj("facebook", 50);
        kor1.surfuj("instagram", 30);


        System.out.println(kor1.getTarifniDodaci());

        System.out.println(kor1.getListingUnosi());

        kor13.dodajTarifniDodatak(td2);

        System.out.println(kor13.getTarifniDodaci());














    }
}
