package UIController;

import CommonHelper.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.Properties;

public class AppiumHelper {

    public static AppiumDriver<MobileElement> driver;
    public String host;

    public void appLaunch(Properties config) {
        try {
            if (driver == null) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                String appPath = System.getProperty("user.dir") + config.getProperty("APP_PATH");
                File appDir = new File(appPath);
                File app = new File(appDir, config.getProperty("APP_NAME"));
                String appiumUrl = "http://" + config.getProperty("APPIUM_IP") + ":" + config.getProperty("APPIUM_PORT") + "/wd/hub";
                String testName = config.getProperty("PLATFORM") + System.currentTimeMillis();

                switch (config.getProperty("PLATFORM").toUpperCase()) {
                    case "ANDROID":
                        Log.info("Launching Device: " + config.getProperty("PLATFORM").toUpperCase());
                        capabilities.setCapability("platformName", config.getProperty("PLATFORM"));
                        capabilities.setCapability("platformVersion", config.getProperty("PLATFORM_VERSION"));
                        capabilities.setCapability("testName", testName);
                        capabilities.setCapability("deviceName", config.getProperty("DEVICE_NAME"));
                        capabilities.setCapability("automationName", "UIAUTOMATOR2");
                        capabilities.setCapability("udid", config.getProperty("DEVICE_ID"));
                        capabilities.setCapability("appPackage", config.getProperty("APP_PACKAGE"));
                        capabilities.setCapability("appActivity", config.getProperty("APP_ACTIVITY"));
                        capabilities.setCapability("noSign", true);
                        capabilities.setCapability("fullReset", false);
                        capabilities.setCapability("noReset", true);
                        capabilities.setCapability("newCommandTimeout", "");
                        capabilities.setCapability("newSessionWaitTimeout", "1200");

                        capabilities.setCapability("app", app.getAbsolutePath());
                        driver = new AndroidDriver(new URL(appiumUrl), capabilities);
                        break;
                    case "IOS":
                        break;
                    default:
                        System.out.println("Platform is not correct: " + config.getProperty("PLATFORM").toUpperCase());
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void appClose() {
        try {
            if (driver != null) {
                driver.closeApp();
                driver.quit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver = null;
        }
    }

}
