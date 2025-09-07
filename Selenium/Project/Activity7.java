package LMS_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class Activity7
{
    WebDriver wd;

    @BeforeClass
    public void openTheHomePage()
    {
        wd = new FirefoxDriver();
        wd.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void numberOfCourses()
    {
        List<WebElement> numberOfCourses = wd.findElements(By.className("caption"));
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(100));
        System.out.println("Number of courses in this page : " + numberOfCourses.size());
    }

    @AfterClass
    public void closeBrowser()
    {
        wd.quit();
    }

}
