package drivers;

import com.codeborne.selenide.WebDriverProvider;
import context.AppContext;
import helpers.AppReadHelpers;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static config.ConfigHelper.*;

public class MobileDriverProvider implements WebDriverProvider {
    AppReadHelpers app = new AppReadHelpers();

    @Nonnull
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        if (AppContext.getApp() == null) {
            throw new IllegalStateException("MobileApp is not set in AppContext");
        }

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        // ----- DEVICE -----
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
        options.setNoReset(true);
        options.setPlatformName(getPlatformName());
        options.setDeviceName(getDeviceName());
        options.setPlatformVersion(getPlatformVersion());

        // ----- APP -----
        options.setAppWaitActivity("*");
        options.setAutoGrantPermissions(true);
        options.setAppWaitForLaunch(true);
        //options.setDisableWindowAnimation(true);
        options.setAppPackage(getAppPackage());

        if (getAppActivity() != null && !getAppActivity().isBlank()) {
            options.setAppActivity(getAppActivity());
        }
        if (getApkPath() != null && !getApkPath().isBlank()) {
            options.setApp(app.getApk(getApkPath()).getAbsolutePath());
        }

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(getURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

}