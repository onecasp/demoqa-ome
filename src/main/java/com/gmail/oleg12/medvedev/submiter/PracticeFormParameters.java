package com.gmail.oleg12.medvedev.submiter;

import com.codeborne.selenide.Condition;
import com.gmail.oleg12.medvedev.models.Birthday;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.type;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.gmail.oleg12.medvedev.cssselectors.PracticeFormPage.*;

public class PracticeFormParameters {

    public static void firstNameSet(String firstname) {
        $(cssfirstname).setValue(firstname);
    }

    public static void firstNameValidation() {
        $(cssfirstname).shouldHave(attribute("required"));
        $(cssfirstname).shouldHave(type("text"));
    }

    public static void lastNameSet(String lastname) {
        $(csslastname).setValue(lastname);
    }

    public static void lastNameValidation() {
        $(csslastname).shouldHave(attribute("required"));
        $(csslastname).shouldHave(type("text"));
    }

    public static void emailSet(String userEmail) {
        $(cssemail).setValue(userEmail);
    }

    public static void genderSet(String gender) {
        $(cssgender).$(byText(gender)).click();
    }

    public static void numberSet(String userNumber) {
        $(cssnumber).setValue(userNumber);
    }

    public static void birthdaySet (Birthday birth) {
        $(csscalendarinput).click();
        $(cssyear).selectOption(birth.year);
        $(cssmonth).selectOption(birth.month);
        $(cssday).$(byText(birth.day)).click();
    }

    public static void subjectSet (String subject) {
        $(csssubject).setValue(subject).pressEnter();
    }

    public static void hobbieSet (String hobbie) {
        $(csshobbie).$(byText(hobbie)).click();
    }

    public static void uploadFile (String test_file) {
        $(cssuploadbutton).uploadFromClasspath(test_file);
    }

    public static void currentaddressSet(String current_address) {
        $(csscurrentaddress).setValue(current_address);
    }

    public static void stateSet(String state) {
        $(cssstate).$("#react-select-3-input").setValue(state).pressEnter();
    }

    public static void citySet (String city) {
        $(csscity).$("#react-select-4-input").setValue(city).pressEnter();
    }

    public static void submitForm() {
        $(csssubmit).click();
    }
}