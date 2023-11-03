package tests;

import static openers.TextBoxPageOpener.textBoxFormOpener;
import static test_data.PositiveTestDataAll.current_address;
import static test_data.PositiveTestDataAll.firstname;
import static test_data.PositiveTestDataAll.lastname;
import static test_data.PositiveTestDataAll.permanent_address;
import static test_data.PositiveTestDataAll.userEmail;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.componets.SuccessFormVerifier;

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
