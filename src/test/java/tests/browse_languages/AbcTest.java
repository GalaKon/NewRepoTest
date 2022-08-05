package tests.browse_languages;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class AbcTest extends BaseTest {

    @Test
    public void testAmountOfBrowseLanguageCategories() {
        int expectedResult = 27;

        Assert.assertEquals(openBaseURL()
                .clickBrowseLanguagesMenu()
                .getAllSubmenu()
                .size(), expectedResult);
    }

    @Test
    public void testTableTitles() {
        String expectedTableTitles = "Language, Author, Date, Comments, Rate";

        Assert.assertEquals(openBaseURL()
                .clickBrowseLanguagesMenu()
                .getTitlesTable(), expectedTableTitles);
    }

    @Test
    public void testAllNamesOfSubmenu() {

        final String expectedResultAllNamesOfSubmenu = "0-9ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Assert.assertEquals(openBaseURL()
                .clickBrowseLanguagesMenu()
                .getAllNamesOfSubmenu(), expectedResultAllNamesOfSubmenu);
    }

    @Test
    public void testZeroNineSubmenuText() {
        final String expectedTextZeroNineSubmenu = "0-9";

        Assert.assertEquals(openBaseURL()
                .clickBrowseLanguagesMenu()
                .getZeroSubmenuText(), expectedTextZeroNineSubmenu);
    }

    @Test
    public void testZeroSubmenuLinkText() {
        final String expectedLinkTextZeroSubmenu = "http://www.99-bottles-of-beer.net/0.html";

        Assert.assertEquals(openBaseURL()
                .clickBrowseLanguagesMenu()
                .getZeroSubmenu()
                .getAttribute("href"), expectedLinkTextZeroSubmenu);
    }
}