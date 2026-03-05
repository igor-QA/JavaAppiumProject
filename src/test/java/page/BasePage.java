package page;


import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

/**
 * ВАЖНО @Класс сделан для информации и с целью - "вспомнить все"
 * */
public class BasePage {

    protected AndroidDriver driver() {
        return (AndroidDriver) WebDriverRunner.getWebDriver();
    }

    // ---------- NAVIGATION ----------

    protected void pressBack() {
        driver().pressKey(new KeyEvent(AndroidKey.BACK));
    }

    protected void pressHome() {
        driver().pressKey(new KeyEvent(AndroidKey.HOME));
    }

    protected void pressEnter() {
        driver().pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    // ---------- SYSTEM ----------

    protected void openNotifications() {
        driver().openNotifications();
    }

    protected void hideKeyboard() {
        driver().hideKeyboard();
    }

    // ---------- APP CONTROL ----------

    protected void terminateApp(String appPackage) {
        driver().terminateApp(appPackage);
    }

    protected void activateApp(String appPackage) {
        driver().activateApp(appPackage);
    }

    protected void restartApp(String appPackage) {
        terminateApp(appPackage);
        activateApp(appPackage);
    }
}