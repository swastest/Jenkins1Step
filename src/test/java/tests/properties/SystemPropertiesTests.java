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

}
/* Как задается конфиг Вариант 1:   -------- Конспект для меня, я пойму все правильно, моя помойка
gradle clean test -Dbrowser=opera
                  -Dversion=99
                  -DbrowserSize=1920x100
 */