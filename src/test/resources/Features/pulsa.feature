@Pulsa
Feature: Pulsa

  @TransferRegression
  Scenario: 3. Transfer tanpa keterangan
    Given   Login Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    When  Go to homescreen saldo "awal sumber"
    And   Go to halaman limit "awal"
    And   Klik Transaksi
    And   Pilih Bayar/Beli
    And   Pilih Pulsa
    And   Pilih Rekening "000000000220"
    And   Isi Nominal "10000"
    And   Isi Catatan ""
    And   Klik Lanjut
    And   Transfer
    And   Masukan PIN "123456"
    And   Klik kembali ke beranda
    And   Go to homescreen saldo "akhir sumber"
    And   Go to halaman mutasi "sumber"
#    And   Go to notifikasi "sumber"
    And   Go to halaman limit "akhir"
    And   logout
    And   Berada di halaman Home screen dengan login akun "085367465756" password "Password123!"
    And   Go to homescreen saldo "akhir tujuan"
#    And   Go to halaman mutasi "tujuan"
#    And   Go to notifikasi "tujuan"
    And   logout
    Then Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang,saldo tujuan bertambah