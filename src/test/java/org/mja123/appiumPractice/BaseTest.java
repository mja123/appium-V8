package org.mja123.appiumPractice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AppiumDriver driver;

    @Parameters({"platformName", "automationName", "platformVersion", "deviceName", "app", "packageActivity"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("Android") String platformName, @Optional("UiAutomator2") String automationName,
                      @Optional("12.0") String platformVersion,
                      @Optional("Android Emulator")  String deviceName,
                      @Optional("com.google.android.deskclock")  String app,
                      @Optional("com.android.deskclock.DeskClock") String packageActivity) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", platformName);
        capabilities.setCapability("automationName", automationName);
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        System.out.println("times");

        if (packageActivity.equals("")) {
            capabilities.setCapability("app", System.getProperty("user.dir") + app);
        } else {
            capabilities.setCapability("appPackage", app);
            capabilities.setCapability("appActivity", packageActivity);
        }

        if (platformName.equals("Android")) {
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        } else {
            driver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
