package helpers;

import java.io.File;

public class AppReadHelpers {

    public File getApk(String path) {
        File app = new File(path);
        if (!app.exists()) {
            throw new RuntimeException("APK file not found: " + app.getAbsolutePath());
        }
        return app;
    }
}