package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class DriverFactory {

    private static final ThreadLocal<AndroidDriver> webDriver = new ThreadLocal<>();

    public static AndroidDriver getDriver() throws MalformedURLException, URISyntaxException {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static AndroidDriver createDriver() throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();

        // 1. Device Info
        options.setDeviceName("R52Y90CM5MR");

        // 2. The Native App Package and Activity
        options.setAppPackage("com.goreport.mobileportal");
        options.setAppActivity(".MainActivity");

        // 3. Core Appium & Android Settings
        options.setAutomationName("UiAutomator2");
        options.setPlatformName("Android");
        options.setCapability("appium:uiautomator2ServerLaunchTimeout", 60000);
        options.setCapability("appium:newCommandTimeout", 300);

        // 4. Test Stability & Webview Fixes
        options.setCapability("appium:noReset", true);
        options.setCapability("appium:autoGrantPermissions", true);
        options.setCapability("appium:disableWindowAnimation", true);

        // --- THE "TERRACE" SLAYER SETTINGS ---

        // FIX 1: The Allow-List. This forces Appium to ignore Samsung 'Terrace' sockets.
        options.setCapability("appium:webviewDevtoolsPort", 9500);
        options.setCapability("appium:extractChromeAndroidPackageFromContextName", true);

        // FIX 2: Explicitly skip the socket scan that leads to the 'Terrace' crash
        options.setCapability("appium:enableWebviewDetailsCollection", false);

        // FIX 3: Force Chromedriver to only look for the standard WebView package
        // This stops it from checking the Samsung Internet (Terrace) package
        options.setCapability("appium:appWaitPackage", "com.goreport.mobileportal");
        options.setCapability("appium:androidWebViewImplementation", "chromium");

        // --- CHROMEDRIVER VERSION FIX ---
        options.setCapability("appium:chromedriverAutodownload", true);
        // Bypasses the version mismatch (136 vs 146)
        options.setCapability("appium:chromedriverArgs", List.of("--disable-build-check"));

        return new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    public static void cleanupDriver() {
        if (webDriver.get() != null) {
            System.out.println("- Removing driver and closing session...");
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}