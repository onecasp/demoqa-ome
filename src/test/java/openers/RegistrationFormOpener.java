package openers;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormOpener {
    public static void registrationFormOpener() {
        open("/automation-practice-form");

        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}
