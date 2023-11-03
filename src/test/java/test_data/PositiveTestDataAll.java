package test_data;

import static test_data.DataGenerator.addressGenerator;
import static test_data.DataGenerator.dateGenerator;
import static test_data.DataGenerator.firstNameGeneration;
import static test_data.DataGenerator.getRandomCity;
import static test_data.DataGenerator.getRandomGender;
import static test_data.DataGenerator.getRandomHobbie;
import static test_data.DataGenerator.getRandomState;
import static test_data.DataGenerator.lastNameGeneration;
import static test_data.DataGenerator.subjectGeneration;
import static test_data.DataGenerator.userEmailGeneration;
import static test_data.DataGenerator.userNumberGeneration;

import models.Date;

public class PositiveTestDataAll {
    public static String firstname = firstNameGeneration();
    public static String lastname = lastNameGeneration();
    public static String userEmail = userEmailGeneration();
    public static String gender = getRandomGender();
    public static String userNumber = userNumberGeneration();
    public static String subject = subjectGeneration();
    public static String hobbie = getRandomHobbie();
    public static String test_file = "test.txt";
    public static String current_address = addressGenerator();
    public static String permanent_address = addressGenerator();
    public static String state = getRandomState();
    public static String city = getRandomCity(state);
    public static Date birth = dateGenerator();


}

