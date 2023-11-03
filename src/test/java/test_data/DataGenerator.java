package test_data;

import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import models.Date;

public class DataGenerator {

    static Faker faker = new Faker();

    public static void main(String[] args) {
        Date date = dateGenerator();
        System.out.println(date.year);
        System.out.println(date.month);
        System.out.println(date.day);
    }

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
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomHobbie() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return getRandomItemFromArray(states);
    }

    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> {
                String[] citiesNCR = {"Delhi", "Gurgaon", "Noida"};
                yield getRandomItemFromArray(citiesNCR);
            }
            case "Uttar Pradesh" -> {
                String[] citiesUP = {"Agra", "Lucknow", "Merrut"};
                yield getRandomItemFromArray(citiesUP);
            }
            case "Haryana" -> {
                String[] citiesH = {"Karnal", "Panipat"};
                yield getRandomItemFromArray(citiesH);
            }
            case "Rajasthan" -> {
                String[] citiesR = {"Jaipur", "Jaiselmer"};
                yield getRandomItemFromArray(citiesR);
            }
            default -> null;
        };

    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }

    public static String subjectGeneration() {
        String[] subject = {"Maths",
            "English",
            "Computer Science",
            "Arts",
            "History",
            "Commerce"};
        return getRandomItemFromArray(subject);
    }

    public static String addressGenerator() {
        return faker.address().fullAddress();
    }

    public static String getRandomDay(String month) {
        if (month == "January" || month == "March" || month == "May" || month == "July"
            || month == "August" || month == "October" || month == "December") {
            String[] days31 = new String[31];
            Arrays.setAll(days31, i -> String.valueOf(i + 1));
            return getRandomItemFromArray(days31);
        } else if (month == "April" || month == "June" || month == "September"
            || month == "November") {
            String[] days30 = new String[30];
            Arrays.setAll(days30, i -> String.valueOf(i + 1));
            return getRandomItemFromArray(days30);
        } else if (month == "February") {
            String[] days28 = new String[28];
            Arrays.setAll(days28, i -> String.valueOf(i + 1));
            return getRandomItemFromArray(days28);
        } else if (month == "FebruaryUp") {
            String[] days29 = new String[29];
            Arrays.setAll(days29, i -> String.valueOf(i + 1));
            return getRandomItemFromArray(days29);
        }
        return null;
    }

    public static String getRandomMonth(String year) {
        if (Integer.parseInt(year) % 4 == 0) {
            String[] monthsUp = {"January", "FebruaryUp", "March", "April", "May", "June", "July",
                "August",
                "September", "October", "November", "December"};
            return getRandomItemFromArray(monthsUp);
        } else {
            String[] months = {"January", "February", "March", "April", "May", "June", "July",
                "August",
                "September", "October", "November", "December"};
            return getRandomItemFromArray(months);
        }
    }

    public static String yearGeneration() {
        return String.valueOf(getRandomInt(1900, 2100));
    }

    public static Date dateGenerator() {
        String year = yearGeneration();
        String month = getRandomMonth(year);
        String day = getRandomDay(month);
        if (month == "FebruaryUp") {
            Date date = new Date(day, "February", year);
            return date;
        } else {
            Date date = new Date(day, month, year);
            return date;
        }
    }
}