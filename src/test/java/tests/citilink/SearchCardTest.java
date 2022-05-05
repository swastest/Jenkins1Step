package tests.citilink;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchCardTest {
    @Test
    void test01() {
        Selenide.open("https://www.citilink.ru/");
        $("[data-label='Каталог товаров']").click();
        $("[data-category-alias='computers_and_notebooks']").hover();
        $("[data-title='Видеокарты']").scrollIntoView(false);
        $("[data-title='Видеокарты']").click();
        $(".Subcategory__header").shouldHave(text("Видеокарты"));


    }
}
