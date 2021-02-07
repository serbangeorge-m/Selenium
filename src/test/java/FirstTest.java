import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {
    @Test
    public void GoToPage(){

        System.setProperty("webdriver.chrome.driver","C:/Users/george_serban/IdeaProjects/Assignment/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://demoqa.com/automation-practice-form");

        String URL = driver.getCurrentUrl();

        assertEquals(URL,"https://demoqa.com/automation-practice-form");

        driver.close();
        driver.quit();




    }
}
