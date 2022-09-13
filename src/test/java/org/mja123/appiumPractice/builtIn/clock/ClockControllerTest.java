package org.mja123.appiumPractice.builtIn.clock;

import org.mja123.appiumPractice.BaseAndroidTest;
import org.mja123.appiumPractice.builtIn.clockApp.clock.ClockHomePage;
import org.mja123.appiumPractice.builtIn.clockApp.component.EHeaderOptions;
import org.mja123.appiumPractice.builtIn.clockApp.component.ElementNotFound;
import org.mja123.appiumPractice.builtIn.clockApp.component.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Calendar;

public class ClockControllerTest extends BaseAndroidTest {
    @Test(groups = {"builtInApp"})
    public void accessToAlarmController() throws ElementNotFound {
        Header header = new Header(driver);

        ClockHomePage clockPage = (ClockHomePage) header.selectOption(EHeaderOptions.CLOCK);

        String partOfDay = Calendar.AM == 0 ? "AM" : "PM";
        String currentTime = Calendar.HOUR + ":" + Calendar.MINUTE + partOfDay;

        Assert.assertEquals(clockPage.getTime().getText(), currentTime);
    }
}
