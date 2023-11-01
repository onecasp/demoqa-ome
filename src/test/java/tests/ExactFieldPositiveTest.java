package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static openers.PracticeFormParameters.*;
import static openers.RegistrationFormOpener.registrationFormOpener;
import static test_data.PositiveTestDataAll.firstname;
import static test_data.PositiveTestDataAll.lastname;

public class ExactFieldPositiveTest {
    @BeforeAll
    static void openDemoQA() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void firstNameSuccessTest() {

        registrationFormOpener();

        //validating required and type = text
        firstNameValidation();

        //trying to enter correct value
        firstNameSet(firstname);
    }

    @Test
    void lastNameSuccessTest() {

        registrationFormOpener();

        //validating required and type = text
        lastNameValidation();

        //trying to enter correct value
        lastNameSet(lastname);
    }
}
