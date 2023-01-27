package Pages;

public class ImdbPage {
    public String imdbPageURL = "https://www.imdb.com/";
    public String searchTextField = "//input[@aria-label='Search IMDb']";
    public String searchButton = "//button[@aria-label='Submit Search']";
    public String pushpaMovieName = "PUSHPA1";
    public String push1FirstResult = "//li[@class='ipc-metadata-list-summary-item ipc-metadata-list-summary-item--click find-result-item find-title-result'][1]";
    public String pushpaMovieReleaseDate = "//li[@data-testid='title-details-releasedate']";
    public String seeMoreItemsButton = "//span[text()='12 more']";
    public String indiaReleaseDate = "//li[@class='ipc-metadata-list__item ipc-metadata-list-item--link'][7]";
    public String releaseDateInfo = "//td[@class='release-date-item__date']/a[text()='India']";
    public String imdbIndiaReleaseDate = "//tr[7]";
    public String pushpaTheRiseText = "Pushpa: The Rise - Part 1";

}
