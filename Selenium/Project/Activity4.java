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


public class Activity4
{
    WebDriver wd;

    @BeforeClass
    public void openTheHomePage()
    {
        wd = new FirefoxDriver();
        wd.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void findSecondPopularCourse()
    {
        String secondPopularCourseTitle = wd.findElement(By.xpath("//*[@id=\"post-71\"]/div[2]/h3")).getText();
        Assert.assertEquals(secondPopularCourseTitle, "Email Marketing Strategies");
    }

    @AfterClass
    public void closeBrowser()
    {
        wd.quit();
    }
}
