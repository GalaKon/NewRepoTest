package tests.browse_languages.letters;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class ZeroTest extends BaseTest {

    @Test
    public void testH2MainBrowseLanguagesText() {
        final String expectedH2MainText = "Category 0-9";

        Assert.assertEquals(openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickZeroSubmenu()
                .getH2MainText(), expectedH2MainText);
    }

    @Test
    public void testNumberOfZeroSubmenuLanguages() {
        final int expectedNumberOfLanguages = 10;

        Assert.assertEquals(openBaseURL().
                clickBrowseLanguagesMenu()
                .clickZeroSubmenu()
                .getCountTDLinks(), expectedNumberOfLanguages);
    }
}
