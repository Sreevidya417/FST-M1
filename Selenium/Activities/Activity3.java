
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3
{
    public static void main(String[]  args)
    {
        WebDriver wd = new FirefoxDriver();
        wd.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Title of the home page is -> " + wd.getTitle());

        wd.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys("admin");
        wd.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("password");
        wd.findElement(By.xpath("//button[text()=\"Log in\"]")).click();

        String msg = wd.findElement(By.xpath("//div[@id=\"action-confirmation\"]")).getText();
        System.out.println("Login message is -> " + msg);

        wd.quit();

    }
}
