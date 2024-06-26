package LMS_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class Activity6
{
    WebDriver wd;

    @BeforeClass
    public void openTheHomePage()
    {
        wd = new FirefoxDriver();
        wd.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void login()
    {
        wd.findElement(By.cssSelector("#menu-item-1507 > a:nth-child(1)")).click();
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.findElement(By.xpath("//*[@id=\"uagb-column-e9d225cb-cee9-4e02-a12d-073d5f051e91\"]/div[2]/div[2]/a")).click();
        WebDriverWait wait1 = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.findElement(By.id("user_login")).sendKeys("root");
        wd.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        wd.findElement(By.id("wp-submit")).click();

        String confirmationText = wd.findElement(By.xpath("//*[@id=\"wp-admin-bar-my-account\"]/a")).getText();
        System.out.println(confirmationText);

        Assert.assertEquals(confirmationText,"Howdy, root");
    }

    @AfterClass
    public void closeBrowser()
    {
        wd.quit();
    }

}
