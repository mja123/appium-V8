package org.mja123.appiumPractice;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.ServerArgument;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    //protected AppiumDriver driver;
    protected AppiumDriver driver;
    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
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

        if (packageActivity.equals("")) {
            capabilities.setCapability("app", System.getProperty("user.dir") + app);
        } else {
            capabilities.setCapability("appPackage", app);
            capabilities.setCapability("appActivity", packageActivity);
        }

        LOGGER.info("Instantiating driver");
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

    //region managing Appium Server locally

//    private static AppiumDriverLocalService service;
//
//    static {
//        startAppiumServer();
//    }
//    @AfterSuite
//    public void tearDownServer() {
//        service.stop();
//    }
//
//    private static void startAppiumServer() {
//
//        AppiumServiceBuilder builder = new AppiumServiceBuilder();
//
//        ServerArgument argument = () -> "--base-path";
//        builder.withArgument(argument, "/wd/hub");
//
//        service = AppiumDriverLocalService.buildService(builder);
//
//        service.start();
//    }
    //endregion
}

