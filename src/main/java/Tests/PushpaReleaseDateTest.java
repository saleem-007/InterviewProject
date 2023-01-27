package Tests;

import Pages.ImdbPage;
import Pages.WikiPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PushpaReleaseDateTest extends BaseClass {
    ImdbPage imdb;
    WikiPage wikiPage;

    @BeforeClass
    public void setUp() {
        launchBrowser();
        imdb = new ImdbPage();
        wikiPage = new WikiPage();
    }

    @Test
    public void verifyThePushpaReleaseDateAndCountry() throws InterruptedException {
        enterURL(imdb.imdbPageURL);
        waitAndSendKeys(imdb.searchTextField, imdb.pushpaMovieName);
        waitAndClick(imdb.searchButton);
        String name = waitAndGetTheText(imdb.push1FirstResult);
        if (name.contains(imdb.pushpaTheRiseText)) {
            waitAndClick(imdb.push1FirstResult);
        }
        WebElement releaseDateElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(imdb.pushpaMovieReleaseDate)));
        String releaseDateElementText = releaseDateElement.getText();
        String pushpaReleaseDateInImdb = "";
        if (!releaseDateElementText.contains("India")) {
            clickOnDisabledElement(releaseDateElement);
        }
        try {
            if (element(imdb.imdbIndiaReleaseDate).isDisplayed()) {
                pushpaReleaseDateInImdb = waitAndGetTheText(imdb.imdbIndiaReleaseDate);
            }
        } catch (Exception e) {
            clickOnDisabledElement(element(imdb.seeMoreItemsButton));
            pushpaReleaseDateInImdb = waitAndGetTheText(imdb.indiaReleaseDate);
        }
        openNewTabAndEnterURL(wikiPage.wikiURL);
        waitAndSendKeys(wikiPage.searchTextField, imdb.pushpaMovieName);
        waitAndClick(wikiPage.suggestedListFirstElement);
        String releaseInDateInWiki = waitAndGetTheText(wikiPage.pushpaReleaseDateInWiki);
        String releaseCountryDataInWiki = waitAndGetTheText(wikiPage.pushpaReleaseCountry);
        pushpaReleaseDateInImdb = pushpaReleaseDateInImdb.replace(",", "").replace("\n", " ");
        releaseCountryDataInWiki = releaseInDateInWiki + " " + releaseCountryDataInWiki;
        releaseCountryDataInWiki = releaseCountryDataInWiki.replace("\n", " ");
        String[] str = pushpaReleaseDateInImdb.split(" ");
        for (String parts : str) {
            if (!releaseCountryDataInWiki.contains(parts)) {
                Assert.fail();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
