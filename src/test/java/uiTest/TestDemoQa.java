package uiTest;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class TestDemoQa extends TestBase {
    // конфиги убрала в класс TestBase и прописала название класса через extends выше
    @Test
    @Owner("Kazakova")
    @DisplayName("Старая-добрая формаТест")
    void test1() {
        String firstName = "Aren",
                lastName = "Karapetyan",
                email = "romashka@mail.ru",
                tel = "8800200060",
                subjectsInput = "Hindi",
                gender = "Male",
                hobby = "Reading",
                currentAddress = "Eto to4no Java?",
                state = "Uttar Pradesh",
                city = "Merrut",
                expectedFullName = format("%s %s", firstName, lastName),
                fullStateCity = format("%s %s", state, city);

        step("Открыть форму регистрации", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
        });

        step("Заполнить форму регистации", () -> {
            $("#firstName").setValue(firstName);
            $("#lastName").setValue(lastName);
            $("#userEmail").setValue(email);
            $("#userNumber").setValue(tel);
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("1991");
            $(".react-datepicker__day--004:not(.react-datepicker__day--outside-month)").click();
            $("#subjectsInput").setValue(subjectsInput).pressEnter();
            $("#genterWrapper").$(byText(gender)).click();
            $("#hobbiesWrapper").$(byText(hobby)).click();
            $("#currentAddress").setValue(currentAddress);
            $("#react-select-3-input").setValue(state).pressEnter();
            $("#react-select-4-input").setValue(city).pressEnter();
            $("input#uploadPicture").uploadFromClasspath("123.jpg");
            $("#submit").click();
        });

        step("Проверить данные из формы регистрации", () -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
            $(".table-responsive").shouldHave(
                    text(expectedFullName),
                    text(email),
                    text(gender),
                    text(tel),
                    text("04 May,1991"),
                    text(subjectsInput),
                    text(hobby),
                    text("123.jpg"),
                    text(currentAddress),
                    text(fullStateCity));
        });
    }
}
