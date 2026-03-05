package jupiter.extension;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import context.AppContext;
import drivers.MobileDriverProvider;
import helpers.InternetUtils;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class MobileDriverExtension implements BeforeAllCallback, BeforeEachCallback,
        AfterEachCallback, TestExecutionExceptionHandler {

    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.browser = MobileDriverProvider.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        if (AppContext.getApp() == null) {
            throw new IllegalStateException(
                    "@MobileTest is not specified for this test class"
            );
        }

        Selenide.open();
        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
        );
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context,
                                             Throwable throwable) throws Throwable {
        String testName = context.getRequiredTestMethod().getName();

        if (WebDriverRunner.hasWebDriverStarted()) {
            Allure.addAttachment(
                    "Screen after test"+ testName,
                    new ByteArrayInputStream(
                            ((TakesScreenshot) WebDriverRunner.getWebDriver())
                                    .getScreenshotAs(OutputType.BYTES)
                    )
            );
        }

        throw throwable;
    }

    @Override
    public void afterEach(ExtensionContext context) {
        if (WebDriverRunner.hasWebDriverStarted()) {
            new InternetUtils(
                    (AndroidDriver) WebDriverRunner.getWebDriver()
            ).setInternet(true);
            Selenide.closeWebDriver();
        }
    }
}