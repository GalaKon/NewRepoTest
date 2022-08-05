package tests.main;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.browse_languages.letters.APage;
import pages.start.StartPage;
import runner.BaseTest;
import tests.TestData;

import java.net.URL;

public class NavigationTest extends BaseTest {

    @Test(
            priority = 1,
            dataProviderClass = TestData.class,
            dataProvider = "MainPageTestData"
    )

    public void testFootersNavigationToURLAndReturnBackFromBaseURL(
            int index, String footerName, String footerLink, String footerTitle
    ){
        MainPage main = openBaseURL();
        String baseLink = getDriver().getCurrentUrl();
        String baseTitle = getDriver().getTitle();

        main.clickLink(index);
        String newLink = getDriver().getCurrentUrl();
        String newTitle = getDriver().getTitle();

        if (baseTitle.equals(newTitle)) {
            Assert.assertEquals(newLink, baseLink);
        } else {
            Assert.assertNotEquals(newLink, baseLink, "<<<New URL equals previous URL, probably we clicked on the same menu>>>");
        }
        Assert.assertEquals(newLink, footerLink);

        getDriver().navigate().back();
        String goBackLink = getDriver().getCurrentUrl();

        Assert.assertNotEquals(newLink, goBackLink);
        if (baseTitle.equals(newTitle)) {
            Assert.assertNotEquals(goBackLink, baseLink);
        } else {
            Assert.assertEquals(goBackLink, baseLink);
        }
    }

    @Test(
            priority = 2,
            dataProviderClass = TestData.class,
            dataProvider = "StartPageTestData"
    )
    public void testMenuStartNavigation(String oldCurrentUrl) {
        StartPage start = new StartPage(getDriver());

        WebElement oldStartMenu = openBaseURL().getStartMenu();
        WebElement sameStartMenu = start.getStartMenu();

        Assert.assertEquals(oldStartMenu, sameStartMenu);

        start.clickStartMenu();
        String newCurrentUrl = getDriver().getCurrentUrl();

        Assert.assertEquals(newCurrentUrl, oldCurrentUrl);

        WebElement newStartMenuAfterClick = start.getStartMenu();

        Assert.assertNotEquals(oldStartMenu, newStartMenuAfterClick);
    }

    @Test
    public void testZeroSubmenuURL() {
        final String URLEndPoint = "0.html";

        String currentUrl =
                openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickZeroSubmenu()
                .getURL();

        APage a = new APage(getDriver());

        Assert.assertTrue(a.getZeroSubmenu().isEnabled());
        Assert.assertTrue(a.getZeroSubmenu().isDisplayed());
        Assert.assertTrue(currentUrl.contains(URLEndPoint));
    }

    @Test
    public void testMenuSubmitNewLanguageNavigation() {
        openBaseURL()
                .clickSubmitNewLanguageMenu();

        Assert.assertFalse(getDriver().getPageSource().isEmpty());
        Assert.assertTrue(getDriver().getCurrentUrl().contains("submitnewlanguage"));
   }

    @Test
    public void testMenuStartLinkText() {
        final String expectedMenuStartLinkText = "http://www.99-bottles-of-beer.net/";

        String actualMenuStartLinkText =
                openBaseURL()
                        .getStartMenu()
                        .getAttribute("href");

        Assert.assertEquals(actualMenuStartLinkText, expectedMenuStartLinkText);
    }

    @Test
    public void testMenuAbcText() {
        final String expectedMenuAbcText = "Browse Languages".toUpperCase();

        String actualMenuAbcText =
                openBaseURL()
                        .getABCMenu()
                        .getText();

        Assert.assertEquals(actualMenuAbcText, expectedMenuAbcText);
    }

    @Test
    public void testMenuAbcLinkText() {
        final String expectedMenuAbcLinkText = "http://www.99-bottles-of-beer.net/abc.html";

        String actualMenuAbcLinkText =
                openBaseURL()
                        .getABCMenu()
                        .getAttribute("href");

        Assert.assertEquals(actualMenuAbcLinkText, expectedMenuAbcLinkText);
    }

