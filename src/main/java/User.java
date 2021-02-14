import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class User {

    public String getEmail()
    {
        return RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    }

    public String getMobileNumber()
    {
        long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
        return String.valueOf(number);
    }

    public static List<String> pickRandomName(List<String> usersToRegister, int n) {
        if (n > usersToRegister.size()) {
            throw new IllegalArgumentException("not enough elements");
        }
        Random random = new Random();
        return IntStream
                .generate(() -> random.nextInt(usersToRegister.size()))
                .distinct()
                .limit(n)
                .mapToObj(usersToRegister::get)
                .collect(Collectors.toList());
    }

    public String setLastName(String firstName){
        String lastName = null;
        switch (firstName){
            case "Jan" -> lastName = "Dam";
            case "Chack" -> lastName = "Norris";
            case "Klark" -> lastName = "Kent";
            case "John" -> lastName = "Daw";
            case "Bat" -> lastName = "Man";
            case "Tim" -> lastName = "Los";
            case "Dave" -> lastName = "Core";
            case "Pay" -> lastName = "Pal";
            case "Lazy" -> lastName = "Cat";
            case "Jack" -> lastName = "Jones";
            default -> {
                System.err.println("This name does not exist");
            }
        }
        return lastName;
    }
}

