package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configs/vkvideo.properties"
})
public interface VkVideoConfig extends MobileAppConfig,Config {

    @Override
    @Key("apkPath")
    String apkPath();

    @Override
    @Key("appPackage")
    String appPackage();

    @Override
    @Key("appActivity")
    String appActivity();
}