package configadvanced;

import config.ConfigurationScheduler;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigAdvanced {
    protected static AppiumDriver<MobileElement> driver;



    @BeforeSuite
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nex");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.0");
        capabilities.setCapability("appPackage", "com.h6ah4i.android.example.advrecyclerview");
        capabilities.setCapability("appActivity", ".launcher.MainActivity");

        capabilities.setCapability("automationName", "Appium");
        // capabilities.setCapability("app","/Tools/v.0.0.3.apk");

        driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

    }


    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}