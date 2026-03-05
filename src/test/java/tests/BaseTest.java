package tests;

import com.codeborne.selenide.WebDriverRunner;
import helpers.InternetUtils;
import io.appium.java_client.android.AndroidDriver;
import page.alchemy.AlchemyGameMainPage;
import page.alchemy.BaseAlchemyPage;
import page.vk.BaseVkPage;
import page.vk.VkVideoMainPage;

public abstract class BaseTest {

    protected InternetUtils internetUtils() {
        return new InternetUtils(
                (AndroidDriver) WebDriverRunner.getWebDriver());
    }

    protected BaseVkPage baseVkPage = new BaseVkPage();
    protected VkVideoMainPage vkVideoMainPage = new VkVideoMainPage();
    protected BaseAlchemyPage baseAlchemyPage = new BaseAlchemyPage();
    protected AlchemyGameMainPage alchemyGameMainPage = new AlchemyGameMainPage();

}