package pages.componets;

import models.Date;
import test_data.PositiveTestDataAll;
import test_data.PositiveTestDataRequired;

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

    public static void successFormVerifier(PositiveTestDataAll testData) {
        $(".table-responsive").shouldHave(text(testData.firstname + " "
                + testData.lastname),
            text(testData.userEmail), text(testData.gender), text(testData.userNumber),
            text(testData.birth.day + " " + testData.birth.month + "," + testData.birth.year),
            text(testData.subject),
            text(testData.hobbie), text(testData.test_file), text(testData.current_address),
            text(testData.state + " " + testData.city));
    }

    public static void successFormVerifier(PositiveTestDataRequired testData) {
        $(".table-responsive").shouldHave(text(testData.firstname
                + " " + testData.lastname),text(testData.userNumber),text(testData.gender));
    }
}
