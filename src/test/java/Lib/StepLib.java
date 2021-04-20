package Lib;

import MyRunner.RunneriOS;
import MyRunner.TestRunner;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.windows.PressesKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StepLib extends RunneriOS {

    public static IOSDriver driver = connection;
    public static ReadObject pars = parser;
    public String capturePath = RunneriOS.capturePath;
    public String featureName = RunneriOS.currentFeature;


    public static void loginNoCapture(String nomor, String password) throws InterruptedException {
        driver.findElement(pars.getbjectLocator("login_btnYukMulai")).click();
        driver.findElement(pars.getbjectLocator("login_txtNoHp")).sendKeys(nomor);
        driver.findElement(pars.getbjectLocator("login_btnLanjut")).click();
        driver.findElement(pars.getbjectLocator("login_btnOtp")).click();
        driver.findElement(pars.getbjectLocator("PIN_btn1")).click();
        driver.findElement(pars.getbjectLocator("PIN_btn2")).click();
        driver.findElement(pars.getbjectLocator("PIN_btn3")).click();
        driver.findElement(pars.getbjectLocator("PIN_btn4")).click();
        driver.findElement(pars.getbjectLocator("login_txtPassword")).sendKeys(password);
        driver.findElement(pars.getbjectLocator("login_btnMasuk")).click();
    }

    public static void ExistingloginNoCapture() throws InterruptedException {
        driver.hideKeyboard();
        driver.findElement(pars.getbjectLocator("login_btnLoginDenganAkunLain")).click();
        driver.findElement(pars.getbjectLocator("login_btnLanjut")).click();
    }


    public static void goToOnBoarding() throws Exception {
        //Set implicity 3 sceond
        connection.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        try{
            driver.findElement(pars.getbjectLocator("login_btnYukMulai")).isDisplayed();
        }catch (Exception e){
            Boolean bolCheck = false;
            do{
                swipeBack();
                try{
                    driver.findElement(pars.getbjectLocator("login_btnYukMulai")).isDisplayed();
                    bolCheck = true;
                }catch (Exception ex){
                    bolCheck = false;
                }
            }while (bolCheck==false);
        }

        // set implicity normal
        connection.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void goToDashboard() throws Exception {
        //Set implicity 3 sceond
        connection.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        try{
            driver.findElement(pars.getbjectLocator("dashboard_lblHighlight")).isDisplayed();
        }catch (Exception e){
            Boolean bolCheck = false;
            do{
                swipeBack();
                try{
                    driver.findElement(pars.getbjectLocator("dashboard_lblHighlight")).isDisplayed();
                    bolCheck = true;
                }catch (Exception ex){
                    bolCheck = false;
                }
            }while (bolCheck==false);
        }

        // set implicity normal
        connection.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void swipeBack() throws InterruptedException {
        //SWIPING AREA
        Dimension windowSizePopBack = driver.manage().window().getSize();

        Integer widthPopBack = windowSizePopBack.getWidth();
        Integer heightPopBack = windowSizePopBack.getHeight();

        Integer xPopUpBack = widthPopBack/2+widthPopBack/3;
        Integer yPopUpBack = heightPopBack/2;


        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(0, yPopUpBack))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(xPopUpBack, yPopUpBack))
                .release().perform();
    }


    public static void swipeLeft() throws InterruptedException {
        //SWIPING AREA
        Dimension windowSizePopBack = driver.manage().window().getSize();

        Integer widthPopBack = windowSizePopBack.getWidth();
        Integer heightPopBack = windowSizePopBack.getHeight();

        Integer xPopUpBack = widthPopBack/2+widthPopBack/3;
        Integer yPopUpBack = heightPopBack/3;


        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(0, yPopUpBack))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(xPopUpBack, yPopUpBack))
                .release().perform();
    }

    public static void swipeRight() throws InterruptedException {
        //SWIPING AREA
        Dimension windowSizePopBack = driver.manage().window().getSize();

        Integer widthPopBack = windowSizePopBack.getWidth();
        Integer heightPopBack = windowSizePopBack.getHeight();

        Integer xPopUpBack = widthPopBack-(widthPopBack/2+widthPopBack/3);
        Integer yPopUpBack = heightPopBack-heightPopBack/3;


        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(widthPopBack, yPopUpBack))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(xPopUpBack, yPopUpBack))
                .release().perform();
    }


    public static void scrollUp() throws InterruptedException {
        Thread.sleep(500);
        //SWIPING AREA
        Dimension windowSizePopUp = driver.manage().window().getSize();

        Integer widthPopUp = windowSizePopUp.getWidth();
        Integer heightPopUp = windowSizePopUp.getHeight();

        //Bulan
        Integer xPopUp = (widthPopUp/3*2)-widthPopUp/5;
        Integer yPopUp = heightPopUp/2+heightPopUp/4;


        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(xPopUp, yPopUp))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(xPopUp, yPopUp+150))
                .release().perform();
    }

    public static void scrollDown() throws InterruptedException {
        Thread.sleep(500);
        //SWIPING AREA
        Dimension windowSizePopDown = driver.manage().window().getSize();

        Integer widthPopDown = windowSizePopDown.getWidth();
        Integer heightPopDown = windowSizePopDown.getHeight();

        //Bulan
        Integer xPopDown = (widthPopDown/3*2)-widthPopDown/5;
        Integer yPopDown = heightPopDown/2+heightPopDown/4;


        new TouchAction((PerformsTouchActions) driver)
                .press(PointOption.point(xPopDown, yPopDown))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(xPopDown, yPopDown-heightPopDown/2))
                .release().perform();
    }



    public static void pinTransaksi(String PIN) throws InterruptedException {

        switch (PIN){
            case "1":
                driver.findElement(pars.getbjectLocator("PIN_btn1")).click();
                break;
            case "2":
                driver.findElement(pars.getbjectLocator("PIN_btn2")).click();
                break;
            case "3":
                driver.findElement(pars.getbjectLocator("PIN_btn3")).click();
                break;
            case "4":
                driver.findElement(pars.getbjectLocator("PIN_btn4")).click();
                break;
            case "5":
                driver.findElement(pars.getbjectLocator("PIN_btn5")).click();
                break;
            case "6":
                driver.findElement(pars.getbjectLocator("PIN_btn6")).click();
                break;
            case "7":
                driver.findElement(pars.getbjectLocator("PIN_btn7")).click();
                break;
            case "8":
                driver.findElement(pars.getbjectLocator("PIN_btn8")).click();
                break;
            case "9":
                driver.findElement(pars.getbjectLocator("PIN_btn9")).click();
                break;
            case "0":
                driver.findElement(pars.getbjectLocator("PIN_btn0")).click();
                break;
        }

    }

    public static void pilihNamaBank(String namaBank) throws InterruptedException {
        tapNamaBank();
        driver.findElement(pars.getbjectLocator("popUp_txtCari")).sendKeys(namaBank);
        driver.hideKeyboard();
        driver.findElement(By.name(namaBank)).click();
    }

    public static void tapNamaBank() throws InterruptedException {
        //SWIPING AREA
        Dimension windowSizePopBack = driver.manage().window().getSize();

        Integer widthPopBack = windowSizePopBack.getWidth();
        Integer heightPopBack = windowSizePopBack.getHeight();

        Integer xPopUpBack = widthPopBack/3;
        Integer yPopUpBack = heightPopBack/4;

        (new TouchAction(driver)).tap(PointOption.point(xPopUpBack, yPopUpBack)).perform();
    }


    public static void tapNomorRekening() throws InterruptedException {
        //SWIPING AREA
        Dimension windowSizePopBack = driver.manage().window().getSize();

        Integer widthPopBack = windowSizePopBack.getWidth();
        Integer heightPopBack = windowSizePopBack.getHeight();

        Integer xPopUpBack = widthPopBack/2;
        Integer yPopUpBack = heightPopBack/4+87;

        (new TouchAction(driver)).tap(PointOption.point(43, yPopUpBack)).perform();
    }

}
