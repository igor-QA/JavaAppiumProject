package page.alchemy;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class AlchemyGameMainPage {

    private final SelenideElement hints =
            $(AppiumBy.accessibilityId("Подсказка"));

    private final SelenideElement opened =
            $(AppiumBy.id("com.ilyin.alchemy:id/opened"));

    @Step("Кликнуть на подсказки")
    public AlchemyGameMainPage clickHints() {
        hints.shouldBe(visible).click();
        return this;
    }

    @Step("Проверить количество подсказок")
    public AlchemyGameMainPage checkHintsCount() {
        opened.shouldHave(exactText("4"));
        return this;
    }
}