package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    WebDriver driver;
    WebDriverWait wait;
    public void launchBrowser()
    {
      System.setProperty("webdriver.chrome.driver","G:\\chromedriver_win32\\chromedriver.exe");
      driver=new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
      wait=new WebDriverWait(driver, 20);
    }
    public void waitAndClick(String xPath)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).click();
    }
    public void waitAndSendKeys(String xPath, String sendingValue)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).sendKeys(sendingValue);
    }
    public String waitAndGetTheText(String xPath)
    {
       String textOfTheElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath))).getText();
       return textOfTheElement;
    }
    public void clickOnDisabledElement(WebElement element)
    {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", element);
    }
    public void enterURL(String URL)
    {
        driver.get(URL);
    }
    public WebElement element(String element)
    {
            WebElement ele= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
            return ele;
    }
    public void openNewTabAndEnterURL(String element)
    {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        enterURL(element);
    }
}
