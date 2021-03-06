package tests.uiTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import confid.CredentialsConfig;
import helpersAttach.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static java.lang.String.format;

public class TestBase {
    // CredentialsConfig - название моего класса  ИИИ ConfigFactory - библиотечная штука

    @BeforeAll
    static void setUp() {
        // CredentialsConfig - название моего класса  ИИИ ConfigFactory - библиотечная штука
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()); //Алюр лисенер

     /*   Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com"); // задать в дженкинс
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080"); // задать в дженкинс
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";  //  https://логин:пароль@хост/веб-драйвер/и что то там
*/
        String propertyBrowserSize = System.getProperty("propertyBrowserSize","1980x1024");
        String propertyBaseUrl = System.getProperty("propertyBaseUrl","https://demoqa.com");
        String login = config.login();
        String password = config.password();
        String propertyUrl = config.url();
        String https = "https://";
        String fullSelenoidUrlWithLogPass = format("%s%s%s%s", https, login, password, propertyUrl);

        Configuration.browserSize = propertyBrowserSize;
        Configuration.baseUrl = propertyBaseUrl;
        Configuration.remote = fullSelenoidUrlWithLogPass;
      //  Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        //Добавить видео-пруф-аттач  и  это еще не все, так как надо добавить метод см. ниже в классе addAttachments

        DesiredCapabilities capabilities = new DesiredCapabilities(); // набор ключей и значений
        capabilities.setCapability("enableVNC", true); // трнаслировать видео - тру
        capabilities.setCapability("enableVideo", true); // делать видео - тру
        Configuration.browserCapabilities = capabilities; // для более тонкой настройки драйвера, иногда подсказывают фрондендеры
    }

    @AfterEach
    @DisplayName("Добавить пруфы")
    void addAttachments() {
        Attach.screenshotAs("Итоговый скрин");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();  // добавила видео
        closeWebDriver(); // закрыть веб драйвер, чтобы длина видео была не на полчаса, а на вркемя прохождения теста
    }

}

//-Dbrowser=$(BROWSER)
//-DanyText="$(ANY_TEXT)"