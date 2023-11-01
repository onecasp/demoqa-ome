package test_data;

import com.github.javafaker.Faker;

public class DataGenerator {
    Faker faker = new Faker();

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


}
