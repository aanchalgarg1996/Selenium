
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
public class Testings
{
    WebDriver driver;

    @BeforeEach
    public void setup()
    {
        driver = new ChromeDriver();

    }

    @Test
    public void Chrome_test()
    {
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("search_query_top")).sendKeys("dresses");
        driver.findElement(By.name("submit_search")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.manage().deleteAllCookies();
        System.out.println(driver.getTitle());
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        if (driver != null)
        driver.quit();
    }

}
