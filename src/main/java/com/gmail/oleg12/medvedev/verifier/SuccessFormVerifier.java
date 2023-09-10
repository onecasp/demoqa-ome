package com.gmail.oleg12.medvedev.verifier;

import com.gmail.oleg12.medvedev.models.Birthday;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class SuccessFormVerifier {

    public static void successFormVerifier(String firstname, String lastname, String userEmail,
                                           String gender, String userNumber, Birthday birthday,
                                           String subject, String hobbie, String test_file,
                                           String current_address, String state, String city) {

        $(".table-responsive").shouldHave(text(firstname+" "+lastname),
                text(userEmail), text(gender), text(userNumber),
                text(birthday.day + " " + birthday.month + "," + birthday.year), text(subject),
                text(hobbie), text(test_file), text(current_address),
                text(state+" "+city));
    }
}
