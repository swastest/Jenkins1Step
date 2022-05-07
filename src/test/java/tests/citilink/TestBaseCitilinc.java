package tests.citilink;

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

public class TestBaseCitilinc {
    @BeforeAll
    static void setUpCitilinc(){
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String propertyBrowserSize = System.getProperty("propertyBrowserSize","1980x1024");
        String propertyBaseUrl = System.getProperty("propertyBaseUrl","https://www.citilink.ru/");
        String login = config.login();
        String password = config.password();
        String propertyUrl = config.url();
        String https = "https://";
        String fullSelenoidUrlWithLogPass = format("%s%s%s%s", https, login, password, propertyUrl);

        Configuration.browserSize = propertyBrowserSize;
        Configuration.baseUrl = propertyBaseUrl;
        Configuration.remote = fullSelenoidUrlWithLogPass;

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
