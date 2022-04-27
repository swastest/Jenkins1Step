package uiTest;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestDemoQa {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void  Test1 () {
        String firstName = "Aren";
        String lastName = "Karapetyan";
        String email = "romashka@mail.ru";
        String tel = "8800200060";
        String subjectsInput = "Hindi";
        String gender = "Male";
        String hobby = "Reading";
        String currentAddress = "Eto to4no Java?";
        String state = "Uttar Pradesh";
        String city = "Merrut";


        open("/automation-practice-form");


        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#userNumber").setValue(tel);
        $("#dateOfBirthInput").click();
        //$(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--004:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#genterWrapper").$(byText(gender)).click();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
       // $("input#uploadPicture").uploadFile(new File("src/test/resources/123.jpg"));
        $("input#uploadPicture").uploadFromClasspath("123.jpg");
        //  $("#uploadPicture").uploadFromClasspath(imgPath);  альтернатива,
        //  задать переменную String imgPath = "img/Pushkin.jpg";
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName+" "+lastName));
        $(".table-responsive").shouldHave(
                text(firstName+" "+lastName),
                text (email),
                text (gender),
                text (tel),
                text ("04 May,1991"),
                text (subjectsInput),
                text (hobby),
                text ("123.jpg"),
                text (currentAddress),
                text (state+" "+city)
        );
    }
}
