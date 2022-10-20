package org.mja123.appiumPractice.android.externalApp;

import org.mja123.appiumPractice.BaseTest;
import org.mja123.appiumPractice.android.ApiDemo.view.EViews;
import org.mja123.appiumPractice.android.ApiDemo.view.ViewPage;
import org.mja123.appiumPractice.android.ApiDemo.homepage.EHomeOptions;
import org.mja123.appiumPractice.android.ApiDemo.homepage.HomePage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.testng.Assert;
import org.testng.annotations.*;

public class ScrollTest extends BaseTest {

    @Test
    public void scrollWithUiScrollableToElement() throws ElementNotFound {

        HomePage homePage = new HomePage(driver);

        ViewPage viewPage =  (ViewPage) homePage.selectView(EHomeOptions.VIEW);

        viewPage.scrollToElementUiScrollable("TextClock");
    }

    @Test(groups = "scrolling")
    public void searchElementWithOutScroll() throws ElementNotFound {
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectView(EHomeOptions.VIEW);

        viewPage.selectView(EViews.DRAG_DROP);

    }
    @Test(groups = "scrolling")
    public void searchElementScrolling() throws ElementNotFound {
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectView(EHomeOptions.VIEW);

        viewPage.selectView(EViews.WEB_VIEW);
    }
    @Test(expectedExceptions = ElementNotFound.class,
    groups = "scrolling")
    public void searchNonexistentElement() throws ElementNotFound {
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectView(EHomeOptions.VIEW);

        viewPage.selectView(EViews.FAKE_ELEMENT);
    }


}
