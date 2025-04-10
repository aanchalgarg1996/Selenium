
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testings
{
    WebDriver driver;
    JavascriptExecutor js;
    @BeforeEach
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void search() {
        driver.findElement(By.id("search_query_top")).sendKeys("dresses");
        driver.findElement(By.name("submit_search")).click();
    }

    @Test
    public void navigate() throws InterruptedException
    {
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
    }

    @Test
    public void dropDown() {
        search();
        driver.findElement(By.id("selectProductSort")).click();
        driver.findElement(By.xpath("//*[@value='price:asc']")).click();
    }

    @Test
    public void display_icon()
    {
        search();
        driver.findElement(By.xpath("//i[@class='icon-th-list']")).click();
        scroll();
    }

    @Test
    public void scroll()
    {
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    @Test
    public void getTitle()
    {
        assertEquals("My Shop",driver.getTitle());
    }

    @AfterEach
    public void tearDown() throws InterruptedException
    {
        Thread.sleep(5000);
        if (driver != null)
        driver.quit();
    }

}
