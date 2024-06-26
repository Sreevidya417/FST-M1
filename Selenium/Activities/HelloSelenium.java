import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HelloSelenium
{
    public static void main(String[] args)
    {
        //Initialize Browser
        WebDriver wd = new FirefoxDriver();

        //Goto Webpage
        wd.get("https://v1.training-support.net");

        //Do necessary things
        System.out.println("The title of the page is : " + wd.getTitle());

        //Close the browser
        //wd.close();
    }
}
