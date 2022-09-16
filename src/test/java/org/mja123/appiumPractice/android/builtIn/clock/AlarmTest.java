package org.mja123.appiumPractice.android.builtIn.clock;

import org.mja123.appiumPractice.BaseTest;
import org.mja123.appiumPractice.android.builtIn.clockApp.alarm.AlarmHomePage;
import org.mja123.appiumPractice.android.builtIn.clockApp.component.EHeaderOptions;
import org.mja123.appiumPractice.android.builtIn.clockApp.component.ElementNotFound;
import org.mja123.appiumPractice.android.builtIn.clockApp.component.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlarmTest extends BaseTest {

    @Test
    public void alarmCount() throws ElementNotFound {
        AlarmHomePage alarmPage = (AlarmHomePage) new Header(driver).selectOption(EHeaderOptions.ALARM);

        Assert.assertEquals(alarmPage.getAlarmActiveSwitch().size(), 2);
    }
}
