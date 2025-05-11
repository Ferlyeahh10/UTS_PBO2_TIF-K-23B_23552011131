package model;

public class DetailResep {
    private Resep resep;
    private Obat obat;
    private int jumlah;

    public DetailResep(Resep resep, Obat obat, int jumlah) {
        this.resep = resep;
        this.obat = obat;
        this.jumlah = jumlah;
    }

    public Resep getResep() {
        return resep;
    }

    public Obat getObat() {
        return obat;
    }

    public int getJumlah() {
        return jumlah;
    }
}
