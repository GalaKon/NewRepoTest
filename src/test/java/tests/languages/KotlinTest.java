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
    public void testSwitchFromKotlinLanguagePageToRedditLogInPageWithDataProv(String title) {

        openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickKotlin();

        KotlinPage kp = new KotlinPage(getDriver());

        Assert.assertEquals(title, kp.clickRedditIcon().getTitle());
    }

    @Test
    public void testSwitchFromKotlinLanguagePageToRedditLogInPageWithGeneric(){

        final String KOTLIN_LANGUAGE = "Kotlin";

        final String expectedSwitchToLoginPageReddit = "reddit.com: Log in";

        String actualSwitchToLoginPageReddit = openBaseURL()
                .clickBrowseLanguagesMenu()
                .clickKSubmenu()
                .clickLanguage(KOTLIN_LANGUAGE)
                .clickRedditIcon()
                .getTitle();

        Assert.assertEquals(actualSwitchToLoginPageReddit, expectedSwitchToLoginPageReddit);
    }
}
