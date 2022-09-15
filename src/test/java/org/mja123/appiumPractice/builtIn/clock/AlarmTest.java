package org.mja123.appiumPractice.builtIn.clock;

import org.mja123.appiumPractice.BaseAndroidTest;
import org.mja123.appiumPractice.builtIn.clockApp.alarm.AlarmHomePage;
import org.mja123.appiumPractice.builtIn.clockApp.component.EHeaderOptions;
import org.mja123.appiumPractice.builtIn.clockApp.component.ElementNotFound;
import org.mja123.appiumPractice.builtIn.clockApp.component.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlarmTest extends BaseAndroidTest {

    @Test
    public void alarmCount() throws ElementNotFound {
        AlarmHomePage alarmPage = (AlarmHomePage) new Header(driver).selectOption(EHeaderOptions.ALARM);

        Assert.assertEquals(alarmPage.getAlarmActiveSwitch().size(), 2);
    }
}
