package tests.submit_new_language;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;


public class SubmitNewLanguageTest extends BaseTest {

    @Test
    public void testMenuSubmitNewLanguageLinkText() {
        final String expectedLinkText = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";

        Assert.assertEquals(openBaseURL()
                .getSubmitNewLanguageMenu()
                .getAttribute("href"), expectedLinkText);
    }

    @Test
    public void testMenuSubmitNewLanguageText() {
        final String expectedMenuText = "Submit new Language".toLowerCase();

        Assert.assertEquals(openBaseURL()
                .getSubmitNewLanguageMenuText()
                .toLowerCase(), expectedMenuText);
    }

    @Test
    public void testSubmitNewLanguageTextViaFooter() {
        final String expectedTextViaFooter = "Submit New Language";

        Assert.assertEquals(openBaseURL()
                .clickFooterSubmitNewLanguage()
                .getTitleH2Text(), expectedTextViaFooter);
    }

    @Test
    public void testErrorMessageSubmitLanguageButton() {
        final String expectedResultErrorMessageSubmitLanguageButtonError = "Error: " +
                "Precondition failed - Incomplete Input.";

        Assert.assertEquals(openBaseURL()
                .clickSubmitNewLanguageMenu()
                .clickButtonSubmitLanguage()
                .getErrorMessageText(), expectedResultErrorMessageSubmitLanguageButtonError);
    }

    @Test
    public void testIncludesNewLanguageCategory() {

        final List<String> expectedIncludesNewLanguageCategory = new ArrayList<>();
        expectedIncludesNewLanguageCategory.add("real language");
        expectedIncludesNewLanguageCategory.add("esoteric language");
        expectedIncludesNewLanguageCategory.add("assembly language");

        Assert.assertEquals(openBaseURL()
                .clickSubmitNewLanguageMenu()
                .clickCategoryName()
                .getCategoryText(), expectedIncludesNewLanguageCategory);
    }

    @Test
    public void testErrorMessageInvalidSecCode() {

        final String expectedErrorMessageInvalidSecCode = "Error: Invalid security code.";

        Assert.assertEquals(openBaseURL()
                .clickSubmitNewLanguageMenu()
                .fillAuthorName()
                .fillLanguageName()
                .fillEmailName()
                .clickCategoryName()
                .clickCategoryAssemblyLanguage()
                .fillSecurityCode()
                .fillCodeName()
                .clickButtonSubmitLanguage()
                .getErrorMessageInvalidSecCodeText(), expectedErrorMessageInvalidSecCode);
    }

    @Test
    public void testAttributeSrcCaptcha() {

        final String expectedAttributeSrcCaptcha = "http://www.99-bottles-of-beer.net/captcha.php";

        Assert.assertEquals(openBaseURL()
                .clickSubmitNewLanguageMenu()
                .getAttributeSrcOfCaptcha(), expectedAttributeSrcCaptcha);
    }

    @Test
    public void testTextImportant() {

        final String expectedTextImportant = "IMPORTANT:";

        Assert.assertEquals(openBaseURL()
                .clickSubmitNewLanguageMenu()
                .getSpanImportant()
                .getText(), expectedTextImportant);
    }

    @Test
    public void testImportantTextBackgroundColor() {
        final String expectedBackgroundColor = "rgba(0, 0, 0, 0)";

        Assert.assertEquals(openBaseURL()
                .clickSubmitNewLanguageMenu()
                .getSpanImportant()
                .getCssValue("background-color"), expectedBackgroundColor);
    }

    @Test
    public void testImportantTextColor() {
        final String expectedTextColor = "rgba(255, 255, 255, 1)";

        Assert.assertEquals(openBaseURL()
                .clickSubmitNewLanguageMenu()
                .getSpanImportant()
                .getCssValue("color"), expectedTextColor);
    }

    @Test
    public void testImportantTextFont() {
        final String expectedTextFont = "700";

        Assert.assertEquals(openBaseURL()
                .clickSubmitNewLanguageMenu()
                .getSpanImportant()
                .getCssValue("font-weight"), expectedTextFont);
    }
}