    @Test
    public void testMenuAbcNavigation() {
        final String expectedMenuAbcNavigation = "http://www.99-bottles-of-beer.net/abc.html";

        openBaseURL()
                .clickBrowseLanguagesMenu();

        Assert.assertFalse(getDriver().getPageSource().isEmpty());
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedMenuAbcNavigation);
    }

    @Test
    public void testMenuSearchText() {
        final String expectedMenuSearchText = "Search Languages".toUpperCase();

        Assert.assertEquals(openBaseURL()
                .getSearchMenu()
                .getText(), expectedMenuSearchText);
    }

    @Test
    public void testMenuSearchLinkText() {
        final String expectedMenuSearchLinkText = "http://www.99-bottles-of-beer.net/search.html";

        Assert.assertEquals(openBaseURL()
                .getSearchMenu()
                .getAttribute("href"), expectedMenuSearchLinkText);
    }

    @Test
    public void testMenuSearchNavigation() {
        final String expectedMenuSearchNavigation = "http://www.99-bottles-of-beer.net/search.html";

        openBaseURL()
                .clickSearchLanguagesMenu();

        Assert.assertFalse(getDriver().getPageSource().isEmpty());
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedMenuSearchNavigation);
    }

    @Test
    public void testMenuTopListText() {
        final String expectedMenuTopListText = "Top Lists".toUpperCase();

        Assert.assertEquals(openBaseURL()
                .getTopListMenu()
                .getText(), expectedMenuTopListText);
    }

    @Test
    public void testMenuTopListLinkText() {
        final String expectedMenuTopListLinkText = "http://www.99-bottles-of-beer.net/toplist.html";

        Assert.assertEquals(openBaseURL()
                .getTopListMenu()
                .getAttribute("href"), expectedMenuTopListLinkText);
    }

    @Test
    public void testMenuTopListNavigation() {
        final String expectedMenuTopListNavigation = "http://www.99-bottles-of-beer.net/toplist.html";

        openBaseURL()
                .clickTopListsMenu();

        Assert.assertFalse(getDriver().getPageSource().isEmpty());
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedMenuTopListNavigation);
    }

    @Test
    public void testMenuGuestbookV2Text() {
        final String expectedMenuGuestbookV2Text = "Guestbook".toUpperCase();

        Assert.assertEquals(openBaseURL()
                .getGuestbookV2Menu()
                .getText(), expectedMenuGuestbookV2Text);
    }

    @Test
    public void testMenuGuestbookV2LinkText() {
        final String expectedMenuGuestbookV2LinkText = "http://www.99-bottles-of-beer.net/guestbookv2.html";

        Assert.assertEquals(openBaseURL()
                .getGuestbookV2Menu()
                .getAttribute("href"), expectedMenuGuestbookV2LinkText);
    }

    @Test
    public void testMenuGuestbookV2Navigation() {
        final String expectedMenuGuestbookV2Navigation = "guestbookv2.html";

        openBaseURL().clickGuestbookV2Menu();

        Assert.assertTrue(getDriver()
                .getCurrentUrl()
                .contains(expectedMenuGuestbookV2Navigation));
    }

    @Test
    public void testClickabilityOfTeamPageLsLaNetLink() {

        String expectedTeamPageLsLaNetLink = "http://www.ls-la.net/";

        openBaseURL()
                .clickStartMenu()
                .clickTeamSubmenu()
                .clickOliverSchadeWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedTeamPageLsLaNetLink);
    }

    @Test
    public void testClickabilityOfTeamPageETasteOrgLink() {

        String expectedTeamPageETasteOrgLink = "http://www.e-taste.org/";

        openBaseURL()
                .clickStartMenu()
                .clickTeamSubmenu()
                .clickGregorScheithauerWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedTeamPageETasteOrgLink);
    }

    @Test
    public void testClickabilityOfTeamPageStsSynfloodDeLink() {
        final String expectedTeamPageStsSynfloodDeLink = "http://sts.synflood.de/";

        openBaseURL()
                .clickStartMenu()
                .clickTeamSubmenu()
                .clickStefanSchelerWebsiteLink();

        Assert.assertEquals(getExternalPageURL(), expectedTeamPageStsSynfloodDeLink);
    }
}