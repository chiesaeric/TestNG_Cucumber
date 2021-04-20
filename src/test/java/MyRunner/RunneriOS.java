package MyRunner;

import Lib.ReadObject;
import Lib.Report;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@CucumberOptions(
        features = {"src/test/resources/Features"},
        tags = {"@bluSaving"},
        glue= {"StepDefinitions"},
        plugin = { "pretty","html:target/cucumber-reports"}
)


public class RunneriOS extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;
    public static IOSDriver connection;
    public static WebDriverWait wait;
    public static ReadObject parser;
    public static String capturePath;
    public static String currentFeature;
    public static Integer intScenarioNum;
    public static HashMap<String,String> glbVarString = new HashMap<>();
    public static HashMap<String,Boolean> glbVarBoolean = new HashMap<>();


    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

        String now = LocalDate.now().toString();
        String[] strDateNow = LocalDateTime.now().toString().split("[.]");//(dtf.format(now).toString());
        String strDate = strDateNow[0].replace(":","-");
        //capturePath = "/Users/gdis/Documents/AutomationCapture/"+strDate;
        capturePath = "C:\\CaptureScreen\\BLUIOS"+strDate;
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @BeforeMethod
    @Parameters(value = { "bundleId", "platformVersion" , "xcodeOrgId" , "udid" })
    public void beforeMethod(String bundleId, String platformVersion, String xcodeOrgId, String udid) throws IOException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("udid", udid); //Give Device ID of your mobile phone
        capabilities.setCapability("bundleId", bundleId);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("noReset", "false");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("xcodeOrgId", xcodeOrgId);
        connection = new IOSDriver(new URL("http://10.121.8.99:4723/wd/hub"), capabilities);
        connection.manage().timeouts().implicitlyWait(18, TimeUnit.SECONDS);

        wait = new WebDriverWait(connection, 5);
        parser = new ReadObject(System.getProperty("user.dir")+"/src/test/java/objects/object.properties");
        intScenarioNum = 0;


    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        currentFeature = cucumberFeature.toString();
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }



    @AfterMethod
    public void afterMethod() throws IOException{
        String folderNameMethod = capturePath+"/"+currentFeature.replace(" ","_")+"/";
        Report.CreateWPExcel(folderNameMethod, currentFeature, "HORIZONTAL");
    }



    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        testNGCucumberRunner.finish();
    }
}
