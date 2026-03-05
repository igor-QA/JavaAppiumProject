package context;

public class AppContext {

    private static final ThreadLocal<MobileAppDictionary> currentApp = new ThreadLocal<>();

    public static void setApp(MobileAppDictionary app) {
        currentApp.set(app);
    }

    public static MobileAppDictionary getApp() {
        return currentApp.get();
    }

    public static void clear() {
        currentApp.remove();
    }
}