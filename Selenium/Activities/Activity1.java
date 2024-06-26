import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Activity1
{
    public static void main(String[]  args)
    {
        WebDriver wd = new FirefoxDriver();
        wd.get("https://v1.training-support.net");
        System.out.println("Title of the home page is -> " + wd.getTitle());

        wd.findElement(By.id("about-link")).click();
        System.out.println("Title of About page is ->  " + wd.getTitle());
        wd.close();

    }
}
