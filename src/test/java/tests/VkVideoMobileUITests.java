package tests;

import context.MobileAppDictionary;
import io.qameta.allure.Description;
import jupiter.annotation.MobileApp;
import org.junit.jupiter.api.Test;

@MobileApp(MobileAppDictionary.VK_VIDEO)
public class VkVideoMobileUITests extends BaseTest {

    @Description("Тест на проверку, что видео воспроизводится")
    @Test
    void checkVideoIsPlayingTest() {
        baseVkPage
                .pressBack();
        vkVideoMainPage
                .openVideo()
                .videoShouldBePlaying();
    }

    @Description("Тест на проверку, что видео без интернета не воспроизводится")
    @Test
    void videoShouldNotPlayWithoutInternetTest() {
        baseVkPage
                .pressBack();

        //вырубаем чебурнет епт... )))
        internetUtils().setInternet(false);

        vkVideoMainPage
                .openVideo();

        vkVideoMainPage
                .checkVideoNotPlaying();
    }
}