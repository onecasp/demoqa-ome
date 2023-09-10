package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.gmail.oleg12.medvedev.submiter.PracticeFormOpener.practiceFormOpener;
import static com.gmail.oleg12.medvedev.submiter.PracticeFormParameters.*;
import static test_data.Positive_test_data.firstname;
import static test_data.Positive_test_data.lastname;

public class ExactFieldPositiveTest {
    @BeforeAll
    static void openDemoQA() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void firstNameSuccessTest() {

        practiceFormOpener();

        //validating required and type = text
        firstNameValidation();

        //trying to enter correct value
        firstNameSet(firstname);
    }

    @Test
    void lastNameSuccessTest() {

        practiceFormOpener();

        //validating required and type = text
        lastNameValidation();

        //trying to enter correct value
        lastNameSet(lastname);
    }
}
