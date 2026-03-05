package page.vk;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VkVideoMainPage {

    private final SelenideElement previewVideo =
            $(AppiumBy.id("com.vk.vkvideo:id/preview"));

    private final SelenideElement subtitle =
            $(AppiumBy.id("com.vk.vkvideo:id/subtitle"));

    private final SelenideElement offlineContainer =
            $(AppiumBy.id("com.vk.vkvideo:id/offline_container"));

    @Step("Открыть первое видео")
    public VkVideoMainPage openVideo() {
        previewVideo.shouldBe(visible).click();
        return this;
    }

    @Step("Проверить, что видео воспроизводится")
    public VkVideoMainPage videoShouldBePlaying() {
        subtitle.shouldBe(visible);
        return this;
    }

    @Step("Проверить, что видео без интернета не воспроизводиться")
    public VkVideoMainPage checkVideoNotPlaying() {
        offlineContainer.shouldNotBe(visible);
        return this;
    }
}