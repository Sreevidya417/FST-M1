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

import java.io.ByteArrayInputStream;


public class Activity3
{
    WebDriver wd;

    @BeforeClass
    public void openTheHomePage()
    {
        wd = new FirefoxDriver();
        wd.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void verfiyTitleOfInfoBox()
    {
        //String heading = wd.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[2]/div[2]/div[1]/div[2]/div/div/div/div/div[2]/h3")).getText();
        String heading = wd.findElement(By.cssSelector("#uagb-infobox-f08ebab0-fbf1-40ec-9b2a-c9feeb3d4810 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > h3:nth-child(1)")).getText();
        Assert.assertEquals(heading, "Actionable Training");
    }

    @AfterClass
    public void closeBrowser()
    {
        wd.quit();
    }

}
