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


public class Activity8
{
    WebDriver wd;

    @BeforeClass
    public void openTheHomePage()
    {
        wd = new FirefoxDriver();
        wd.get("https://alchemy.hguy.co/lms");
        wd.findElement(By.xpath("//*[@id=\"menu-item-1506\"]/a")).click();


    }

    @Test
    public void submitInfo()
    {
        wd.findElement(By.xpath("//*[@id=\"wpforms-8-field_0\"]")).sendKeys("Sreevara");
        wd.findElement(By.xpath("//*[@id=\"wpforms-8-field_1\"]")).sendKeys("shreevara@in.ibm.com");
        wd.findElement(By.xpath("//*[@id=\"wpforms-8-field_3\"]")).sendKeys("TestNG Project");
        wd.findElement(By.xpath("//*[@id=\"wpforms-8-field_2\"]")).sendKeys("This is activity 8");
        wd.findElement(By.id("wpforms-submit-8")).click();

    }

    @AfterClass
    public void messageReceived()
    {
        String message = wd.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[4]/div[2]/div[2]/div[2]/div[2]/p")).getText();
        System.out.println("Message received from CK Labs is : " + message);
        wd.quit();
    }


}
