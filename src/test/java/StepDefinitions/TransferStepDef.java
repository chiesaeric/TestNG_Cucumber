package StepDefinitions;

import Lib.FunctionalLib;
import Lib.ReadObject;
import Lib.StepLib;
import MyRunner.RunneriOS;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.AfterStep;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.aspectj.weaver.AdviceKind.After;

public class TransferStepDef extends RunneriOS {

    public IOSDriver driver = this.connection;
    public ReadObject pars = this.parser;
    public WebDriverWait waits = this.wait;
    public String capturePath = RunneriOS.capturePath;
    public String featureName = RunneriOS.currentFeature;

    //============================= GIVEN ============================

    @Given("^Login Berada di halaman Home screen dengan login akun \"([^\"]*)\" password \"([^\"]*)\"$")
    public void login_berada_di_halaman_Home_screen_dengan_login_akun(String username, String password) throws InterruptedException {
        Boolean checkExist,checkOTP;
        intScenarioNum++;
        driver.resetApp();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
       try{
            checkExist = driver.findElement(pars.getbjectLocator("login_btnLoginDenganAkunLain")).isDisplayed();
       }catch (Exception e){
           checkExist = false;
       }
        try{
            checkOTP = driver.findElement(pars.getbjectLocator("login_btnOtp")).isDisplayed();
        }catch (Exception e){
            checkOTP = false;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if(checkExist==true){
            StepLib.ExistingloginNoCapture();
        }else if(checkOTP==true){
            StepLib.swipeBack();
        }
        StepLib.loginNoCapture(username,password);

    }

    //============================= WHEN =============================

    @When("^Berada di halaman Home screen dengan login akun \"([^\"]*)\" password \"([^\"]*)\"$")
    public void berada_di_halaman_Home_screen_dengan_login_akun(String username, String password) throws InterruptedException {
        Boolean checkExist,checkOTP;
        driver.resetApp();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        try{
            checkExist = driver.findElement(pars.getbjectLocator("login_btnLoginDenganAkunLain")).isDisplayed();
        }catch (Exception e){
            checkExist = false;
        }
        try{
            checkOTP = driver.findElement(pars.getbjectLocator("login_btnOtp")).isDisplayed();
        }catch (Exception e){
            checkOTP = false;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        if(checkExist==true){
            StepLib.ExistingloginNoCapture();
        }else if(checkOTP==true){
            StepLib.swipeBack();
        }
        StepLib.loginNoCapture(username,password);

    }

    @When("^Go to homescreen saldo \"([^\"]*)\"$")
    public void go_to_homescreen_saldo_awal(String keterangan) throws Throwable {
        if(driver.findElement(pars.getbjectLocator("dashboard_lblSaldo")).getText().contains("●")){
            driver.findElement(pars.getbjectLocator("dashboard_btnHidden")).click();
        }
        if(keterangan.equals("awal sumber")){
            glbVarString.put("varGlbSaldoAwalSumber",driver.findElement(pars.getbjectLocator("dashboard_lblSaldo")).getText());
        }else if(keterangan.equals("akhir sumber")){
            glbVarString.put("varGlbSaldoAkhirSumber",driver.findElement(pars.getbjectLocator("dashboard_lblSaldo")).getText());
        }else if(keterangan.equals("awal tujuan")){
            glbVarString.put("varGlbSaldoAwalTujuan",driver.findElement(pars.getbjectLocator("dashboard_lblSaldo")).getText());
        } else if(keterangan.equals("akhir tujuan")){
            glbVarString.put("varGlbSaldoAkhirTujuan",driver.findElement(pars.getbjectLocator("dashboard_lblSaldo")).getText());
        }

        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
    }


    @When("^Check list favorit Home screen$")
    public void check_list_favorit_Home_screen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(pars.getbjectLocator("dashboard_lblHighlight")).isDisplayed();
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
        //throw new PendingException();
    }

    @When("^Klik Transaksi$")
    public void klik_Transaksi() throws Throwable {
        driver.findElement(pars.getbjectLocator("dashboard_btnTransaksi")).click();
    }

    @When("^Pilih Transfer$")
    public void pilih_Transfer() throws Throwable {
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"dashboard_btnTransfer");
        driver.findElement(pars.getbjectLocator("dashboard_btnTransfer")).click();
    }

