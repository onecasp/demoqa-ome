package tests;

import pages.RegistrationPage;
import pages.componets.SuccessFormVerifier;
import org.junit.jupiter.api.Test;
import test_data.PositiveTestDataAll;
import test_data.PositiveTestDataRequired;

import static openers.PracticeFormParameters.*;
import static openers.RegistrationFormOpener.registrationFormOpener;
import static test_data.PositiveTestDataAll.*;

public class DemoqaE2EPositiveTest extends BaseTest {

    @Test
    void successfulAllFieldsTest() {

        registrationFormOpener();

        RegistrationPage registrationPage = new RegistrationPage();
        PositiveTestDataAll positiveTestDataAll = new PositiveTestDataAll();

        //fill form
        registrationPage.fillAllFields(positiveTestDataAll).submitForm();

        //validation
        SuccessFormVerifier.successFormVerifier(positiveTestDataAll);
    }

    @Test
    void requiredFieldsSuccess() {
        registrationFormOpener();

        RegistrationPage registrationPage = new RegistrationPage();
        PositiveTestDataRequired positiveTestDataReuired = new PositiveTestDataRequired();

        registrationPage.requiredFieldsFill(positiveTestDataReuired).submitForm();

        SuccessFormVerifier.successFormVerifier(firstname, lastname, gender, userNumber);
    }
}
