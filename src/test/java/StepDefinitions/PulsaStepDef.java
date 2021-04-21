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

public class PulsaStepDef extends RunneriOS {

    public IOSDriver driver = this.connection;
    public ReadObject pars = this.parser;
    public String capturePath = RunneriOS.capturePath;
    public String featureName = RunneriOS.currentFeature;

//
//    //============================= GIVEN ============================
//
//    @Given("^Login Berada di halaman Home screen dengan login akun \"([^\"]*)\" password \"([^\"]*)\"$")
//    public void login_berada_di_halaman_Home_screen_dengan_login_akun(String username, String password) throws InterruptedException {
//        Boolean checkExist,checkOTP;
//        intScenarioNum++;
//        driver.resetApp();
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        try{
//            checkExist = driver.findElement(pars.getbjectLocator("login_btnLoginDenganAkunLain")).isDisplayed();
//        }catch (Exception e){
//            checkExist = false;
//        }
//        try{
//            checkOTP = driver.findElement(pars.getbjectLocator("login_btnOtp")).isDisplayed();
//        }catch (Exception e){
//            checkOTP = false;
//        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        if(checkExist==true){
//            StepLib.ExistingloginNoCapture();
//        }else if(checkOTP==true){
//            StepLib.swipeBack();
//        }
//        StepLib.loginNoCapture(username,password);
//
//    }
//
//    //============================= WHEN =============================
//
//
//    @When("^Go to homescreen saldo \"([^\"]*)\"$")
//    public void go_to_homescreen_saldo_awal(String keterangan) throws Throwable {
//        if(driver.findElement(pars.getbjectLocator("dashboard_lblSaldo")).getText().contains("●")){
//            driver.findElement(pars.getbjectLocator("dashboard_btnHidden")).click();
//        }
//        if(keterangan.equals("awal sumber")){
//            glbVarString.put("varGlbSaldoAwalSumber",driver.findElement(pars.getbjectLocator("dashboard_lblSaldo")).getText());
//        }else if(keterangan.equals("akhir sumber")){
//            glbVarString.put("varGlbSaldoAkhirSumber",driver.findElement(pars.getbjectLocator("dashboard_lblSaldo")).getText());
//        }else if(keterangan.equals("awal tujuan")){
//            glbVarString.put("varGlbSaldoAwalTujuan",driver.findElement(pars.getbjectLocator("dashboard_lblSaldo")).getText());
//        } else if(keterangan.equals("akhir tujuan")){
//            glbVarString.put("varGlbSaldoAkhirTujuan",driver.findElement(pars.getbjectLocator("dashboard_lblSaldo")).getText());
//        }
//
//        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
//    }
//
//
//    @When("^Check list favorit Home screen$")
//    public void check_list_favorit_Home_screen() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        driver.findElement(pars.getbjectLocator("dashboard_lblHighlight")).isDisplayed();
//        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"");
//        //throw new PendingException();
//    }
//
//    @When("^Klik Transaksi$")
//    public void klik_Transaksi() throws Throwable {
//        driver.findElement(pars.getbjectLocator("dashboard_btnTransaksi")).click();
//    }
//
//    @When("^Pilih Bayar/Beli$")
//    public void pilih_bayar_beli() throws Throwable {
//        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"dashboard_btnTransfer");
//        driver.findElement(pars.getbjectLocator("dashboard_btnBayarBeli")).click();
//    }
//
//    @When("^Pilih Pulsa$")
//    public void pilih_pulsa() throws Throwable {
//        driver.findElement(pars.getbjectLocator("txtCari")).sendKeys("Pulsa");
//        FunctionalLib.takeSnapShot(driver,capturePath,featureName,intScenarioNum,"bayarBeli_lblTitle");
//        driver.findElement(pars.getbjectLocator("dashboard_btnBayarBeli")).click();
//    }
//

}