    @When("^Pilih Transfer Baru$")
    public void pilih_Transfer_baru() throws Throwable {
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"transfer_btnTransferBaru");
        driver.findElement(pars.getbjectLocator("transfer_btnTransferBaru")).click();
    }

    @When("^Pilih Transfer Bank \"([^\"]*)\"")
    public void pilih_Transfer_bank(String namaBank) throws Throwable {
        waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("transfer_lblTransfer"))));
        StepLib.pilihNamaBank(namaBank);
    }

    @When("^Isi Rekening \"([^\"]*)\"$")
    public void isi_Rekening(String nomorRekening) throws Throwable {
        waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("transfer_lblTransfer"))));
        StepLib.tapNomorRekening();
        driver.findElement(pars.getbjectLocator("transfer_txtNoRek")).sendKeys(nomorRekening);
    }

    @When("^Klik Cek$")
    public void klik_cek() throws Throwable {
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"btnCek");
        driver.findElement(pars.getbjectLocator("btnCek")).click();
    }

    @When("^Pilih Rekening \"([^\"]*)\"$")
    public void pilih_Rekening(String rekening) throws Throwable {
        driver.findElement(pars.getbjectLocator("txtCari")).sendKeys(rekening);
        driver.hideKeyboard();
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"transfer_lstTransfer");
        driver.findElement(pars.getbjectLocator("transfer_lstTransfer")).click();
    }

    @When("^Isi Nominal \"([^\"]*)\"$")
    public void isi_Nominal(String nominal) throws Throwable {
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"transfer_txtNominal");
        driver.findElement(pars.getbjectLocator("transfer_txtNominal")).sendKeys(nominal);

    }

    @When("^Isi Catatan \"([^\"]*)\"$")
    public void isi_Catatan(String catatan) throws Throwable {
        driver.findElement(pars.getbjectLocator("transfer_txtCatatan")).sendKeys(catatan);
    }

    @When("^Uncheck rewards terpakai$")
    public void uncheck_rewards_terpakai() throws Throwable {
        Boolean rewards = false;
        try{
            rewards = driver.findElement(pars.getbjectLocator("transfer_btnRewardsPakai")).isDisplayed();
        }catch (Exception e){
            rewards = false;
        }

        if(rewards==true){
            driver.findElement(pars.getbjectLocator("transfer_btnRewardsPakai")).click();
            FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"rewards_btnPakaiNanti");
            driver.findElement(pars.getbjectLocator("rewards_btnPakaiNanti")).click();
        }

    }



    @When("^Klik Lanjut$")
    public void klik_Lanjut() throws Throwable {
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"transfer_btnLanjut");
        driver.findElement(pars.getbjectLocator("transfer_btnLanjut")).click();
    }

    @When("^Transfer$")
    public void transfer() throws Throwable {
        // GET TEXT KONFIRMASI
        glbVarString.put("varGlbKonJmlTransfer",driver.findElement(pars.getbjectLocator("transfer_lblJumlah")).getText());
        glbVarString.put("varGlbKonBiayaAdmin",driver.findElement(pars.getbjectLocator("transfer_lblBiayaAdmin")).getText());
        try{
            glbVarBoolean.put("varGlbBluRewards",driver.findElement(pars.getbjectLocator("transfer_lblRewards")).isDisplayed());
        }catch (Exception e){
            glbVarBoolean.put("varGlbBluRewards",false);
        }
        glbVarString.put("varGlbKonTotalTransfer",driver.findElement(pars.getbjectLocator("transfer_lblJumlahTotal")).getText());

        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"transfer_btnTransfer");
        driver.findElement(pars.getbjectLocator("transfer_btnTransfer")).click();
    }

    @When("^Masukan PIN \"([^\"]*)\"$")
    public void masukan_PIN(String arg1) throws Throwable {
        waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("lblMasukanPIN"))));
        StepLib.pinTransaksi(arg1.substring(0,1));
        StepLib.pinTransaksi(arg1.substring(1,2));
        StepLib.pinTransaksi(arg1.substring(2,3));
        StepLib.pinTransaksi(arg1.substring(3,4));
        StepLib.pinTransaksi(arg1.substring(4,5));
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
        StepLib.pinTransaksi(arg1.substring(5,6));
    }

    @When("^Klik kembali ke beranda$")
    public void klik_kembali_ke_beranda() throws Throwable {
        // GET TEXT KONFIRMASI
        try {
            waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("buktiTransfer_btnKembaliBeranda"))));
        }catch (Exception e){

        }
        glbVarString.put("varGlbBukTrxTotalTransfer",driver.findElement(pars.getbjectLocator("buktiTransfer_lblJumalh")).getText());
        glbVarString.put("varGlbBukTrxNoReff",driver.findElement(pars.getbjectLocator("buktiTransfer_NoReff")).getText());
        glbVarBoolean.put("varGlbBCADExist",driver.findElement(pars.getbjectLocator("buktiTransfer_namaBank")).getText().contains("BCA DIGITAL")==true);
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"buktiTransfer_btnKembaliBeranda");
        driver.findElement(pars.getbjectLocator("buktiTransfer_btnKembaliBeranda")).click();
    }

    @When("^Go to halaman mutasi \"([^\"]*)\"$")
    public void go_to_halaman_mutasi(String Keterangan) throws Throwable {
        StepLib.swipeLeft();
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"riwayat_lblLihatSemua");
        driver.findElement(pars.getbjectLocator("riwayat_lblLihatSemua")).click();
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"riwayat_lblRow1");
        if(Keterangan.equals("sumber")){
            if(glbVarString.get("varGlbKonBiayaAdmin").equals("Gratis") || glbVarBoolean.get("varGlbBluRewards")==true){
                glbVarBoolean.put("varGlbRowTransferSumberExist",driver.findElement(pars.getbjectLocator("riwayat_lblRow1")).getText().contains("Transfer ke")==true);
                driver.findElement(pars.getbjectLocator("riwayat_lblRow1")).click();
                waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("buktiTransfer_lblJumalh"))));
                FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
                StepLib.swipeBack();
            }else{
                glbVarBoolean.put("varGlbRowBiayaTransferSumberExist",driver.findElement(pars.getbjectLocator("riwayat_lblRow1")).getText().contains("Biaya Transfer ke")==true);
                driver.findElement(pars.getbjectLocator("riwayat_lblRow1")).click();
                waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("buktiTransfer_lblJumalh"))));
                FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
                StepLib.swipeBack();
                glbVarBoolean.put("varGlbRowTransferSumberExist",driver.findElement(pars.getbjectLocator("riwayat_lblRow2")).getText().contains("Transfer ke")==true);
                driver.findElement(pars.getbjectLocator("riwayat_lblRow2")).click();
                waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("buktiTransfer_lblJumalh"))));
                FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
                StepLib.swipeBack();
            }
        }else if(Keterangan.equals("tujuan")){
                glbVarBoolean.put("varGlbRowTransferTujuanExist",driver.findElement(pars.getbjectLocator("riwayat_lblRow1")).getText().contains("Dana Masuk")==true);
                driver.findElement(pars.getbjectLocator("riwayat_lblRow1")).click();
                waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("buktiTransfer_lblJumalh"))));
                FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
                StepLib.swipeBack();
        }
        waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("riwayat_lblRiwayatTrx"))));
        StepLib.swipeBack();
        waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("riwayat_lblLihatSemua"))));
        StepLib.swipeRight();
    }

    @When("^Go to notifikasi \"([^\"]*)\"$")
    public void go_to_notifikasi(String keterangan) throws Throwable {
        driver.findElement(pars.getbjectLocator("dashboard_lblNotif")).click();
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"notifikasi_lblRow1");
        if(keterangan.equals("sumber")) {
            glbVarBoolean.put("varGlbRowTransferSumberNotExist", driver.findElement(pars.getbjectLocator("notifikasi_lblRow1")).getText().contains("Mengirimkan Dana") == true);
        }else if(keterangan.equals("tujuan")){
            glbVarBoolean.put("varGlbRowTransferTujuanNotExist", driver.findElement(pars.getbjectLocator("notifikasi_lblRow1")).getText().contains("Menerima Dana") == true);
        }
        driver.findElement(pars.getbjectLocator("notifikasi_lblRow1")).click();
        waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("buktiTransfer_lblJumalh"))));
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
        StepLib.goToDashboard();
    }

    @When("^Go to halaman limit \"([^\"]*)\"$")
    public void go_to_halaman_limit(String keterangan) throws Throwable {
        driver.findElement(pars.getbjectLocator("dashboard_lblProfile")).click();
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"txtCari");
        driver.findElement(pars.getbjectLocator("txtCari")).sendKeys("Limit Transaksi");
        waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("pengaturan_lblLimit"))));
        driver.hideKeyboard();
        driver.findElement(pars.getbjectLocator("pengaturan_lblLimit")).click();

        if(keterangan.equals("awal")){
            glbVarString.put("varGlbAwalLimit",driver.findElement(pars.getbjectLocator("pengaturan_lblSisaLimit")).getText().split("Rp")[1]);
        }else if(keterangan.equals("akhir")){
            glbVarString.put("varGlbAkhirLimit",driver.findElement(pars.getbjectLocator("pengaturan_lblSisaLimit")).getText().split("Rp")[1]);
        }

        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"pengaturan_lblSisaLimit");
        StepLib.goToDashboard();
    }

    @When("^logout$")
    public void logout() throws Throwable {
        driver.findElement(pars.getbjectLocator("dashboard_lblProfile")).click();
        driver.findElement(pars.getbjectLocator("txtCari")).sendKeys("Keluar Aplikasi");
        driver.hideKeyboard();
        driver.findElement(pars.getbjectLocator("pengaturan_lblLogout")).click();
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"pengaturan_btnKeluar");
        driver.findElement(pars.getbjectLocator("pengaturan_btnKeluar")).click();
        waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("login_btnYukMulai"))));
    }


    //============================= THEN =============================

    @Then("^Tidak terdapat section Transaksi Favorit Terakhir$")
    public void tidak_terdapat_section_Transaksi_Favorit_Terakhir() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Boolean checkFav;
        try{
            checkFav = driver.findElement(pars.getbjectLocator("dashboard_lblBelumAdaFav")).isDisplayed();
        }catch (Exception e){
            checkFav = false;
        }
        assert checkFav==true;
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
        //throw new PendingException();
    }

    @Then("^Terdapat section Transaksi Favorit Terakhir :Gambar default icon transfer,Alias \\(jika ada\\)$")
    public void terdapat_section_Transaksi_Favorit_Terakhir_Gambar_default_icon_transfer_Alias_jika_ada() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Boolean checkFav;
        try{
            checkFav = driver.findElement(pars.getbjectLocator("dashboard_lblBelumAdaFav")).isDisplayed();
        }catch (Exception e){
            checkFav = false;
        }
        assert checkFav==false;
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum, "");
        //throw new PendingException();
    }


    @Then("^Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang,saldo tujuan bertambah$")
    public void check_Bukti_transaksi_Mutasi_limit_berkurang_notifikasi_saldo_sumber_berkurang_saldo_tujuan_bertambah() throws Throwable {

        //SALDO SUMBER BERKURANG
        Integer intSaldoHasil,intSaldoSebelum,intSaldoSesudah, intSaldoJumlah;
        intSaldoJumlah = Integer.parseInt(glbVarString.get("varGlbKonTotalTransfer").replace(".","").replace("Rp","").trim());
        intSaldoSebelum = Integer.parseInt(glbVarString.get("varGlbSaldoAwalSumber").replace(".","").trim());
        intSaldoSesudah = Integer.parseInt(glbVarString.get("varGlbSaldoAkhirSumber").replace(".","").trim());
        intSaldoHasil = intSaldoSebelum - intSaldoSesudah;


        //SALDO TUJUAN BERTAMBAH
        Integer intSaldoHasilTujuan,intSaldoSebelumTujuan,intSaldoSesudahTujuan, intSaldoJumlahTujuan;
        intSaldoJumlahTujuan = Integer.parseInt(glbVarString.get("varGlbKonTotalTransfer").replace(".","").replace("Rp","").trim());
        intSaldoSebelumTujuan = Integer.parseInt(glbVarString.get("varGlbSaldoAwalTujuan").replace(".","").trim());
        intSaldoSesudahTujuan = Integer.parseInt(glbVarString.get("varGlbSaldoAkhirTujuan").replace(".","").trim());
        intSaldoHasilTujuan = intSaldoSesudahTujuan - intSaldoSebelumTujuan;

        //LIMIT SUMBER BERKURANG
        Integer intSaldoHasilLimit, intSaldoSebelumLimit, intSaldoSesudahLimit, intSaldoJumlahLimit;
        intSaldoJumlahLimit = Integer.parseInt(glbVarString.get("varGlbKonTotalTransfer").replace(".", "").replace("Rp", "").trim());
        intSaldoSebelumLimit = Integer.parseInt(glbVarString.get("varGlbAwalLimit").replace(".", "").replace(" ","").trim());
        intSaldoSesudahLimit = Integer.parseInt(glbVarString.get("varGlbAkhirLimit").replace(".", "").replace(" ","").trim());
        intSaldoHasilLimit = intSaldoSebelumLimit - intSaldoSesudahLimit;


        //COMPARE
        //Saldo Sumber Berkurang
        assert intSaldoHasil.toString().equals(intSaldoJumlah.toString())==true;
        //Saldo Tujuan Bertambah
        assert intSaldoJumlahTujuan.toString().equals(intSaldoHasilTujuan.toString())==true;
        //Limit harian berkurang
        assert intSaldoJumlahLimit.toString().equals(intSaldoHasilLimit.toString())==true;
        //Bukti Transaksi
        assert glbVarString.get("varGlbBukTrxNoReff").equals("")==false;
        //Mutasi Sumber
        if(glbVarString.get("varGlbKonBiayaAdmin").equals("Gratis") || glbVarBoolean.get("varGlbBluRewards")==true) {
            assert glbVarBoolean.get("varGlbRowTransferSumberExist") == true;
        }else{
            assert glbVarBoolean.get("varGlbRowBiayaTransferSumberExist") == true;
            assert glbVarBoolean.get("varGlbRowTransferSumberExist") == true;
        }

    }


    @Then("^Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang$")
    public void check_Bukti_transaksi_Mutasi_limit_berkurang_notifikasi_saldo_sumber_berkurang() throws Throwable {

        //SALDO SUMBER BERKURANG
        Integer intSaldoHasil,intSaldoSebelum,intSaldoSesudah, intSaldoJumlah;
        intSaldoJumlah = Integer.parseInt(glbVarString.get("varGlbKonTotalTransfer").replace(".","").replace("Rp","").trim());
        intSaldoSebelum = Integer.parseInt(glbVarString.get("varGlbSaldoAwalSumber").replace(".","").trim());
        intSaldoSesudah = Integer.parseInt(glbVarString.get("varGlbSaldoAkhirSumber").replace(".","").trim());
        intSaldoHasil = intSaldoSebelum - intSaldoSesudah;


        //LIMIT SUMBER BERKURANG
        Integer intSaldoHasilLimit, intSaldoSebelumLimit, intSaldoSesudahLimit, intSaldoJumlahLimit;
        intSaldoJumlahLimit = Integer.parseInt(glbVarString.get("varGlbKonTotalTransfer").replace(".", "").replace("Rp", "").trim());
        intSaldoSebelumLimit = Integer.parseInt(glbVarString.get("varGlbAwalLimit").replace(".", "").replace(" ","").trim());
        intSaldoSesudahLimit = Integer.parseInt(glbVarString.get("varGlbAkhirLimit").replace(".", "").replace(" ","").trim());
        intSaldoHasilLimit = intSaldoSebelumLimit - intSaldoSesudahLimit;


        //COMPARE
        //Saldo Sumber Berkurang
        assert intSaldoHasil.toString().equals(intSaldoJumlah.toString())==true;
        //Limit harian berkurang
        assert intSaldoJumlahLimit.toString().equals(intSaldoHasilLimit.toString())==true;
        //Bukti Transaksi
        assert glbVarString.get("varGlbBukTrxNoReff").equals("")==false;
        //Mutasi Sumber
        if(glbVarString.get("varGlbKonBiayaAdmin").equals("Gratis") || glbVarBoolean.get("varGlbBluRewards")==true) {
            assert glbVarBoolean.get("varGlbRowTransferSumberExist") == true;
        }else{
            assert glbVarBoolean.get("varGlbRowBiayaTransferSumberExist") == true;
            assert glbVarBoolean.get("varGlbRowTransferSumberExist") == true;
        }

    }


    @Then("^Check Bukti transaksi,Mutasi,limit berkurang, notifikasi,saldo sumber berkurang,Rewards berkurang$")
    public void check_Bukti_transaksi_Mutasi_limit_berkurang_notifikasi_saldo_sumber_berkurang_rewards_berkurang() throws Throwable {

        //SALDO SUMBER BERKURANG
        Integer intSaldoHasil, intSaldoSebelum, intSaldoSesudah, intSaldoJumlah;
        intSaldoJumlah = Integer.parseInt(glbVarString.get("varGlbKonTotalTransfer").replace(".", "").replace("Rp", "").trim());
        intSaldoSebelum = Integer.parseInt(glbVarString.get("varGlbSaldoAwalSumber").replace(".", "").trim());
        intSaldoSesudah = Integer.parseInt(glbVarString.get("varGlbSaldoAkhirSumber").replace(".", "").trim());
        intSaldoHasil = intSaldoSebelum - intSaldoSesudah;


        //LIMIT SUMBER BERKURANG
        Integer intSaldoHasilLimit, intSaldoSebelumLimit, intSaldoSesudahLimit, intSaldoJumlahLimit;
        intSaldoJumlahLimit = Integer.parseInt(glbVarString.get("varGlbKonTotalTransfer").replace(".", "").replace("Rp", "").trim());
        intSaldoSebelumLimit = Integer.parseInt(glbVarString.get("varGlbAwalLimit").replace(".", "").replace(" ","").trim());
        intSaldoSesudahLimit = Integer.parseInt(glbVarString.get("varGlbAkhirLimit").replace(".", "").replace(" ","").trim());
        intSaldoHasilLimit = intSaldoSebelumLimit - intSaldoSesudahLimit;


        //COMPARE
        //Saldo Sumber Berkurang
        assert intSaldoHasil.toString().equals(intSaldoJumlah.toString()) == true;
        //Limit harian berkurang
        assert intSaldoJumlahLimit.toString().equals(intSaldoHasilLimit.toString()) == true;
        //Bukti Transaksi
        assert glbVarString.get("varGlbBukTrxNoReff").equals("") == false;
        //Mutasi Sumber
        if (glbVarString.get("varGlbKonBiayaAdmin").equals("Gratis") || glbVarBoolean.get("varGlbBluRewards") == true) {
            assert glbVarBoolean.get("varGlbRowTransferSumberExist") == true;
        } else {
            assert glbVarBoolean.get("varGlbRowBiayaTransferSumberExist") == true;
            assert glbVarBoolean.get("varGlbRowTransferSumberExist") == true;
        }

    }


    @Then("^Kembali ke Homescreen$")
    public void kembali_ke_homescreen() throws Throwable {
        assert driver.findElement(pars.getbjectLocator("dashboard_lblHighlight")).isDisplayed();
    }



}
