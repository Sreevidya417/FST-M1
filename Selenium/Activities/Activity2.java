import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2
{
    public static void  main(String[] args)
    {
        WebDriver wd = new FirefoxDriver();
        wd.get("https://v1.training-support.net/selenium/login-form");
        System.out.println("Home page title is -> " + wd.getTitle());

        wd.findElement(By.id("username")).sendKeys("admin");
        wd.findElement(By.id("password")).sendKeys("password");
        wd.findElement(By.xpath("//button[text()='Log in']")).click();


        String message = wd.findElement(By.id("action-confirmation")).getText();
        System.out.println("login message is " + message);

        wd.close();
    }
}
