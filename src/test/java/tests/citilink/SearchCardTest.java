package tests.citilink;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class SearchCardTest extends TestBaseCitilinc {
    @Test
    @Owner ("Kazakova")
    @Tag ("citilinc")
    @DisplayName ("По Синитинку забавы ради")
    void test01() {
        step("Открыть главную страницу", ()->{
            Selenide.open("https://www.citilink.ru/");
        });
        step ("Открыть меню каталога", ()-> {
            $("[data-label='Каталог товаров']").click();
        });
        step ("Раскрыть раздел для компов и ноутов", ()-> {
            $("[data-category-alias='computers_and_notebooks']").hover();
        });
        step("Выбрать раздел Видеокарты", ()->{
            $("[data-title='Видеокарты']").scrollIntoView(false);
            $("[data-title='Видеокарты']").click();
        });
        step("Проверка страницы", ()->{
            $(".Subcategory__header").shouldHave(text("Видеокарты"));
            $("[title = 'Видеокарта Palit NVIDIA  GeForce RTX 3060," +
                    "  PA-RTX3060 DUAL 12G,  12ГБ, GDDR6, LHR,  Ret [ne63060019k9-190ad]']").shouldHave(text("Видеокарта"));
        });










    }
}
