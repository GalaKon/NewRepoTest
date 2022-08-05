package tests.start;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeamTest extends BaseTest {

    @Test
    public void testH2TeamSubmenuText() {
        String expectedTextH2MainHeader = "The Team";

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .clickTeamSubmenu()
                .getH2MainText(), expectedTextH2MainHeader);
    }

    @Test
    public void testH3TeamNamesText() {
        List<String> expectedH3TeamNamesText = new ArrayList<>(
                Arrays.asList("Oliver Schade", "Gregor Scheithauer", "Stefan Scheler"));

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .clickTeamSubmenu()
                .getTeamNames(), expectedH3TeamNamesText);
    }

    @Test
    public void testAllLinksTeamPage() {

        List<String> expectedAllLinks = new ArrayList<>();
        expectedAllLinks.add("ls-la.net");
        expectedAllLinks.add("E-Taste.org");
        expectedAllLinks.add("sts.synflood.de");

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .clickTeamSubmenu()
                .getAllLinks(), expectedAllLinks);
    }

    @Test
    public void testTwoImagesOfTeamMembers() {
        int expectedTwoImagesOfTeamMembers = 2;

        Assert.assertEquals(openBaseURL()
                .clickStartMenu()
                .clickTeamSubmenu()
                .countAllImages(), expectedTwoImagesOfTeamMembers);
    }
}