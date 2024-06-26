package LMS_Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1
{
    WebDriver wd;

    @BeforeClass
    public void openTheHomePage()
    {
        wd = new FirefoxDriver();
        wd.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void checkTitleOfLMSHomePage()
    {
        String title = wd.getTitle();
        Assert.assertEquals(title, "Alchemy LMS – An LMS Application");
    }

    @AfterClass
    public void closeBrowser()
    {
        wd.quit();
    }
}
