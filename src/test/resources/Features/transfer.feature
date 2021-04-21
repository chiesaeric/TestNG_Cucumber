@Transfer
Feature: Transfer

  @TransferRegression
  Scenario: 1. Verifikasi Layar homescreen dengan kondisi user tidak pernah melakukan transfer ke rekening favorit
    Given Login Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    When Check list favorit Home screen
    Then Tidak terdapat section Transaksi Favorit Terakhir

  @TransferRegression
  Scenario: 2. Verifikasi Layar homescreen dengan kondisi user pernah melakukan transfer ke rekening favorit
    Given Login Berada di halaman Home screen dengan login akun "087877828950" password "Password123!"
    When Check list favorit Home screen
    Then Terdapat section Transaksi Favorit Terakhir :Gambar default icon transfer,Alias (jika ada)

  @TransferRegression3
  Scenario: 3. Transfer tanpa keterangan
    Given Login Berada di halaman Home screen dengan login akun "085367465756" password "Password123!"
    When  Go to homescreen saldo "awal tujuan"
    And   Berada di halaman Home screen dengan login akun "081299988881" password "Password123!"
    And   Go to homescreen saldo "awal sumber"
    And   Go to halaman limit "awal"
    And   Klik Transaksi
    And   Pilih Transfer
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


  @TransferRegression
  Scenario: 4. Transfer dengan keterangan
    Given Login Berada di halaman Home screen dengan login akun "085367465756" password "Password123!"
    When  Go to homescreen saldo "awal tujuan"
    And Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    And  Go to homescreen saldo "awal sumber"
    And   Go to halaman limit "awal"
    And   Klik Transaksi
    And   Pilih Transfer
    And   Pilih Rekening "000000000220"
    And   Isi Nominal "10000"
    And   Isi Catatan "Automation"
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


    @TransferRegression
    Scenario: 6. Transfer ke rekening Bank Digital BCA baru, kondisi nomor rekening valid dan tidak centang pilihan simpan ke daftar
      Given Login Berada di halaman Home screen dengan login akun "081234567898" password "Password123!"
      When  Go to homescreen saldo "awal tujuan"
      And   Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
      And   Go to homescreen saldo "awal sumber"
      And   Go to halaman limit "awal"
      And   Klik Transaksi
      And   Pilih Transfer
      And   Pilih Transfer Baru
      And   Pilih Transfer Bank "BCA DIGITAL"
      And   Isi Rekening "000000000048"
      And   Klik Cek
      And   Isi Nominal "10000"
      And   Isi Catatan "Automation"
      And   Klik Lanjut
      And   Transfer
      And   Masukan PIN "123456"
      And   Klik kembali ke beranda
      And   Go to homescreen saldo "akhir sumber"
      And   Go to halaman mutasi "sumber"
#    And   Go to notifikasi "sumber"
    And   Go to halaman limit "akhir"
      And   logout
      And   Berada di halaman Home screen dengan login akun "081234567898" password "Password123!"
      And   Go to homescreen saldo "akhir tujuan"
#    And   Go to halaman mutasi "tujuan"
#    And   Go to notifikasi "tujuan"
      And   logout
      Then Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang,saldo tujuan bertambah

  @TransferRegression
  Scenario: 7. Transfer ke rekening Bank Digital BCA yang sudah terdaftar melalui menu transfer ke rekening baru
    Given Login Berada di halaman Home screen dengan login akun "081234567898" password "Password123!"
    When  Go to homescreen saldo "awal tujuan"
    And   Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    And   Go to homescreen saldo "awal sumber"
    And   Go to halaman limit "awal"
    And   Klik Transaksi
    And   Pilih Transfer
    And   Pilih Transfer Baru
    And   Pilih Transfer Bank "BCA DIGITAL"
    And   Isi Rekening "000000000048"
    And   Klik Cek
    And   Isi Nominal "10000"
    And   Isi Catatan "Automation"
    And   Klik Lanjut
    And   Transfer
    And   Masukan PIN "123456"
    And   Klik kembali ke beranda
    And   Go to homescreen saldo "akhir sumber"
    And   Go to halaman mutasi "sumber"
#    And   Go to notifikasi "sumber"
    And   Go to halaman limit "akhir"
    And   logout
    And   Berada di halaman Home screen dengan login akun "081234567898" password "Password123!"
    And   Go to homescreen saldo "akhir tujuan"
