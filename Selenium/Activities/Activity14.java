import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity14 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver wd = new FirefoxDriver();
        wd.manage().window().fullscreen();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));

        wd.get("https://v1.training-support.net/selenium/tables");
        System.out.println("Title of the home page is -> : " + wd.getTitle());

        List<WebElement> rows = wd.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("Number of rows in the table are -> " + rows.size());

        List<WebElement> cols = wd.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.println("Number of columns in the table are -> " + cols.size());

        WebElement cellValue = wd.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell value: " + cellValue.getText());

        wd.findElement(By.xpath("//table[@id=\"sortableTable\"]/thead/tr/th")).click();

        cellValue = wd.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));

        System.out.println("Second row, second cell value: " + cellValue.getText());

        List<WebElement> footer = wd.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        System.out.println("Cell values of the footer: ");
        for (WebElement cell : footer) {
            System.out.println(cell.getText());
            System.out.println(cell.getText());

        }
        wd.quit();
    }
}