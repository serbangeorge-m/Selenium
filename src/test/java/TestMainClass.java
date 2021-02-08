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
        String currentUrl = driver.getCurrentUrl();
        String currentTitle = driver.getTitle();

        driver.get(baseUrl);

        assertEquals(currentUrl,baseUrl);
        assertEquals(currentTitle,pageTitle);
    }

    @RepeatedTest(5)
    public void registerUser() throws InterruptedException {
        person = new Person();
        String firstName = person.getFirstName();
        String lastName = person.getLastName(firstName);
        String fullName =firstName + " " + lastName;
        System.out.println(fullName);


        driver.get(baseUrl);
        mainPage = new MainPage(driver);
        mainPage.setFirstName(firstName);
        mainPage.setLastName(lastName);
        mainPage.setUserEmail(person.getEmail());
        mainPage.selectGender();
        mainPage.setUserNumber(person.getMobileNumber());
        mainPage.submitForm();

        assertEquals(mainPage.registrationFeedback(), true);
    }

    @AfterAll
    public void close(){
        driver.quit();
    }
}
