package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.search_languages.SearchPage;
import pages.submit_new_language.SubmitNewLanguagePage;
import runner.BaseTest;
import runner.CaptureNetworkTraffic;

import java.util.List;

public class APITest extends BaseTest {

    @Test
    public void testRequestSearchCriteria() {

        final String searchCriteria = "java";

        SearchPage search = openBaseURL()
                .clickSearchLanguagesMenu()
                .enterTextSearchField(searchCriteria);

        CaptureNetworkTraffic cnt = new CaptureNetworkTraffic();

        cnt.setUpDevTools(getDriver());
        List<String> requests = cnt.captureHttpSearchLanguagesPageRequests();

        search.clickSubmitSearchButton();

        Assert.assertFalse(requests.size() < 1);
        Assert.assertEquals(requests.get(0), "POST");
        Assert.assertTrue(requests.get(1).contains("http://www.99-bottles-of-beer.net"));
        Assert.assertEquals(requests.get(2), "Optional[search=" + searchCriteria + "&submitsearch=GO]");
        Assert.assertEquals(requests.get(3), "Optional.empty");
    }

    @Test
    public void testResponseSearchCriteria() {

        final String searchCriteria = "java";

        SearchPage search = openBaseURL()
                .clickSearchLanguagesMenu()
                .enterTextSearchField(searchCriteria);

        CaptureNetworkTraffic cnt = new CaptureNetworkTraffic();

        cnt.setUpDevTools(getDriver());
        List<String> responses = cnt.captureHttpSearchLanguagesPageResponses();

        search.clickSubmitSearchButton();

        Assert.assertFalse(responses.size() < 1);
        Assert.assertEquals(responses.get(0), "200");
        Assert.assertEquals(responses.get(1), "OK");
        Assert.assertEquals(responses.get(2), "http://www.99-bottles-of-beer.net/search.html");
    }

    @Test
    public void testRequestSubmitLanguage() {

        final String securityCode = "5555";

        SubmitNewLanguagePage submit = openBaseURL()
                .clickSubmitNewLanguageMenu()
                .fillSecurityCode();

        CaptureNetworkTraffic cnt = new CaptureNetworkTraffic();

        cnt.setUpDevTools(getDriver());
        List<String> requests = cnt.captureHttpSubmitNewLanguagePageRequests();

        submit.clickButtonSubmitLanguage();

        Assert.assertFalse(requests.size() < 1);
        Assert.assertEquals(requests.get(0), "POST");
        Assert.assertTrue(requests.get(1).contains("http://www.99-bottles-of-beer.net"));
        Assert.assertEquals(requests.get(2), "Optional[language=&descriptor=&url=https%3A%2F%2F&author=&email=&" +
                "homepage=https%3A%2F%2F&captcha=" + securityCode + "&category=1&code=&teammsg=&submitlanguage=" +
                "Submit+Language]");
        Assert.assertEquals(requests.get(3), "Optional.empty");
    }

    @Test
    public void testResponseSubmitLanguage() {

        SubmitNewLanguagePage submit = openBaseURL()
                .clickSubmitNewLanguageMenu()
                .fillSecurityCode();

        CaptureNetworkTraffic cnt = new CaptureNetworkTraffic();

        cnt.setUpDevTools(getDriver());
        List<String> response = cnt.captureHttpSubmitNewLanguagePageResponses();

        submit.clickButtonSubmitLanguage();

        Assert.assertFalse(response.size() < 1);
        Assert.assertEquals(response.get(0), "200");
        Assert.assertEquals(response.get(1), "OK");
        Assert.assertEquals(response.get(2), "http://www.99-bottles-of-beer.net/submitnewlanguage.html");
    }
}
