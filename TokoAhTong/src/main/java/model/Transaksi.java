package model;

import java.time.LocalDate;
import java.util.List;

public class Transaksi {
    private int id;
    private Pasien pasien;
    private List<Obat> daftarObat;
    private int total;
    private LocalDate tanggal;

    public Transaksi(int id, Pasien pasien, List<Obat> daftarObat, int total, LocalDate tanggal) {
        this.id = id;
        this.pasien = pasien;
        this.daftarObat = daftarObat;
        this.total = total;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public List<Obat> getDaftarObat() {
        return daftarObat;
    }

    public int getTotal() {
        return total;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }
}
