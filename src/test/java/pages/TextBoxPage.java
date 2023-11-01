package pages;


import static test_data.PositiveTextBoxData.*;

import com.codeborne.selenide.Selenide;
import cssselectors.PracticeFormPage;
import test_data.PositiveTestDataRequired;
import test_data.PositiveTextBoxData;

public class TextBoxPage {

    public TextBoxPage userNameSet(String firstname, String lastname) {
        Selenide.$(PracticeFormPage.cssusername).setValue(firstname +" "+ lastname);
        return this;
    }

    public TextBoxPage emailSet(String userEmail) {
        Selenide.$(PracticeFormPage.cssemail).setValue(userEmail);
        return this;
    }

    public TextBoxPage currentaddressSet(String current_address) {
        Selenide.$(PracticeFormPage.csscurrentaddress).setValue(current_address);
        return this;
    }

    public TextBoxPage permanentaddressSet(String permanent_address) {
        Selenide.$(PracticeFormPage.csspermanentaddress).setValue(permanent_address);
        return this;
    }

    public TextBoxPage allFieldsFill(PositiveTextBoxData testData) {
        userNameSet(firstname, lastname).emailSet(userEmail).currentaddressSet(current_address)
            .permanentaddressSet(permanent_address);
        return this;
    }

    public TextBoxPage submitForm() {
        Selenide.$(PracticeFormPage.csssubmit).click();
        return this;
    }
}
