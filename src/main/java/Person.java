import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;

public class Person {

    Random random = new Random();
    public String getEmail()
    {
        return RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    }

    public String getMobileNumber()
    {
        return "1234567890";
    }


    public String getFirstName(){
        String[] firstNames = {"Jan", "Chack", "Klark", "John", "Bat", "Tim", "Dave", "Pay", "Lazy", "Jack"};

        return firstNames[random.nextInt(firstNames.length)];
    }

    public String getLastName(String name) {
        String lastName = null;

        switch (name) {
            case "Jan":
                lastName = "Dam";
                break;
            case "Chack":
                lastName = "Norris";
                break;
            case "Klark":
                lastName = "Kent";
                break;
            case "John":
                lastName = "Daw";
                break;
            case "Bat":
                lastName = "Man";
                break;
            case "Tim":
                lastName = "Los";
                break;
            case "Dave":
                lastName = "Core";
                break;
            case "Pay":
                lastName = "Pal";
                break;
            case "Lazy":
                lastName = "Cat";
                break;
            case "Jack":
                lastName = "Jones";
                break;
        }

        return lastName;
    }
}
