package org.mja123.appiumPractice.builtIn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import org.mja123.appiumPractice.BasePage;

import java.util.List;

public class Clock extends BasePage {

    @AndroidBy(className = "android.widget.TextView")
    private MobileElement alarm;
    @AndroidBy(id = "fab")
    private MobileElement addAlarm;
    //modify
    @AndroidBy(id = "android.widget.RadialTimePickerView$RadialPickerTouchHelper")
    private List<MobileElement> hours;



    public Clock(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


}
