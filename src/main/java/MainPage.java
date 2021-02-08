import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    WebDriver driver;
    By firstName = By.id("firstName");
    By lastName = By.id("lastName");
    By userEmail = By.id("userEmail");
    By userNumber = By.id("userNumber");
    By submitButton = By.id("submit");
    By selectGender = By.className("custom-control-label");
    By registrationFeedback = By.id("example-modal-sizes-title-lg");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public void setFirstName(String name){
        driver.findElement(firstName).sendKeys(name);
    }

    public void setLastName(String name){
        driver.findElement(lastName).sendKeys(name);
    }

    public void setUserEmail(String email){
        driver.findElement(userEmail).sendKeys(email);
    }

    public void setUserNumber(String phoneNumber){
        driver.findElement(userNumber).sendKeys(phoneNumber);
    }

    public void clickSubmit(){
        driver.findElement(submitButton).click();
    }

    public void setSelectGender(){
        driver.findElement(selectGender).click();
    }

    public void confirmRegistration(){
        driver.findElement(registrationFeedback);
    }
}