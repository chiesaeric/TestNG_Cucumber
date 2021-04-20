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
public class SavingStepDef extends RunneriOS {


    public IOSDriver driver = this.connection;
    public ReadObject pars = this.parser;
    public WebDriverWait waits = this.wait;
    public String capturePath = RunneriOS.capturePath;
    public String featureName = RunneriOS.currentFeature;

    //============================= GIVEN ============================

    @Given("^Berada di halaman Saving Account dengan login akun \"([^\"]*)\" password \"([^\"]*)\"$")
    public void berada_di_halaman_Saving_Account_dengan_login_akun_password(String username, String password) throws InterruptedException {
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
        waits.until(ExpectedConditions.visibilityOf(driver.findElement(pars.getbjectLocator("dashboard_lblHighlight"))));

    }

    //============================= WHEN =============================

    @When("^Klik bluSavingCard$")
    public void klik_bluSavingCard() throws InterruptedException {
        StepLib.swipeRight();
        driver.findElement(pars.getbjectLocator("bluSaving_btnLihatSemua")).click();
    }

    @When("^Klik tombol Tambah bluSaving$")
    public void klik_tombol_tambah_bluSaving() throws InterruptedException {
        StepLib.scrollDown();
        driver.findElement(pars.getbjectLocator("bluSaving_btnTambah")).click();
    }



    @Then("^Tampil halaman daftar bluSaving$")
    public void tampil_halaman_daftar_bluSaving_terdapat() throws Exception {
        Boolean checkTitle,checkTotalDana,checkTambah;
        try{
            checkTitle = driver.findElement(pars.getbjectLocator("bluSaving_lblTitle")).isDisplayed();
        }catch (Exception e){
            checkTitle = false;
        }

        try{
            checkTotalDana = driver.findElement(pars.getbjectLocator("bluSaving_lblTotalDana")).isDisplayed();
        }catch (Exception e){
            checkTotalDana = false;
        }



        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");

        assert checkTitle == true;
        assert checkTotalDana == true;

    }


    @Then("^Tampil halaman daftar bluSaving penuh$")
    public void tampil_halaman_daftar_bluSaving_terdapat_penuh() throws Exception {
        Boolean checkTitle,checkTotalDana,checkPenuh;
        try{
            checkTitle = driver.findElement(pars.getbjectLocator("bluSaving_lblTitle")).isDisplayed();
        }catch (Exception e){
            checkTitle = false;
        }

        try{
            checkTotalDana = driver.findElement(pars.getbjectLocator("bluSaving_lblTotalDana")).isDisplayed();
        }catch (Exception e){
            checkTotalDana = false;
        }

        try{
            checkPenuh = driver.findElement(pars.getbjectLocator("bluSaving_lblPenuh")).isDisplayed();
        }catch (Exception e){
            checkPenuh = false;
        }



        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");

        assert checkTitle == true;
        assert checkTotalDana == true;
        assert checkPenuh == true;

    }


    @Then("^Tampil halaman tambah bluSaving$")
    public void tampil_halaman_tambah_bluSaving() throws Exception {
     //Masih kosong
    }


}
