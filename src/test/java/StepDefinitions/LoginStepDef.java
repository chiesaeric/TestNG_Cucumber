package StepDefinitions;

import Lib.FunctionalLib;
import Lib.StepLib;
import Lib.ReadObject;
import MyRunner.RunneriOS;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.AfterStep;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class LoginStepDef extends RunneriOS {

    public IOSDriver driver = this.connection;
    public ReadObject pars = this.parser;
    public String capturePath = RunneriOS.capturePath;
    public String featureName = RunneriOS.currentFeature;



    //============================= GIVEN ============================

    @Given("^Berada dihalaman onboarding$")
    public void berada_dihalaman_onboarding() throws Throwable {
        intScenarioNum++;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        Boolean OTP = false;
        try{
            OTP = driver.findElement(pars.getbjectLocator("login_btnYukMulai")).isDisplayed();
        }catch (Exception e){
            OTP = false;
        }
        if(OTP==false){
            StepLib.goToOnBoarding();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^Berada dihalaman Nomor telpon$")
    public void berada_dihalaman_Nomor_telpon() throws Throwable {
       intScenarioNum++;
        StepLib.goToOnBoarding();
        driver.findElement(pars.getbjectLocator("login_btnYukMulai")).click();
        System.out.println(scenarios().length);
    }


    //============================= WHEN =============================

    @When("^Klik Tombol Yuk Mulai$")
    public void klik_Tombol_Yuk_Mulai() throws Throwable {
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"login_btnYukMulai");
        driver.findElement(pars.getbjectLocator("login_btnYukMulai")).click();

    }

    @When("^Input Nomor Handphone dengan nomor \"([^\"]*)\"$")
    public void input_Nomor_Handphone_dengan_nomor(String arg1) throws Throwable {
        driver.findElement(pars.getbjectLocator("login_txtNoHp")).sendKeys(arg1);
    }

    @When("^Klik lanjut$")
    public void klik_lanjut() throws Throwable {
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"login_btnLanjut");
        driver.findElement(pars.getbjectLocator("login_btnLanjut")).click();
    }


    //============================= THEN =============================

    @Then("^Tampil layar Login input nomor handphone\\.Terdapat : Kolom Nomor Handphone, Tombol Lanjut \\(default disable\\)$")
    public void tampil_layar_Login_input_nomor_handphone_Terdapat_Kolom_Nomor_Handphone_Tombol_Lanjut_default_disable() throws Throwable {
        Boolean check;
        try{
            check = driver.findElement(pars.getbjectLocator("login_btnLanjut")).isDisplayed();
        }catch (Exception e){
            check = false;
        }
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"login_btnLanjut");
        assert check==true;
    }


    @Then("^Berhasil melakukan input Nomor Handphone\\.Keyboard yang tampil adalah keyboard numeric\\.Tombol lanjut aktif$")
    public void berhasil_melakukan_input_Nomor_Handphone_Keyboard_yang_tampil_adalah_keyboard_numeric_Tombol_lanjut_aktif() throws Throwable {
        Boolean check;
        try{
            check = driver.findElement(pars.getbjectLocator("login_lblTitle")).isDisplayed();
        }catch (Exception e){
            check = false;
        }
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"login_lblTitle");
        assert check == true;
    }


    @Then("^Proses login dapat dilanjutkan$")
    public void proses_login_dapat_dilanjutkan() throws Throwable {
        Boolean check;
        try{
            check = driver.findElement(pars.getbjectLocator("login_btnOtp")).isDisplayed();
        }catch (Exception e){
            check = false;
        }
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
        assert check == true;
    }


    @Then("^Tidak dapat melanjutkan proses login\\.Tampil message :Harus diawali angka (\\d+) atau (\\d+) nih$")
    public void tidak_dapat_melanjutkan_proses_login_Tampil_message_Harus_diawali_angka_atau_nih(int arg1, int arg2) throws Throwable {
        Boolean check;
        try{
            check = driver.findElement(pars.getbjectLocator("login_lblAwal0/62")).isDisplayed();
        }catch (Exception e){
            check = false;
        }
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
        assert check == true;
    }


    @Then("^Tidak dapat melanjutkan proses login\\.Button \"([^\"]*)\" disabled$")
    public void tidak_dapat_melanjutkan_proses_login_Button_disabled(String arg1) throws Throwable {
        Boolean check;
        try{
            check = driver.findElement(pars.getbjectLocator("login_lblOkeMulai")).isDisplayed();
        }catch (Exception e){
            check = false;
        }
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
        assert check == true;
    }


    @Then("^Input selain numeric akan otomatis menghapus selain numeric$")
    public void input_selain_numeric_akan_otomatis_menghapus_selain_numeric() throws Throwable {
        Boolean check;
        try{
            check = driver.findElement(pars.getbjectLocator("login_lblOkeMulai")).isDisplayed();
        }catch (Exception e){
            check = false;
        }
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
        assert check == true;
    }

    @Then("^Tidak dapat melanjutkan proses login\\.Tampil message :Harus diisi minimum (\\d+) digit no\\. handphone nih$")
    public void tidak_dapat_melanjutkan_proses_login_Tampil_message_Harus_diisi_minimum_digit_no_handphone_nih(int arg1) throws Throwable {
        Boolean check;
        try{
            check = driver.findElement(pars.getbjectLocator("login_lblMinNoHp")).isDisplayed();
        }catch (Exception e){
            check = false;
        }
        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
        assert check == false;
    }


}
