package test_data;

import com.github.javafaker.Faker;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    static Faker faker = new Faker();

    public static void main(String[] args) {
        System.out.println(userNumberGeneration());
    }

    public String firstNameGeneration() {
        String firstname = faker.name().firstName();
        return firstname;
    }

    public String lastNameGeneration() {
        String lastname = faker.name().lastName();
        return lastname;
    }

    public String userEmailGeneration() {
        String userEmail = faker.internet().emailAddress();
        return userEmail;
    }

//    public String genderGeneration() {
//        //String gender = faker.internet().emailAddress();
//        return gender;
//    }

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

    public static String getRandomCity( String state) {
        String[] hobbies = {"Sports", "Reading", "Music"};

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
}
