package tests;

import com.codeborne.selenide.Configuration;
import test_data.Birthday;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static test_data.Positive_test_data.*;

public class Demoqatest {

    @BeforeAll
    static void openDemoQA() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulAllFieldsTest() {

        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        //entering firstname
        $("#firstName").setValue(firstname);

        //entering lastname
        $("#lastName").setValue(lastname);

        //entering email
        $("#userEmail").setValue(userEmail);

        //pushing "other" radiobutton
        $("#genterWrapper").$(byText(gender)).click();

        //entering user mobile phone
        $("#userNumber").setValue(userNumber);

        //entering birthdate
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(Birthday.year);
        $(".react-datepicker__month-select").selectOption(Birthday.month);
        $(".react-datepicker__month").$(byText(Birthday.day)).click();

        //entering subject
        $("#subjectsInput").setValue(subject).pressEnter();

        //setting hobbies
        $("#hobbiesWrapper").$(byText(hobbie)).click();

        //uploading test file
        $("#uploadPicture").uploadFromClasspath(test_file);

        //entering address
        $("#currentAddress").setValue(current_address);

        //entering state
        $("#state").$("#react-select-3-input").setValue(state).pressEnter();

        //entering city
        $("#city").$("#react-select-4-input").setValue(city).pressEnter();

        //submit the form
        $("#submit").click();

        //validation
        $(".table-responsive").shouldHave(text(firstname+" "+lastname),
                text(userEmail), text(gender), text(userNumber),
                text(Birthday.day + " " + Birthday.month + "," + Birthday.year), text(subject),
                text(hobbie), text(test_file), text(current_address),
                text(state+" "+city));
    }
}
