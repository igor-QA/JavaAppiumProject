package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:configs/alchemy.properties"
})
public interface AlchemyConfig extends MobileAppConfig, Config {

    @Override
    @Key("appPackage")
    String appPackage();

    @Override
    @Key("appActivity")
    String appActivity();
}