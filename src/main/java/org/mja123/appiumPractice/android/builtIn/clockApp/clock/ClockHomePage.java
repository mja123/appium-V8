package org.mja123.appiumPractice.android.builtIn.clockApp.clock;

import io.appium.java_client.AppiumDriver;

import org.mja123.appiumPractice.android.BasePage;
import org.mja123.appiumPractice.android.builtIn.clockApp.component.Header;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClockHomePage extends BasePage {

    @FindBy(className = "android.widget.LinearLayout")
    private Header header;
    @FindBy(id = "date")
    private WebElement date;
    @FindBy(id = "digital_clock")
    private WebElement time;
    public ClockHomePage(AppiumDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }


    public WebElement getTime() {
        return time;
    }

    public void setTime(WebElement time) {
        this.time = time;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public WebElement getDate() {
        return date;
    }

    public void setDate(WebElement date) {
        this.date = date;
    }
}
