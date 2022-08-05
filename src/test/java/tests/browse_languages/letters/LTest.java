package tests.browse_languages.letters;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class LTest extends BaseTest {

    @Test
    public void testCategoryLH2MainText() {
        final String expectedResult = "Category L";

        Assert.assertEquals(openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickLSubmenu()
                .getH2MainText(), expectedResult);
    }
}
