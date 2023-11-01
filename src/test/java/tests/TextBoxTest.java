package tests;

import static openers.RegistrationFormOpener.registrationFormOpener;
import static openers.TextBoxPageOpener.textBoxFormOpener;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TextBoxPage;
import pages.componets.SuccessFormVerifier;
import test_data.PositiveTestDataAll;
import test_data.PositiveTextBoxData;

public class TextBoxTest extends BaseTest{
    @Test
    void successfulAllFieldsTest() {

        textBoxFormOpener();

        TextBoxPage textBoxPage = new TextBoxPage();
        PositiveTextBoxData positiveTextBoxData = new PositiveTextBoxData();

        //fill form
        textBoxPage.allFieldsFill(positiveTextBoxData).submitForm();

        //validation
        SuccessFormVerifier.successFormVerifier(positiveTextBoxData);
    }
}
