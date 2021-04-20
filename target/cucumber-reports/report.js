$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("bluSaving.feature");
formatter.feature({
  "line": 2,
  "name": "bluSaving",
  "description": "",
  "id": "blusaving",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@bluSaving"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "1. Klik tombol lihat semua pada card bluSaving yang sudah memiliki bluSaving, dari halaman dashboard simpanan kondisi  kondisi belum memiliki kombinasi 10 bluSaving/bluGether",
  "description": "",
  "id": "blusaving;1.-klik-tombol-lihat-semua-pada-card-blusaving-yang-sudah-memiliki-blusaving,-dari-halaman-dashboard-simpanan-kondisi--kondisi-belum-memiliki-kombinasi-10-blusaving/blugether",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@TransferRegression"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Berada di halaman Saving Account dengan login akun \"087877828950\" password \"Password123!\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Klik bluSavingCard",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Tampil halaman daftar bluSaving",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "087877828950",
      "offset": 52
    },
    {
      "val": "Password123!",
      "offset": 76
    }
  ],
  "location": "SavingStepDef.berada_di_halaman_Saving_Account_dengan_login_akun_password(String,String)"
});
formatter.result({
  "duration": 28231198600,
  "status": "passed"
});
formatter.match({
  "location": "SavingStepDef.klik_bluSavingCard()"
});
formatter.result({
  "duration": 4900694400,
  "status": "passed"
});
formatter.match({
  "location": "SavingStepDef.tampil_halaman_daftar_bluSaving_terdapat()"
});
formatter.result({
  "duration": 1896356400,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "2. Klik tombol lihat semua pada card bluSaving yang sudah memiliki bluSaving, dari halaman dashboard simpanan kondisi  kondisi belum memiliki kombinasi 10 bluSaving/bluGether",
  "description": "",
  "id": "blusaving;2.-klik-tombol-lihat-semua-pada-card-blusaving-yang-sudah-memiliki-blusaving,-dari-halaman-dashboard-simpanan-kondisi--kondisi-belum-memiliki-kombinasi-10-blusaving/blugether",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@TransferRegression"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "Berada di halaman Saving Account dengan login akun \"081234567898\" password \"Password123!\"",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "Klik bluSavingCard",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "Tampil halaman daftar bluSaving penuh",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "081234567898",
      "offset": 52
    },
    {
      "val": "Password123!",
      "offset": 76
    }
  ],
  "location": "SavingStepDef.berada_di_halaman_Saving_Account_dengan_login_akun_password(String,String)"
});
formatter.result({
  "duration": 27551286400,
  "status": "passed"
});
formatter.match({
  "location": "SavingStepDef.klik_bluSavingCard()"
});
formatter.result({
  "duration": 3005571500,
  "status": "passed"
});
formatter.match({
  "location": "SavingStepDef.tampil_halaman_daftar_bluSaving_terdapat_penuh()"
});
formatter.result({
  "duration": 2908762300,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "3. Klik tombol Tambah bluSaving",
  "description": "",
  "id": "blusaving;3.-klik-tombol-tambah-blusaving",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@TransferRegression"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "Berada di halaman Saving Account dengan login akun \"081234567898\" password \"Password123!\"",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Klik tombol tambah",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Tampil halaman tambah bluSaving",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "081234567898",
      "offset": 52
    },
    {
      "val": "Password123!",
      "offset": 76
    }
  ],
  "location": "SavingStepDef.berada_di_halaman_Saving_Account_dengan_login_akun_password(String,String)"
});
formatter.result({
  "duration": 28824935500,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({
  "location": "SavingStepDef.tampil_halaman_tambah_bluSaving()"
});
formatter.result({
  "status": "skipped"
});
});