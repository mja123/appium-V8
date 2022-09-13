package org.mja123.appiumPractice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseAndroidTest {
    public AppiumDriver driver;


//    @Parameters({"platformVersion", "deviceName", "app"})
//    @BeforeSuite(groups = "apkApp")
//    public void setUpApkApp(String platformVersion, String deviceName, String app) throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("platformVersion", platformVersion);
//        capabilities.setCapability("deviceName", deviceName);
//        capabilities.setCapability("app", app);
//        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
//    }

    @Parameters({"platformVersion", "deviceName", "appPackage", "packageActivity"})
    @BeforeSuite(groups = "builtInApp")
    public void setUpBuildInaPP(@Optional("12.0") String platformVersion,
    @Optional("Android Emulator")  String deviceName, @Optional("com.google.android.deskclock")  String appPackage,
    @Optional("com.android.deskclock.DeskClock") String packageActivity) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion", platformVersion);
        capabilities.setCapability("deviceName", deviceName);
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", packageActivity);
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

//TODO: CHANGE ACCESS MODIFIER IN CLASSES INVOLVED IN CLOCKTEST AND LOOK THE DEPENDENCIES COMPABILITY