# UTS_PBO2_TIF-K-23B_23552011131
<ul>
  <li>Mata Kuliah: Pemrograman Berorientasi Obyek 2</li>
  <li>Dosen Pengampu: Muhammad Ikhwan Fathulloh, S.Kom.
</ul>

## Profil
<ul>
  <li>Nama: Ferlya Tabitha P</li>
  <li>NIM: 23552011131</li>
  <li>Studi Kasus: Kasir Apotek</li>
</ul>

## Judul Studi Kasus
<p>Sistem Kasik Apotek Sederhana bernama Apotik Tong</p>

## Penjelasan Studi Kasus
<p>Proyek ini merupakan implementasi sederhana dari sistem kasir apotek yang memungkinkan pengelolaan transaksi pembelian obat, baik dengan resep dokter maupun pembelian langsung. Proyek ini dirancang untuk mengilustrasikan konsep-konsep dasar Pemrograman Berorientasi Objek (OOP) dalam konteks studi kasus nyata.</p>

## Penjelasan 4 Pilar OOP dalam Studi Kasus

### 1. Inheritance
<p>Konsep inheritance diimplementasikan melalui class `TenagaMedis` sebagai class abstrak induk. Class `Dokter` dan `Apoteker` mewarisi atribut dan perilaku umum dari `TenagaMedis` (seperti `id` dan `nama`).</p>

### 2. Encapsulation
<p>Encapsulation diterapkan untuk melindungi data dan mengontrol akses ke informasi dalam objek. Hal ini dicapai dengan mendeklarasikan atribut class sebagai `private` dan menyediakan method `public` (getter dan setter jika diperlukan) untuk mengakses atau memodifikasi data tersebut.</p>
<p>Contoh: Informasi `Pasien` (seperti `id`, `nama`, `umur`) dan detail `Transaksi` (seperti daftar obat, total harga, tanggal) dienkapsulasi dalam class masing-masing. Akses ke informasi ini dikontrol melalui method `getter`.</p>

### 3. Polymorphism
<p>Konsep polymorphism dalam proyek ini dapat dilihat melalui method `tampilkanPeran()` yang diwarisi dari class abstrak `TenagaMedis`. Class `Dokter` dan `Apoteker` meng-override method ini untuk menampilkan peran spesifik mereka.</p>
<p>Contoh: Ketika method `tampilkanPeran()` dipanggil pada objek `Dokter`, outputnya akan menunjukkan "Peran: Dokter" beserta informasi dokter. Ketika method yang sama dipanggil pada objek `Apoteker`, outputnya akan menunjukkan "Peran: Apoteker" beserta informasi apoteker. Ini menunjukkan satu method dengan perilaku yang berbeda tergantung pada jenis objeknya.</p>

### 4. Abstract
<p>Abstraksi dicapai melalui penggunaan class abstrak `TenagaMedis`. Class ini mendefinisikan karakteristik umum dari tenaga medis (seperti `id` dan `nama`) dan memaksa subclass konkret (`Dokter`, `Apoteker`) untuk mengimplementasikan perilaku spesifik mereka (melalui method abstrak `tampilkanPeran()`).<p/>
<p></p>Contoh: `TenagaMedis` menyembunyikan detail implementasi spesifik dari setiap jenis tenaga medis dan hanya menyediakan antarmuka umum. Subclass `Dokter` dan `Apoteker` kemudian mengimplementasikan bagaimana peran mereka ditampilkan.</p>

## Demo Proyek
<ul>
  <li>Github: <a href="">Github</a></li>
  <li>Youtube: <a href="">Youtube</a></li>
</ul>
