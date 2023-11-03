package pages.componets;

import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.Selenide;
import cssselectors.PracticeFormPage;
import models.Date;

public class CalendarComponent {
    public void setDate(Date date) {
        Selenide.$(PracticeFormPage.cssYear).selectOption(date.year);
        Selenide.$(PracticeFormPage.cssMonth).selectOption(date.month);
        Selenide.$(PracticeFormPage.cssDay).$(byText(date.day)).click();
    }
}
