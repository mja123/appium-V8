package org.mja123.appiumPractice.android.externalApp;

import org.mja123.appiumPractice.BaseTest;
import org.mja123.appiumPractice.android.ApiDemo.view.DragAndDropPage;
import org.mja123.appiumPractice.android.ApiDemo.view.EViews;
import org.mja123.appiumPractice.android.ApiDemo.view.ViewPage;
import org.mja123.appiumPractice.android.ApiDemo.homepage.EHomeOptions;
import org.mja123.appiumPractice.android.ApiDemo.homepage.HomePage;
import org.mja123.appiumPractice.android.ApiDemo.view.WebViewPage;
import org.mja123.appiumPractice.android.ElementNotFound;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;

public class ScrollTest extends BaseTest {

    @Test(groups ="scrolling")
    public void searchElementWithOutScroll() throws ElementNotFound {
        LOGGER.info("Starting searchElementWithOutScroll");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        DragAndDropPage dragAndDropPage = (DragAndDropPage) viewPage.selectView(EViews.DRAG_DROP);

        Assert.assertNotNull(dragAndDropPage);

    }
    @Test(groups = { "scrolling", "regression" })
    public void searchElementScrolling() throws ElementNotFound {
        LOGGER.info("Starting searchElementScrolling");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);
        WebViewPage webViewPage = (WebViewPage) viewPage.selectView(EViews.WEB_VIEW);

        Assert.assertNotNull(webViewPage);

    }
    @Test(expectedExceptions = NoSuchElementException.class,
    groups = { "scrolling", "smoke" })
    public void searchNonexistentElement() throws ElementNotFound {
        LOGGER.info("Starting searchNonexistentElement");
        HomePage homePage = new HomePage(driver);

        ViewPage viewPage = (ViewPage) homePage.selectPage(EHomeOptions.VIEW);

        viewPage.selectView(EViews.FAKE_ELEMENT);
    }


}
