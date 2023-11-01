package pages.componets;

import static com.codeborne.selenide.Selectors.byText;

import com.codeborne.selenide.Selenide;
import cssselectors.PracticeFormPage;
import models.Date;

public class CalendarComponent {
    public void setDate(Date date) {
        Selenide.$(PracticeFormPage.cssyear).selectOption(date.year);
        Selenide.$(PracticeFormPage.cssmonth).selectOption(date.month);
        Selenide.$(PracticeFormPage.cssday).$(byText(date.day)).click();
    }
}
