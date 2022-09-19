package org.mja123.appiumPractice.android.externalApp;

import org.mja123.appiumPractice.BaseTest;
import org.mja123.appiumPractice.android.ApiDemo.ViewPage;
import org.mja123.appiumPractice.android.ApiDemo.homepage.EViews;
import org.mja123.appiumPractice.android.ApiDemo.homepage.HomePage;
import org.mja123.appiumPractice.android.builtIn.clockApp.component.ElementNotFound;
import org.testng.annotations.Test;

public class ScrollTest extends BaseTest {

    @Test
    public void scrollWithDefinedDeltas() throws ElementNotFound {
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage =  (ViewPage) homePage.selectView(EViews.VIEW);

        viewPage.scrollToElement();
    }
}