#    And   Go to halaman mutasi "tujuan"
#    And   Go to notifikasi "tujuan"
    And   logout
    Then Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang,saldo tujuan bertambah


  @TransferRegression
  Scenario: 8. Transfer ke rekening Bank Digital BCA yang sudah terdaftar melalui Daftar Rekening Tujuan
    Given Login Berada di halaman Home screen dengan login akun "085367465756" password "Password123!"
    When  Go to homescreen saldo "awal tujuan"
    And   Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    And   Go to homescreen saldo "awal sumber"
    And   Go to halaman limit "awal"
    And   Klik Transaksi
    And   Pilih Transfer
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


  @TransferRegression
  Scenario: 10. Transfer ke rekening bank lain baru, kondisi nomor rekening valid dan tidak centang pilihan simpan ke daftar
    Given Login Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    When  Go to homescreen saldo "awal sumber"
    And   Go to halaman limit "awal"
    And   Klik Transaksi
    And   Pilih Transfer
    And   Pilih Transfer Baru
    And   Pilih Transfer Bank "JASA JAKARTA"
    And   Isi Rekening "30220722020"
    And   Klik Cek
    And   Isi Nominal "10000"
    And   Isi Catatan "Automation"
    And   Klik Lanjut
    And   Transfer
    And   Masukan PIN "123456"
    And   Klik kembali ke beranda
    And   Go to homescreen saldo "akhir sumber"
    And   Go to halaman mutasi "sumber"
#    And   Go to notifikasi "sumber"
    And   Go to halaman limit "akhir"
    And   logout
    Then Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang


  @TransferRegression
  Scenario: 11. Transfer ke rekening bank lain yang sudah terdaftar melalui menu transfer ke rekening baru
    Given Login Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    When  Go to homescreen saldo "awal sumber"
    And   Go to halaman limit "awal"
    And   Klik Transaksi
    And   Pilih Transfer
    And   Pilih Transfer Baru
    And   Pilih Transfer Bank "JAMBI"
    And   Isi Rekening "30220722020"
    And   Klik Cek
    And   Isi Nominal "10000"
    And   Isi Catatan "Automation"
    And   Klik Lanjut
    And   Transfer
    And   Masukan PIN "123456"
    And   Klik kembali ke beranda
    And   Go to homescreen saldo "akhir sumber"
    And   Go to halaman mutasi "sumber"
#    And   Go to notifikasi "sumber"
    And   Go to halaman limit "akhir"
    And   logout
    Then Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang


  @TransferRegression
  Scenario: 12. Transfer ke rekening bank lain yang sudah terdaftar melalui Daftar Rekening Tujuan
    Given Login Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    When  Go to homescreen saldo "awal sumber"
    And   Go to halaman limit "awal"
    And   Klik Transaksi
    And   Pilih Transfer
    And   Pilih Rekening "30220722020"
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
    Then Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang


  @TransferRegression
  Scenario: 13. Transfer dengan reward yang otomatis terpasang
    Given Login Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    When  Go to homescreen saldo "awal sumber"
    And   Go to halaman limit "awal"
#    And   Go to halaman bluRewards "awal"
    And   Klik Transaksi
    And   Pilih Transfer
    And   Pilih Rekening "30220722020"
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
#    And   Go to halaman bluRewards "akhir"
    And   logout
    Then Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang, Rewards berkurang


  @TransferRegression
  Scenario: 14. Transfer tanpa reward
    Given Login Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    When  Go to homescreen saldo "awal sumber"
    And   Go to halaman limit "awal"
#    And   Go to halaman bluRewards "awal"
    And   Klik Transaksi
    And   Pilih Transfer
    And   Pilih Rekening "30220722020"
    And   Isi Nominal "10000"
    And   Uncheck rewards terpakai
    And   Klik Lanjut
    And   Transfer
    And   Masukan PIN "123456"
    And   Klik kembali ke beranda
    And   Go to homescreen saldo "akhir sumber"
    And   Go to halaman mutasi "sumber"
#    And   Go to notifikasi "sumber"
    And   Go to halaman limit "akhir"
#    And   Go to halaman bluRewards "akhir"
    And   logout
    Then Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang,Rewards berkurang


  @TransferRegression @TestSebagian
  Scenario: 14. Klik tombol Kembali ke Beranda
    Given Login Berada di halaman Home screen dengan login akun "087877828955" password "Password123!"
    When   Klik Transaksi
    And   Pilih Transfer
    And   Pilih Rekening "000000000220"
    And   Isi Nominal "10000"
    And   Isi Catatan ""
    And   Klik Lanjut
    And   Transfer
    And   Masukan PIN "123456"
    And   Klik kembali ke beranda
    Then Kembali ke Homescreen
