package tests;

import static openers.RegistrationFormOpener.registrationFormOpener;
import static openers.TextBoxPageOpener.textBoxFormOpener;
import static test_data.PositiveTextBoxData.current_address;
import static test_data.PositiveTextBoxData.firstname;
import static test_data.PositiveTextBoxData.lastname;
import static test_data.PositiveTextBoxData.permanent_address;
import static test_data.PositiveTextBoxData.userEmail;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;
import pages.componets.SuccessFormVerifier;
import test_data.PositiveTestDataAll;
import test_data.PositiveTextBoxData;

public class TextBoxTest extends BaseTest {

    @Test
    void successfulAllFieldsTest() {

        textBoxFormOpener();

        TextBoxPage textBoxPage = new TextBoxPage();

        //fill form
        textBoxPage.userNameSet(firstname, lastname).emailSet(userEmail)
            .currentaddressSet(current_address)
            .permanentaddressSet(permanent_address).submitForm();

        //validation
        SuccessFormVerifier.successFormVerifier(firstname, lastname, userEmail, current_address,
            permanent_address);
    }
}
