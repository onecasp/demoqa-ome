package pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Selectors.byText;
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

import com.codeborne.selenide.Selenide;
import cssselectors.PracticeFormPage;
import models.Date;
import pages.componets.CalendarComponent;
import test_data.PositiveTestDataAll;
import test_data.PositiveTestDataRequired;

public class RegistrationPage {

   CalendarComponent calendar = new CalendarComponent();

    public RegistrationPage firstNameSet(String firstname) {
        Selenide.$(PracticeFormPage.cssfirstname).setValue(firstname);
        return this;
    }

    public static void firstNameValidation() {
        Selenide.$(PracticeFormPage.cssfirstname).shouldHave(attribute("required"));
        Selenide.$(PracticeFormPage.cssfirstname).shouldHave(type("text"));
    }

    public RegistrationPage lastNameSet(String lastname) {
        Selenide.$(PracticeFormPage.csslastname).setValue(lastname);
        return this;
    }

    public static void lastNameValidation() {
        Selenide.$(PracticeFormPage.csslastname).shouldHave(attribute("required"));
        Selenide.$(PracticeFormPage.csslastname).shouldHave(type("text"));
    }

    public RegistrationPage emailSet(String userEmail) {
        Selenide.$(PracticeFormPage.cssemail).setValue(userEmail);
        return this;
    }

    public RegistrationPage genderSet(String gender) {
        Selenide.$(PracticeFormPage.cssgender).$(byText(gender)).click();
        return this;
    }

    public RegistrationPage numberSet(String userNumber) {
        Selenide.$(PracticeFormPage.cssnumber).setValue(userNumber);
        return this;
    }

    public RegistrationPage birthdaySet (Date birth) {
        Selenide.$(PracticeFormPage.csscalendarinput).click();
        calendar.setDate(birth);
        return this;
    }

    public RegistrationPage subjectSet (String subject) {
        Selenide.$(PracticeFormPage.csssubject).setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage hobbieSet (String hobbie) {
        Selenide.$(PracticeFormPage.csshobbie).$(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage uploadFile (String test_file) {
        Selenide.$(PracticeFormPage.cssuploadbutton).uploadFromClasspath(test_file);
        return this;
    }

    public RegistrationPage currentaddressSet(String current_address) {
        Selenide.$(PracticeFormPage.csscurrentaddress).setValue(current_address);
        return this;
    }

    public RegistrationPage stateSet(String state) {
        Selenide.$(PracticeFormPage.cssstate).$("#react-select-3-input").setValue(state).pressEnter();
        return this;
    }

    public RegistrationPage citySet (String city) {
        Selenide.$(PracticeFormPage.csscity).$("#react-select-4-input").setValue(city).pressEnter();
        return this;
    }

    public RegistrationPage fillAllFields (PositiveTestDataAll testData) {
        firstNameSet(firstname).lastNameSet(lastname).emailSet(userEmail)
            .genderSet(gender).numberSet(userNumber).birthdaySet(birth).subjectSet(subject)
            .hobbieSet(hobbie).uploadFile(test_file).currentaddressSet(current_address)
            .stateSet(state).citySet(city);
        return this;
    }

    public RegistrationPage requiredFieldsFill (PositiveTestDataRequired testData) {
        firstNameSet(firstname).lastNameSet(lastname).genderSet(gender).numberSet(userNumber);
        return this;
    }
    public RegistrationPage submitForm() {
        Selenide.$(PracticeFormPage.csssubmit).click();
        return this;
    }
}
