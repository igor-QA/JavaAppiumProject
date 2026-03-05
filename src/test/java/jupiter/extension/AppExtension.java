package jupiter.extension;

import context.AppContext;
import jupiter.annotation.MobileApp;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class AppExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {

        MobileApp annotation =
                context.getRequiredTestClass().getAnnotation(MobileApp.class);

        if (annotation == null) {
            throw new IllegalStateException("@MobileTest is not specified");
        }

        AppContext.setApp(annotation.value());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        AppContext.clear();
    }
}