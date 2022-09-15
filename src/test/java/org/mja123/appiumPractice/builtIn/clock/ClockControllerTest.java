package org.mja123.appiumPractice.builtIn.clock;

import org.mja123.appiumPractice.BaseAndroidTest;
import org.mja123.appiumPractice.builtIn.clock.dateUtils.DateFormat;
import org.mja123.appiumPractice.builtIn.clockApp.clock.ClockHomePage;
import org.mja123.appiumPractice.builtIn.clockApp.component.EHeaderOptions;
import org.mja123.appiumPractice.builtIn.clockApp.component.ElementNotFound;
import org.mja123.appiumPractice.builtIn.clockApp.component.Header;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.Calendar;
import java.util.TimeZone;

public class ClockControllerTest extends BaseAndroidTest {
    @Test(groups = {"builtInApp", "regression"})
    public void checkCurrentTime() throws ElementNotFound {
        Header header = new Header(driver);

        System.out.println(driver.toString() + "Asdfasd");
        ClockHomePage clockPage = (ClockHomePage) header.selectOption(EHeaderOptions.CLOCK);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));

        String currentTime = calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE);

        Assert.assertTrue(clockPage.getTime().getText().contains(currentTime));

//        String partOfDay = calendar.get(Calendar.ERA) == 0 ? "AM" : "PM";
//
//        String currentTime = calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + " " + partOfDay;
//        HSP word between minutes and partOfDay (I think it is a Hidden Station Problem)
//        Assert.assertEquals(clockPage.getTime().getText(), currentTime);
    }

    @Test(groups = {"builtInApp", "regression"})
    public void checkCurrentDate() throws ElementNotFound {
        Header header = new Header(driver);
        ClockHomePage clockPage = (ClockHomePage) header.selectOption(EHeaderOptions.CLOCK);

        Assert.assertEquals(clockPage.getDate().getText(), DateFormat.dateFormatter());

    }
}
