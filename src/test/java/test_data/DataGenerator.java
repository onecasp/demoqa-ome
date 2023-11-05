package test_data;

import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import models.Date;

public class DataGenerator {

    static Faker faker = new Faker();

    public static String firstNameGeneration() {
        return faker.name().firstName();
    }

    public static String lastNameGeneration() {
        return faker.name().lastName();
    }

    public static String userEmailGeneration() {
        return faker.internet().emailAddress();
    }

    public static String userNumberGeneration() {
        return String.format("%s%s%s%s", getRandomInt(100, 999), getRandomInt(100, 999),
            getRandomInt(10, 99), getRandomInt(10, 99));
    }

    public static int getRandomInt(int min, int max) {
        return faker.number().numberBetween(min, max);
    }

    public static String getRandomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getRandomHobbie() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getRandomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

    public static String subjectGeneration() {
        return faker.options().option("Maths",
            "English",
            "Computer Science",
            "Arts",
            "History",
            "Commerce");
    }

    public static String addressGenerator() {
        return faker.address().fullAddress();
    }

    public static String getRandomDay(String month) {
        if (Objects.equals(month, "January") || Objects.equals(month, "March")
            || Objects.equals(month, "May") || Objects.equals(month, "July")
            || Objects.equals(month, "August") || Objects.equals(month, "October") || Objects.equals(
            month, "December")) {
            return String.valueOf(getRandomInt(1, 31));
        } else if (Objects.equals(month, "April") || Objects.equals(month, "June") || Objects.equals(
            month, "September")
            || Objects.equals(month, "November")) {
            return String.valueOf(getRandomInt(1, 30));
        } else if (Objects.equals(month, "February")) {
            return String.valueOf(getRandomInt(1, 28));
        } else if (Objects.equals(month, "FebruaryUp")) {
            return String.valueOf(getRandomInt(1, 29));
        }
        return null;
    }

    public static String getRandomMonth(String year) {
        if (Integer.parseInt(year) % 4 == 0) {
            return faker.options()
                .option("January", "FebruaryUp", "March", "April", "May", "June", "July", "August",
                    "September", "October", "November", "December");
        } else {
            return faker.options()
                .option("January", "February", "March", "April", "May", "June", "July", "August",
                    "September", "October", "November", "December");
        }
    }

    public static String yearGeneration() {
        return String.valueOf(getRandomInt(1900, 2100));
    }

    public static Date dateGenerator() {
        String year = yearGeneration();
        String month = getRandomMonth(year);
        String day = getRandomDay(month);
        if (month.equals("FebruaryUp")) {
            return new Date(day, "February", year);
        } else {
            return new Date(day, month, year);
        }
    }
}