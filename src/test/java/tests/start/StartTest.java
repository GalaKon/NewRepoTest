package tests.start;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class StartTest extends BaseTest {

    @Test
    public void testMenuStartText() {
        final String expectedMenuStartText = "Start";

        Assert.assertEquals(openBaseURL()
                .getStartMenu()
                .getText(), expectedMenuStartText.toUpperCase());
    }

    @Test
    public void testInfoSubmenuText() {
        final String expectedInfoSubmenuText = "History";

        Assert.assertEquals(openBaseURL()
                .getText(openBaseURL()
                .clickStartMenu()
                .getInfoSubmenu()), expectedInfoSubmenuText);
    }

    @Test
    public void testInfoSubmenuLinkText() {
        final String expectedInfoSubmenuLinkText = "http://www.99-bottles-of-beer.net/info.html";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .getInfoSubmenu()
                .getAttribute("href"), expectedInfoSubmenuLinkText);
    }

    @Test
    public void testH2Header() {

        final String expectedH2Header = "Welcome to 99 Bottles of Beer";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .getH2MainText(), expectedH2Header);
    }

    @Test
    public void testHistoricInformationLinkText() {
        final String expectedHistoricInformationLinkText = "historic information";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .getHistoricInformationLinkText(), expectedHistoricInformationLinkText);
    }

    @Test
    public void testHistoricInformationLink() {
        final String expectedHistoricInformationLinkTitle = "99 Bottles of Beer | Background and historic information";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .clickHistoricInformationLink()
                .getTitle(), expectedHistoricInformationLinkTitle);
    }

    @Test
    public void testHereLinkText() {
        final String expectedHereLinkText = "here";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .getHereLinkText(), expectedHereLinkText);
    }

    @Test
    public void testHereLink() {
        final String expectedHereLinkTitle = "99 Bottles of Beer | The lyrics to the song 99 Bottles of Beer";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .clickHereLink()
                .getTitle(), expectedHereLinkTitle);
    }

    @Test
    public void testSubmitYourOwnPieceOfCodeLinkText() {
        final String expectedSubmitYourOwnPieceOfCodeLinkText = "submit your own piece of code";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .getSubmitYourOwnPieceOfCodeLinkText(), expectedSubmitYourOwnPieceOfCodeLinkText);
    }

    @Test
    public void testSubmitYourOwnPieceOfCodeLink() {
        final String expectedSubmitYourOwnPieceOfCodeLinkTitle = "99 Bottles of Beer | Submit new Language";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .clickSubmitYourOwnPieceOfCodeLink()
                .getTitle(), expectedSubmitYourOwnPieceOfCodeLinkTitle);
    }

    @Test
    public void testGuestbookLinkText() {
        final String expectedGuestbookLinkText = "guestbook";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .getGuestbookLinkText(), expectedGuestbookLinkText);
    }

    @Test
    public void testGuestbookLink() {
        final String expectedGuestbookLinkTitle = "99 Bottles of Beer | Guestbook";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .clickGuestbookLink()
                .getTitle(), expectedGuestbookLinkTitle);
    }

    @Test
    public void testTeamMembersLinkText() {
        final String expectedTeamMembersLinkText = "team members";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .getTeamMembersLinkText(), expectedTeamMembersLinkText);
    }

    @Test
    public void testTeamMembersLink() {
        final String expectedTeamMembersLinkTitle = "99 Bottles of Beer | The Team";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .clickTeamMembersLink()
                .getTitle(), expectedTeamMembersLinkTitle);
    }

    @Test
    public void testLastParagraphText() {

        StringBuilder lastParagraph = new StringBuilder();
        lastParagraph
                .append("Have a lot of fun,\n")
                .append("Oliver, Gregor and Stefan");

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .getLastParagraphText(), lastParagraph.toString());
    }

    @Test
    public void testPrivacySubmenuText() {
        final String expectedPrivacySubmenuText = "Privacy";

        Assert.assertEquals(openBaseURL()
                .getPrivacySubmenuText(), expectedPrivacySubmenuText);
    }
}