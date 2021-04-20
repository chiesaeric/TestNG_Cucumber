@Login
Feature: New Login

  Scenario::Klik Tombol Yuk Mulai
    Given Berada dihalaman onboarding
    When Klik Tombol Yuk Mulai
    Then Tampil layar Login input nomor handphone.Terdapat : Kolom Nomor Handphone, Tombol Lanjut (default disable)

  Scenario::Input Nomor Handphone dengan nomor valid
    Given Berada dihalaman Nomor telpon
    When Input Nomor Handphone dengan nomor "087877828955"
    Then Berhasil melakukan input Nomor Handphone.Keyboard yang tampil adalah keyboard numeric.Tombol lanjut aktif


  Scenario Outline::Input Nomor Handphone diawali dengan 0/62
    Given Berada dihalaman Nomor telpon
    When Input Nomor Handphone dengan nomor "<nomor>"
    And Klik lanjut
    Then Proses login dapat dilanjutkan

    Examples:
    |nomor|
    |087877828955|
    |6287877828955|

  Scenario::Input Nomor Handphone diawali selain 0/62
    Given Berada dihalaman Nomor telpon
    When Input Nomor Handphone dengan nomor "12345678910"
    And Klik lanjut
    Then Tidak dapat melanjutkan proses login.Tampil message :Harus diawali angka 0 atau 62 nih

  Scenario::Input Nomor Handphone dengan nomor dikosongkan
    Given Berada dihalaman Nomor telpon
    When Input Nomor Handphone dengan nomor ""
    And Klik lanjut
    Then Tidak dapat melanjutkan proses login.Button "lanjut" disabled

  Scenario::Input Nomor Handphone diisi selain numberic
    Given Berada dihalaman Nomor telpon
    When  Input Nomor Handphone dengan nomor "Automation"
    And Klik lanjut
    Then Input selain numeric akan otomatis menghapus selain numeric

  Scenario::Input Nomor Handphone diawali 0 diisi kurang dari 10 digit
    Given Berada dihalaman Nomor telpon
    When Input Nomor Handphone dengan nomor "081234567"
    And Klik lanjut
    Then Tidak dapat melanjutkan proses login.Tampil message :Harus diisi minimum 10 digit no. handphone nih