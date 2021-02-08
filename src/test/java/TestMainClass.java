import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestMainClass {
    WebDriver driver;
    MainPage mainPage;
    Person person;

    String baseUrl = "https://demoqa.com/automation-practice-form";
    String pageTitle = "ToolsQA";

    @BeforeAll
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:/Users/george_serban/IdeaProjects/Assignment/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void GoToPageAndValidateUrl(){
        driver.get(baseUrl);

        String currentUrl = driver.getCurrentUrl();
        String currentTitle = driver.getTitle();

        assertEquals(currentUrl,baseUrl);
        assertEquals(currentTitle,pageTitle);
    }

    @RepeatedTest(5)
    public void registerUser() throws InterruptedException {
        driver.get(baseUrl);

        mainPage = new MainPage(driver);
        person = new Person();

        String firstName = person.getFirstName();
        String lastName = person.getLastName(firstName);
        String fullName =firstName + " " + lastName;

        mainPage.setFirstName(firstName);
        mainPage.setLastName(lastName);
        mainPage.setUserEmail(person.getEmail());
        mainPage.selectGender();
        mainPage.setUserNumber(person.getMobileNumber());
        mainPage.submitForm();

        boolean registrationFeedback = driver.findElement(By.id("example-modal-sizes-title-lg")).isDisplayed();

        assertEquals(registrationFeedback, true);

        System.out.println(fullName);

        Thread.sleep(5000);
    }

    @AfterAll
    public void close(){
        driver.quit();
    }
}
