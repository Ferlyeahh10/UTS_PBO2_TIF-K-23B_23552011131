package main;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    private static final List<Pasien> daftarPasien = new ArrayList<>();
    private static final List<Dokter> daftarDokter = new ArrayList<>();
    private static final List<Obat> daftarObat = new ArrayList<>();
    private static final List<Transaksi> daftarTransaksi = new ArrayList<>();
    private static final List<Apoteker> daftarApoteker = new ArrayList<>();
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        setupDummyData();

        System.out.println("=== Sistem Kasir Apotek ===");
        boolean jalan = true;

        while (jalan) {
            System.out.println("\nMenu:");
            System.out.println("1. Beli obat tanpa resep");
            System.out.println("2. Beli obat dengan resep dokter");
            System.out.println("3. Lihat transaksi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> beliTanpaResep();
                case 2 -> beliDenganResep();
                case 3 -> tampilkanTransaksi();
                case 4 -> {
                    jalan = false;
                    System.out.println("Terima kasih!");
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void setupDummyData() {
        // Dummy pasien
        daftarPasien.add(new Pasien(1, "Beni", 24));
        daftarPasien.add(new Pasien(2, "Tatang", 25));

        // Dummy dokter
        daftarDokter.add(new Dokter("dr123", "Dr. Ferlya", "Umum"));
        daftarDokter.add(new Dokter("dr456", "Dr. Tabitha", "Spesialis Kulit"));

        // Dummy apoteker
        daftarApoteker.add(new Apoteker(1, "Dewi", "APT-12345"));
        daftarApoteker.add(new Apoteker(2, "Rudi", "APT-67890"));
  
        // Dummy obat
        daftarObat.add(new Obat(1, "Paracetamol", 10000, 100));
        daftarObat.add(new Obat(2, "Antibiotik", 20000, 100));
        daftarObat.add(new Obat(3, "Salep Kulit", 25000, 50));
        daftarObat.add(new Obat(4, "Vitamin E", 40000, 200));
        
        }

    private static void beliTanpaResep() {
        System.out.println("\n== Beli Obat Tanpa Resep ==");
        Pasien pasien = pilihPasien();

        List<Obat> keranjang = new ArrayList<>();
        int total = 0;
        while (true) {
            Obat obat = pilihObat();
            if (obat == null) break;

            System.out.print("Jumlah: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            if (obat.getStok() < jumlah) {
                System.out.println("Stok tidak cukup!");
                continue;
            }

            obat.kurangiStok(jumlah);
            for (int i = 0; i < jumlah; i++) {
                keranjang.add(obat);
            }
            total += obat.getHarga() * jumlah;

            System.out.print("Tambah obat lagi? (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) break;
        }

        Transaksi transaksi = new Transaksi(
            daftarTransaksi.size() + 1, pasien, keranjang, total, LocalDate.now());
        daftarTransaksi.add(transaksi);

        System.out.println("Transaksi berhasil. Total: Rp" + total);
    }

    private static void beliDenganResep() {
        System.out.println("\n== Beli Obat Dengan Resep ==");
        Pasien pasien = pilihPasien();
        Dokter dokter = pilihDokter();

        Resep resep = new Resep(1, pasien, dokter, LocalDate.now());
        List<DetailResep> detailList = new ArrayList<>();

        List<Obat> keranjang = new ArrayList<>();
        int total = 0;

        while (true) {
            Obat obat = pilihObat();
            if (obat == null) break;

            System.out.print("Jumlah: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine();

            if (obat.getStok() < jumlah) {
                System.out.println("Stok tidak cukup!");
                continue;
            }

            obat.kurangiStok(jumlah);
            detailList.add(new DetailResep(resep, obat, jumlah));
            for (int i = 0; i < jumlah; i++) {
                keranjang.add(obat);
            }
            total += obat.getHarga() * jumlah;

            System.out.print("Tambah obat lagi? (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) break;
        }

        Transaksi transaksi = new Transaksi(
            daftarTransaksi.size() + 1, pasien, keranjang, total, LocalDate.now());
        daftarTransaksi.add(transaksi);

        System.out.println("Transaksi dengan resep berhasil. Total: Rp" + total);
    }

    private static Pasien pilihPasien() {
        System.out.println("Pilih Pasien:");
        for (int i = 0; i < daftarPasien.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, daftarPasien.get(i).getNama());
        }
        System.out.print("Pilihan: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        return daftarPasien.get(idx);
    }

    private static Dokter pilihDokter() {
        System.out.println("Pilih Dokter:");
        for (int i = 0; i < daftarDokter.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, daftarDokter.get(i).getNama());
        }
        System.out.print("Pilihan: ");
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        return daftarDokter.get(idx);
    }

    private static Obat pilihObat() {
        System.out.println("\nPilih Obat:");
        for (int i = 0; i < daftarObat.size(); i++) {
            Obat o = daftarObat.get(i);
            System.out.printf("%d. %s - Rp%.0f (Stok: %d)\n", i + 1, o.getNama(), o.getHarga(), o.getStok());
        }
        System.out.print("Pilihan (0 untuk selesai): ");
        int idx = scanner.nextInt();
        scanner.nextLine();
        if (idx == 0) return null;
        return daftarObat.get(idx - 1);
    }
    
    private static Apoteker pilihApoteker() {
    System.out.println("Pilih Apoteker:");
    for (int i = 0; i < daftarApoteker.size(); i++) {
        System.out.printf("%d. %s\n", i + 1, daftarApoteker.get(i).getNama());
    }
    System.out.print("Pilihan: ");
    int idx = scanner.nextInt() - 1;
    scanner.nextLine();
    return daftarApoteker.get(idx);
}

    private static void tampilkanTransaksi() {
        System.out.println("\n== Riwayat Transaksi ==");
        for (Transaksi t : daftarTransaksi) {
            System.out.printf("ID: %d | Pasien: %s | Total: Rp%d | Tanggal: %s\n",
                    t.getId(), t.getPasien().getNama(), t.getTotal(), t.getTanggal());
        }
    }
}
