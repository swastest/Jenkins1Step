package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag ("propertiesTests")
public class SystemPropertiesTests {
    @Test
    void someTest00(){
        String browser = System.getProperty("browser");
        System.out.println(browser); // null
    }


      @Test
    void someTest01(){
        System.setProperty("browser", "opera"); // задаю значение какой должб браузер
        String browser = System.getProperty("browser");
        System.out.println(browser); // opera
    }

      @Test
    void someTest02(){
        String browser = System.getProperty("browser", "safari"); // задаю дефолтное значение
        System.out.println(browser); // safari
    }

      @Test
    void someTest03(){
        System.setProperty("browser", "opera"); // пишу какое значение должно быть вместо дефолтного ключ боаузер значение название браузера
        String browser = System.getProperty("browser", "safari");
        System.out.println(browser); // opera
    }

      @Test
    void someTest04(){
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "100");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }

    @Test
    void forString(){
        System.out.println("Пишу, что хочу: " + System.getProperty("anyText"));
    }

}
/* Как задается конфиг:   -------- Конспект для меня, я пойму все правильно, моя помойка
gradle clean test -Dbrowser=opera
                  -Dversion=99
                  -DbrowserSize=1920x100


                  Если нужно запускать одни и те же тесты на разных браузерах, то это должны быть разные запуски и разные
                  таски в Дженкинс для отслеживания истории тестирования.
                  Если на разных расрешениях, тогда тоже должны быть разные сборки для этого, опять же для чистоты истории в дженкинс

                  Настроить (в сборке дженкинс)
                  Генерал - "Это - параметризованная сборка"
                  Имя - Имя параметра КАПСОМ: BROWSER
                  Варианты - перечисляю параметры каждый с новой строки: chrome
                                                                         firefox
                                                                         opera
                   Сборка - Tasks : clean
                                    propertiesTests  - название Тега теста, кот нужно запустить, есди нужнов се то просто нужно написать test (clean test)
                                    -Dbrowser=$(BROWSER) - бак и в скобках наименование параметра!!!!
                                    и новый параметр с новой строки

 */