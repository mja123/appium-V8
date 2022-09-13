package org.mja123.appiumPractice.builtIn.clockApp.alarm;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import org.mja123.appiumPractice.BasePage;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class AlarmHomePage extends BasePage {

    @AndroidBy(className = "android.widget.TextView")
    private RemoteWebElement alarm;
    @AndroidBy(id = "fab")
    private RemoteWebElement addAlarm;
    //modify
    @AndroidBy(id = "android.widget.RadialTimePickerView$RadialPickerTouchHelper")
    private List<RemoteWebElement> hours;



    public AlarmHomePage(AppiumDriver driver) {
        super(driver);
    }


}
