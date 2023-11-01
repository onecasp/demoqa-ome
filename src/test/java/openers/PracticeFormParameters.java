package openers;

import com.codeborne.selenide.Selenide;
import models.Date;
import cssselectors.PracticeFormPage;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormParameters {

    public static void firstNameSet(String firstname) {
        Selenide.$(PracticeFormPage.cssfirstname).setValue(firstname);
    }

    public static void firstNameValidation() {
        Selenide.$(PracticeFormPage.cssfirstname).shouldHave(attribute("required"));
        Selenide.$(PracticeFormPage.cssfirstname).shouldHave(type("text"));
    }

    public static void lastNameSet(String lastname) {
        Selenide.$(PracticeFormPage.csslastname).setValue(lastname);
    }

    public static void lastNameValidation() {
        Selenide.$(PracticeFormPage.csslastname).shouldHave(attribute("required"));
        Selenide.$(PracticeFormPage.csslastname).shouldHave(type("text"));
    }

    public static void emailSet(String userEmail) {
        Selenide.$(PracticeFormPage.cssemail).setValue(userEmail);
    }

    public static void genderSet(String gender) {
        Selenide.$(PracticeFormPage.cssgender).$(byText(gender)).click();
    }

    public static void numberSet(String userNumber) {
        Selenide.$(PracticeFormPage.cssnumber).setValue(userNumber);
    }

    public static void birthdaySet (Date birth) {
        Selenide.$(PracticeFormPage.csscalendarinput).click();
        Selenide.$(PracticeFormPage.cssyear).selectOption(birth.year);
        Selenide.$(PracticeFormPage.cssmonth).selectOption(birth.month);
        Selenide.$(PracticeFormPage.cssday).$(byText(birth.day)).click();
    }

    public static void subjectSet (String subject) {
        Selenide.$(PracticeFormPage.csssubject).setValue(subject).pressEnter();
    }

    public static void hobbieSet (String hobbie) {
        Selenide.$(PracticeFormPage.csshobbie).$(byText(hobbie)).click();
    }

    public static void uploadFile (String test_file) {
        Selenide.$(PracticeFormPage.cssuploadbutton).uploadFromClasspath(test_file);
    }

    public static void currentaddressSet(String current_address) {
        Selenide.$(PracticeFormPage.csscurrentaddress).setValue(current_address);
    }

    public static void stateSet(String state) {
        Selenide.$(PracticeFormPage.cssstate).$("#react-select-3-input").setValue(state).pressEnter();
    }

    public static void citySet (String city) {
        Selenide.$(PracticeFormPage.csscity).$("#react-select-4-input").setValue(city).pressEnter();
    }

    public static void submitForm() {
        Selenide.$(PracticeFormPage.csssubmit).click();
    }
}