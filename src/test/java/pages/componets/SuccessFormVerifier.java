package pages.componets;

import models.Date;
import test_data.PositiveTestDataAll;
import test_data.PositiveTestDataRequired;
import test_data.PositiveTextBoxData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class SuccessFormVerifier {

    public static void successFormVerifier(String firstname, String lastname, String userEmail,
        String gender, String userNumber, Date date,
        String subject, String hobbie, String test_file,
        String current_address, String state, String city) {

        $(".table-responsive").shouldHave(text(firstname + " " + lastname),
            text(userEmail), text(gender), text(userNumber),
            text(date.day + " " + date.month + "," + date.year), text(subject),
            text(hobbie), text(test_file), text(current_address),
            text(state + " " + city));
    }

    public static void successFormVerifier(String firstname, String lastname,
        String gender, String userNumber) {

        $(".table-responsive").shouldHave(text(firstname + " " + lastname),
            text(gender), text(userNumber));
    }

    public static void successFormVerifier(String firstname, String lastname, String userEmail,
        String current_address, String permanent_address) {
        $("#output").shouldHave(text(firstname
                + " " + lastname), text(userEmail), text(current_address),
            text(permanent_address));
    }
}
