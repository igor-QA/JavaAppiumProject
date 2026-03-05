package page.vk;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class BaseVkPage {

    private AndroidDriver getDriver() {
        return (AndroidDriver) WebDriverRunner.getWebDriver();
    }

    private final SelenideElement skipButton =
            $(AppiumBy.id("com.vk.vkvideo:id/fast_login_tertiary_btn"));

    @Step("Пропустить авторизацию если отображается")
    public BaseVkPage skipAuthorizationIfPresent() {
        if (skipButton.is(visible)) {
            skipButton.click();
        }
        return this;
    }

    @Step("Нажимаем кнопку назад, что бы закрыть pop up")
    public void pressBack() {
        if (skipButton.isDisplayed()) {
            getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }
}