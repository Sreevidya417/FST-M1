package LMS_Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Activity2
{
    WebDriver wd;

    @BeforeClass
    public void openTheHomePage()
    {
        wd = new FirefoxDriver();
        wd.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void checkHeadingOfHomePage()
    {
        String heading = wd.findElement(By.className("uagb-ifb-title")).getText();

        Assert.assertEquals(heading, "Learn from Industry Experts");
    }

    @AfterClass
    public void closeBrowser()
    {
        wd.quit();
    }
}
