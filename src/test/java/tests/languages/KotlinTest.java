package tests.languages;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.languages.KotlinPage;
import runner.BaseTest;
import tests.TestData;

public class KotlinTest extends BaseTest {

    @Test(
            dataProviderClass = TestData.class,
            dataProvider = "KotlinPageTestData"
    )
    public void testSwitchFromKotlinLanguagePageToRedditLogInPage(String title) {

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKotlin();

        KotlinPage kp = new KotlinPage(getDriver());

        Assert.assertEquals(title, kp.clickRedditIcon().getTitle());
    }
}
