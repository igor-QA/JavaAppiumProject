package helpers;

import io.appium.java_client.android.AndroidDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class InternetUtils {

    protected final AndroidDriver driver;

    public InternetUtils(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setInternet(boolean enabled) {
        if (enabled) {
            executeShellCommand("svc wifi enable");
            executeShellCommand("svc data enable");
        } else {
            executeShellCommand("svc wifi disable");
            executeShellCommand("svc data disable");
        }
    }

    private void executeShellCommand(String command) {
        Map<String, Object> args = new HashMap<>();
        args.put("command", "sh");
        args.put("args", Arrays.asList("-c", command));
        driver.executeScript("mobile: shell", args);
    }
}