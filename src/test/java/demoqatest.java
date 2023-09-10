import com.codeborne.selenide.Configuration;
import com.gmail.oleg12.medvedev.test_data.birthday;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.gmail.oleg12.medvedev.test_data.positive_test_data.*;

public class demoqatest {

    @BeforeAll
    static void openDemoQA() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
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
        $(".react-datepicker__year-select").selectOption(birthday.year);
        $(".react-datepicker__month-select").selectOption(birthday.month);
        $(".react-datepicker__month").$(byText(birthday.day)).click();

        //entering subject
        $("#subjectsInput").setValue(subject).pressEnter();

        //setting hobbies
        $("#hobbiesWrapper").$(byText(hobbie)).click();

        //uploading test file
        $("#uploadPicture").uploadFile(new File(test_pic));

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
                text(birthday.day + " " + birthday.month + "," + birthday.year), text(subject),
                text(hobbie), text(test_pic), text(current_address),
                text(state+" "+city));

    }
}
