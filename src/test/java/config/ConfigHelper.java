package config;

import context.AppContext;
import context.MobileAppDictionary;
import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static final DeviceConfig deviceConfig = ConfigFactory
            .create(DeviceConfig.class, System.getProperties());

    public static final VkVideoConfig vkVideoConfig = ConfigFactory
            .create(VkVideoConfig.class, System.getProperties());

    public static final AlchemyConfig alchemyConfig = ConfigFactory
            .create(AlchemyConfig.class,  System.getProperties());

    // ---------- DEVICE ----------

    public static String getURL() {
        return deviceConfig.remoteURL();
    }

    public static String getDeviceName() {
        return deviceConfig.deviceName();
    }

    public static String getPlatformVersion() {
        return deviceConfig.platformVersion();
    }

    public static String getPlatformName() {
        return deviceConfig.platformName();
    }

    // ---------- APP ----------

    private static MobileAppConfig getCurrentAppConfig() {

        MobileAppDictionary app = AppContext.getApp();

        if (app == null) {
            throw new IllegalStateException("MobileApp is not set in AppContext");
        }

        return switch (app) {
            case VK_VIDEO -> vkVideoConfig;
            case ALCHEMY -> alchemyConfig;
        };
    }

    public static String getApkPath() {
        return getCurrentAppConfig().apkPath();
    }

    public static String getAppPackage() {
        return getCurrentAppConfig().appPackage();
    }

    public static String getAppActivity() {
        return getCurrentAppConfig().appActivity();
    }
}