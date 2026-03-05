package tests;

import context.MobileAppDictionary;
import io.qameta.allure.Description;
import jupiter.annotation.MobileApp;
import org.junit.jupiter.api.Test;

@MobileApp(MobileAppDictionary.ALCHEMY)
public class AlchemyMobileUITests extends BaseTest {

    @Description("Тест на проверку, что количество подсказок было увеличено и значение = { 4 }")
    @Test
    void checkHintsInAlchemyGameTest() {
        baseAlchemyPage
                .closeInstallWindows();

        alchemyGameMainPage
                .clickHints()
                .checkHintsCount();
    }
}