package model;

public class Dokter {
    private final String id;
    private final String nama;
    private final String spesialis;

    public Dokter(String id, String nama, String spesialis) {
        this.id = id;
        this.nama = nama;
        this.spesialis = spesialis;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getSpesialis() {
        return spesialis;
    }
}
