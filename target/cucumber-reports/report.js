$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("transfer.feature");
formatter.feature({
  "line": 2,
  "name": "Transfer",
  "description": "",
  "id": "transfer",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Transfer"
    }
  ]
});
formatter.scenario({
  "line": 17,
  "name": "3. Transfer tanpa keterangan",
  "description": "",
  "id": "transfer;3.-transfer-tanpa-keterangan",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 16,
      "name": "@TransferRegression3"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "Login Berada di halaman Home screen dengan login akun \"085367465756\" password \"Password123!\"",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Go to homescreen saldo \"awal tujuan\"",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Berada di halaman Home screen dengan login akun \"081299988881\" password \"Password123!\"",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "Go to homescreen saldo \"awal sumber\"",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "Go to halaman limit \"awal\"",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Klik Transaksi",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "Pilih Transfer",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "Pilih Rekening \"000000000220\"",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Isi Nominal \"10000\"",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "Isi Catatan \"\"",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "Klik Lanjut",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Transfer",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Masukan PIN \"123456\"",
  "keyword": "And "
});
formatter.step({
  "line": 31,
  "name": "Klik kembali ke beranda",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Go to homescreen saldo \"akhir sumber\"",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "Go to halaman mutasi \"sumber\"",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 34,
      "value": "#    And   Go to notifikasi \"sumber\""
    }
  ],
  "line": 35,
  "name": "Go to halaman limit \"akhir\"",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "logout",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "Berada di halaman Home screen dengan login akun \"085367465756\" password \"Password123!\"",
  "keyword": "And "
});
formatter.step({
  "line": 38,
  "name": "Go to homescreen saldo \"akhir tujuan\"",
  "keyword": "And "
});
formatter.step({
  "comments": [
    {
      "line": 39,
      "value": "#    And   Go to halaman mutasi \"tujuan\""
    },
    {
      "line": 40,
      "value": "#    And   Go to notifikasi \"tujuan\""
    }
  ],
  "line": 41,
  "name": "logout",
  "keyword": "And "
});
formatter.step({
  "line": 42,
  "name": "Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang,saldo tujuan bertambah",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "085367465756",
      "offset": 55
    },
    {
      "val": "Password123!",
      "offset": 79
    }
  ],
  "location": "TransferStepDef.login_berada_di_halaman_Home_screen_dengan_login_akun(String,String)"
});
formatter.result({
  "duration": 31020404513,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "awal tujuan",
      "offset": 24
    }
  ],
  "location": "TransferStepDef.go_to_homescreen_saldo_awal(String)"
});
formatter.result({
  "duration": 7615035446,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "081299988881",
      "offset": 49
    },
    {
      "val": "Password123!",
      "offset": 73
    }
  ],
  "location": "TransferStepDef.berada_di_halaman_Home_screen_dengan_login_akun(String,String)"
});
formatter.result({
  "duration": 27251666016,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "awal sumber",
      "offset": 24
    }
  ],
  "location": "TransferStepDef.go_to_homescreen_saldo_awal(String)"
});
formatter.result({
  "duration": 3643206440,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "awal",
      "offset": 21
    }
  ],
  "location": "TransferStepDef.go_to_halaman_limit(String)"
});
formatter.result({
  "duration": 19698172590,
  "error_message": "org.openqa.selenium.NoSuchElementException: An element could not be located on the page using the given search parameters.\nFor documentation on this error, please visit: https://www.seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027GDISs-iMac-2.local\u0027, ip: \u0027127.0.0.1\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.15.5\u0027, java.version: \u00271.8.0_271\u0027\nDriver info: io.appium.java_client.ios.IOSDriver\nCapabilities {automationName: XCUITest, browserName: , bundleId: com.bcad.blu.uat, databaseEnabled: false, deviceName: iPhone, javascriptEnabled: true, locationContextEnabled: false, networkConnectionEnabled: false, noReset: false, platform: MAC, platformName: iOS, platformVersion: 14.4, takesScreenshot: true, udid: 00008030-001E64E22629802E, webStorageEnabled: false, xcodeOrgId: R4N3H2DJCM, xcodeSigningId: iPhone Developer}\nSession ID: dd1959f4-1063-4d12-bbcd-7bf415957ea9\n*** Element info: {Using\u003dxpath, value\u003d//XCUIElementTypeStaticText[@name\u003d\"Sisa limit transaksi hari ini\"]/following-sibling::XCUIElementTypeStaticText}\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.createException(W3CHttpResponseCodec.java:187)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:122)\n\tat org.openqa.selenium.remote.http.W3CHttpResponseCodec.decode(W3CHttpResponseCodec.java:49)\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\n\tat io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:247)\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:552)\n\tat io.appium.java_client.DefaultGenericMobileDriver.execute(DefaultGenericMobileDriver.java:41)\n\tat io.appium.java_client.AppiumDriver.execute(AppiumDriver.java:1)\n\tat io.appium.java_client.ios.IOSDriver.execute(IOSDriver.java:1)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:323)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:61)\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\n\tat io.appium.java_client.ios.IOSDriver.findElement(IOSDriver.java:1)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByXPath(RemoteWebDriver.java:428)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElementByXPath(DefaultGenericMobileDriver.java:151)\n\tat io.appium.java_client.AppiumDriver.findElementByXPath(AppiumDriver.java:1)\n\tat io.appium.java_client.ios.IOSDriver.findElementByXPath(IOSDriver.java:1)\n\tat org.openqa.selenium.By$ByXPath.findElement(By.java:353)\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:315)\n\tat io.appium.java_client.DefaultGenericMobileDriver.findElement(DefaultGenericMobileDriver.java:57)\n\tat io.appium.java_client.AppiumDriver.findElement(AppiumDriver.java:1)\n\tat io.appium.java_client.ios.IOSDriver.findElement(IOSDriver.java:1)\n\tat StepDefinitions.TransferStepDef.go_to_halaman_limit(TransferStepDef.java:307)\n\tat ✽.And Go to halaman limit \"awal\"(transfer.feature:22)\n",
  "status": "failed"
});
formatter.match({
  "location": "TransferStepDef.klik_Transaksi()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransferStepDef.pilih_Transfer()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "000000000220",
      "offset": 16
    }
  ],
  "location": "TransferStepDef.pilih_Rekening(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "10000",
      "offset": 13
    }
  ],
  "location": "TransferStepDef.isi_Nominal(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 13
    }
  ],
  "location": "TransferStepDef.isi_Catatan(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransferStepDef.klik_Lanjut()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransferStepDef.transfer()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "123456",
      "offset": 13
    }
  ],
  "location": "TransferStepDef.masukan_PIN(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransferStepDef.klik_kembali_ke_beranda()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "akhir sumber",
      "offset": 24
    }
  ],
  "location": "TransferStepDef.go_to_homescreen_saldo_awal(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "sumber",
      "offset": 22
    }
  ],
  "location": "TransferStepDef.go_to_halaman_mutasi(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "akhir",
      "offset": 21
    }
  ],
  "location": "TransferStepDef.go_to_halaman_limit(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransferStepDef.logout()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "085367465756",
      "offset": 49
    },
    {
      "val": "Password123!",
      "offset": 73
    }
  ],
  "location": "TransferStepDef.berada_di_halaman_Home_screen_dengan_login_akun(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "akhir tujuan",
      "offset": 24
    }
  ],
  "location": "TransferStepDef.go_to_homescreen_saldo_awal(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransferStepDef.logout()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "TransferStepDef.check_Bukti_transaksi_Mutasi_limit_berkurang_notifikasi_saldo_sumber_berkurang_saldo_tujuan_bertambah()"
});
formatter.result({
  "status": "skipped"
});
});