
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
public class Testings
{

    @Test
    public void Chrome_test() throws InterruptedException {
        // System.setProperty("WebDriver.chrome.driver","/Users/ashish/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.id("search_query_top")).sendKeys("dresses");
        driver.findElement(By.name("submit_search")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.manage().deleteAllCookies();
        System.out.println(driver.getTitle());

        Thread.sleep(5000);
        driver.quit();
    }

}
