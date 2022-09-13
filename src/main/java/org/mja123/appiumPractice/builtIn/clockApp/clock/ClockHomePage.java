package org.mja123.appiumPractice.builtIn.clockApp.clock;

import io.appium.java_client.AppiumDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.mja123.appiumPractice.BasePage;
import org.mja123.appiumPractice.builtIn.clockApp.component.Header;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

public class ClockHomePage extends BasePage {

    @AndroidFindBy(className = "android.widget.LinearLayout")
    public Header header;
    @AndroidFindBy(id = "digital_clock")
    public RemoteWebElement time;
    public ClockHomePage(AppiumDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }


    public RemoteWebElement getTime() {
        return time;
    }

    public void setTime(RemoteWebElement time) {
        this.time = time;
    }

    public void setHeader(Header header) {
        this.header = header;
    }
}
