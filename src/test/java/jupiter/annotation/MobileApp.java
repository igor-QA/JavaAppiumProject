package jupiter.annotation;


import context.MobileAppDictionary;
import jupiter.extension.AppExtension;
import jupiter.extension.MobileDriverExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ExtendWith({AppExtension.class, MobileDriverExtension.class})
public @interface MobileApp {
    MobileAppDictionary value();
}