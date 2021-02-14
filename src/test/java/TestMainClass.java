import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestMainClass {
    WebDriver driver;
    MainPage mainPage;
    User user = new User();

    String baseUrl = "https://demoqa.com/automation-practice-form";

    public static final List<String> users = Collections.unmodifiableList(
            Arrays.asList("Jan", "Chack", "Klark", "John", "Bat", "Tim", "Dave", "Pay", "Lazy", "Jack"));

    @BeforeAll
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:/Users/george_serban/IdeaProjects/Assignment/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void registerFiveUniqueUsers(){

       var usersToRegister = user.pickRandomName(users,5);

       System.out.println("The following users were registered: \n");

       for (String userToRegister :usersToRegister){
           driver.get(baseUrl);
           String currentUrl = driver.getCurrentUrl();
           assertEquals(currentUrl,baseUrl);

           mainPage = new MainPage(driver);
           mainPage.registerNewUser(userToRegister, user.setLastName(userToRegister), user.getEmail(), user.getMobileNumber());

           System.out.println(userToRegister + " " + user.setLastName(userToRegister));

           assertEquals(mainPage.registrationFeedback(), true);
       }
    }


    @AfterAll
    public void close(){
        driver.quit();
    }
}
