package tests;

import com.codeborne.selenide.Configuration;
import com.gmail.oleg12.medvedev.verifier.SuccessFormVerifier;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.gmail.oleg12.medvedev.submiter.PracticeFormOpener.practiceFormOpener;
import static com.gmail.oleg12.medvedev.submiter.PracticeFormParameters.*;
import static test_data.Positive_test_data.*;

public class DemoqaE2EPositiveTest {

    @BeforeAll
    static void openDemoQA() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulAllFieldsTest() {

        practiceFormOpener();

        //entering firstname
        firstNameSet(firstname);

        //entering lastname
        lastNameSet(lastname);

        //entering email
        emailSet(userEmail);

        //pushing "other" radiobutton
        genderSet(gender);

        //entering user mobile phone
        numberSet(userNumber);

        //entering birthdate
        birthdaySet(birth);

        //entering subject
        subjectSet(subject);

        //setting hobbies
        hobbieSet(hobbie);

        //uploading test file
        uploadFile(test_file);

        //entering address
        currentaddressSet(current_address);

        //entering state
        stateSet(state);

        //entering city
        citySet(city);

        //submit the form
        submitForm();

        //validation
        SuccessFormVerifier.successFormVerifier(firstname, lastname, userEmail, gender, userNumber,
                birth, subject, hobbie, test_file, current_address, state, city);
    }

    @Test
    void requiredFieldsSuccess() {
        practiceFormOpener();

        //entering firstname
        firstNameSet(firstname);

        //entering lastname
        lastNameSet(lastname);

        //pushing "other" radiobutton
        genderSet(gender);

        //entering mobile number
        numberSet(userNumber);

        //submitForm
        submitForm();

        SuccessFormVerifier.successFormVerifier(firstname, lastname, gender, userNumber);
    }
}
