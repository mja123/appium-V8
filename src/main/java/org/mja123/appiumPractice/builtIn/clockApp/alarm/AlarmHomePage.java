package org.mja123.appiumPractice.builtIn.clockApp.alarm;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import org.mja123.appiumPractice.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class AlarmHomePage extends BasePage {

    @FindBy(className = "android.widget.TextView")
    private WebElement alarm;
    @FindBy(id = "fab")
    private WebElement addAlarm;
    //modify
    @FindBy(id = "android.widget.RadialTimePickerView$RadialPickerTouchHelper")
    private List<WebElement> hours;

    public AlarmHomePage(AppiumDriver driver) {
        super(driver);
    }


}
