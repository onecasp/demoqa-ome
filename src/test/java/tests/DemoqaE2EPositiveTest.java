package tests;

import static openers.RegistrationFormOpener.registrationFormOpener;
import static test_data.PositiveTestDataAll.birth;
import static test_data.PositiveTestDataAll.city;
import static test_data.PositiveTestDataAll.current_address;
import static test_data.PositiveTestDataAll.firstname;
import static test_data.PositiveTestDataAll.gender;
import static test_data.PositiveTestDataAll.hobbie;
import static test_data.PositiveTestDataAll.lastname;
import static test_data.PositiveTestDataAll.state;
import static test_data.PositiveTestDataAll.subject;
import static test_data.PositiveTestDataAll.test_file;
import static test_data.PositiveTestDataAll.userEmail;
import static test_data.PositiveTestDataAll.userNumber;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.componets.SuccessFormVerifier;

public class DemoqaE2EPositiveTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successfulAllFieldsTest() {

        registrationFormOpener();

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

        registrationPage.firstNameSet(firstname).lastNameSet(lastname).genderSet(gender)
            .numberSet(userNumber).submitForm();

        SuccessFormVerifier.successFormVerifier(firstname, lastname, gender, userNumber);
    }
}
