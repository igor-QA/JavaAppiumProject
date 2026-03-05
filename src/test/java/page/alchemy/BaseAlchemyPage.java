package page.alchemy;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class BaseAlchemyPage {

    private AndroidDriver getDriver() {
        return (AndroidDriver) WebDriverRunner.getWebDriver();
    }

    private final SelenideElement button =
            $(AppiumBy.id("android:id/button2"));

    @Step("Закрыть предложение с установкой play market")
    public BaseAlchemyPage closeInstallWindows() {
        button.shouldBe(visible).click();
        return this;
    }

    @Step("Нажимаем кнопку назад, что бы закрыть pop up")
    public void pressBack() {
        if (button.isDisplayed()) {
            getDriver().pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }
}