package model;

import java.time.LocalDate;

public class Resep {
    private int id;
    private Pasien pasien;
    private Dokter dokter;
    private LocalDate tanggal;

    public Resep(int id, Pasien pasien, Dokter dokter, LocalDate tanggal) {
        this.id = id;
        this.pasien = pasien;
        this.dokter = dokter;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public LocalDate getTanggal() {
        return tanggal;
    }
}
