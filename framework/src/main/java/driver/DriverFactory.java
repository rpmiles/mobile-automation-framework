package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DriverFactory {

    private static final ThreadLocal<AndroidDriver> webDriver = new ThreadLocal<>();

    public static AndroidDriver getDriver() throws MalformedURLException, URISyntaxException {
        //System.out.println("Creating driver");
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        //System.out.println("Returning driver");
        return webDriver.get();
    }

    private static AndroidDriver createDriver() throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        //Galaxy S10 FE Details
        options.setDeviceName("R52Y90CM5MR"); //S10
        options.setAppPackage("org.chromium.webapk.a3948b4a768532374_v2"); //S10
        options.setAppActivity("org.chromium.webapk.shell_apk.h2o.H2OOpaqueMainActivity"); //S10

        //Galaxy A8 Details
        //options.setDeviceName("R9YT90YL90V"); //A8
        //options.setAppPackage("org.chromium.webapk.a442ebd1057037b65_v2"); //A8
        //options.setAppActivity("org.chromium.webapk.shell_apk.h2o.H2OOpaqueMainActivity"); //A8

        options.setCapability("chromeOptions", Map.of("args", List.of("--start-maximized")));
        options.setAutomationName("UiAutomator2");
        options.setCapability("uiautomator2ServerLaunchTimeout", 30000);
        options.setCapability("chromedriverExecutable", "C:\\Projects\\mobile-automation-framework\\framework\\src\\main\\java\\driver\\drivers\\chromedriver.exe");
        options.setCapability("disableWindowAnimation", true);
        //options.setCapability("logLevel", "error");
        options.setCapability("autoGrantPermissions", true);
        options.setCapability("noReset", true);
        options.setCapability("showChromedriverLog", false);  // disables chromedriver logs
        options.setCapability("enablePerformanceLogging", false);
        options.setCapability("loggingPrefs", new HashMap<String, Object>() {{
            put("driver", "WARNING");
            put("performance", "WARNING");
        }});
        options.setPlatformName("Android");
        options.ensureWebviewsHavePages();
        options.nativeWebScreenshot();

        options.setCapability("ensureWebviewsHavePages", true);
        options.setCapability("nativeWebScreenshot", true);
        options.setCapability("newCommandTimeout", 300);

        return new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    public static void cleanupDriver() {
        System.out.println("Removing driver");
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}