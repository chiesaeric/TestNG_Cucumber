@bluSaving
Feature: bluSaving

  @TransferRegression
  Scenario: 1. Klik tombol lihat semua pada card bluSaving yang sudah memiliki bluSaving, dari halaman dashboard simpanan kondisi  kondisi belum memiliki kombinasi 10 bluSaving/bluGether
    Given Berada di halaman Saving Account dengan login akun "087877828950" password "Password123!"
    When Klik bluSavingCard
    Then Tampil halaman daftar bluSaving

  @TransferRegression
  Scenario: 2. Klik tombol lihat semua pada card bluSaving yang sudah memiliki bluSaving, dari halaman dashboard simpanan kondisi  kondisi belum memiliki kombinasi 10 bluSaving/bluGether
    Given Berada di halaman Saving Account dengan login akun "081234567898" password "Password123!"
    When Klik bluSavingCard
    Then Tampil halaman daftar bluSaving penuh

  @TransferRegression
  Scenario: 3. Klik tombol Tambah bluSaving
    Given Berada di halaman Saving Account dengan login akun "081234567898" password "Password123!"
    When Klik tombol tambah
    Then Tampil halaman tambah bluSaving

