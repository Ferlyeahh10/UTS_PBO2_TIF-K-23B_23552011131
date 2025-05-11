package model;

public class Apoteker extends TenagaMedis {
    private String nomorLisensi;

    public Apoteker(int id, String nama, String nomorLisensi) {
        super(id, nama);
        this.nomorLisensi = nomorLisensi;
    }

    public String getNomorLisensi() {
        return nomorLisensi;
    }

    public void setNomorLisensi(String nomorLisensi) {
        this.nomorLisensi = nomorLisensi;
    }

    @Override
    public void tampilkanPeran() {
        System.out.println("Peran: Apoteker");
        System.out.println("Nama: " + getNama());
        System.out.println("Nomor Lisensi: " + nomorLisensi);
    }
}