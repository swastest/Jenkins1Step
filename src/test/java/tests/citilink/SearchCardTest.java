package tests.citilink;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
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
        $("[title = 'Видеокарта Palit NVIDIA  GeForce RTX 3060," +
                "  PA-RTX3060 DUAL 12G,  12ГБ, GDDR6, LHR,  Ret [ne63060019k9-190ad]']").shouldHave(text("Видеокарта"));
        $("[data-index=1 target=_self]").shouldHave(text("Видеокарта"));





    }
}
