package LMS_Project;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.time.Duration;


public class Activity5
{
    WebDriver wd;

    @BeforeClass
    public void openTheHomePage()
    {
        wd = new FirefoxDriver();
        wd.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void verifyMyAccountsPage()
    {
        wd.findElement(By.cssSelector("#menu-item-1507 > a:nth-child(1)")).click();
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));

        String titleOfSecondPage = wd.getTitle();
        Assert.assertEquals(titleOfSecondPage,"My Account – Alchemy LMS");


    }

    @AfterClass
    public void closeBrowser()
    {
        wd.quit();
    }

}
