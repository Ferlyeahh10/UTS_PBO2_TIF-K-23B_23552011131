package model;

public abstract class TenagaMedis {
    protected int id;
    protected String nama;

    public TenagaMedis(int id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public abstract void tampilkanPeran();
}
