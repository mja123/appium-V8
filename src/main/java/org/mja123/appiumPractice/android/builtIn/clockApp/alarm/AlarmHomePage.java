package org.mja123.appiumPractice.android.builtIn.clockApp.alarm;

import io.appium.java_client.AppiumDriver;
import org.mja123.appiumPractice.android.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class AlarmHomePage extends BasePage {

    @FindBy(className = "android.view.ViewGroup")
    private List<WebElement> alarmActiveSwitch;
    @FindBy(id = "fab")
    private WebElement addAlarm;
    //modify
    @FindBy(id = "android.widget.RadialTimePickerView$RadialPickerTouchHelper")
    private List<WebElement> hours;

    public AlarmHomePage(AppiumDriver driver) {
        super(driver);
    }

    public List<WebElement> getAlarmActiveSwitch() {
        return alarmActiveSwitch;
    }
}
