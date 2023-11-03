package tests;

import pages.RegistrationPage;
import pages.componets.SuccessFormVerifier;
import org.junit.jupiter.api.Test;
import test_data.PositiveTestDataAll;
import test_data.PositiveTestDataRequired;

import static openers.RegistrationFormOpener.registrationFormOpener;
import static test_data.PositiveTestDataAll.*;

public class DemoqaE2EPositiveTest extends BaseTest {

    @Test
    void successfulAllFieldsTest() {

        registrationFormOpener();

        RegistrationPage registrationPage = new RegistrationPage();

        //fill form
        registrationPage.firstNameSet(firstname).lastNameSet(lastname).emailSet(userEmail)
            .genderSet(gender).numberSet(userNumber).birthdaySet(birth).subjectSet(subject)
            .hobbieSet(hobbie).uploadFile(test_file).currentaddressSet(current_address)
            .stateSet(state).citySet(city).submitForm();

        //validation
        SuccessFormVerifier.successFormVerifier(firstname, lastname, userEmail, gender, userNumber,
            birth, subject, hobbie, test_file, current_address, state, city);
    }

    @Test
    void requiredFieldsSuccess() {
        registrationFormOpener();

        RegistrationPage registrationPage = new RegistrationPage();

        registrationPage.firstNameSet(firstname).lastNameSet(lastname).genderSet(gender)
            .numberSet(userNumber).submitForm();

        SuccessFormVerifier.successFormVerifier(firstname, lastname, gender, userNumber);
    }
}
