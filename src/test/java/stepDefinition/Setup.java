package stepDefinition;

import CommonHelper.Log;
import UIController.AppiumHelper;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Setup {
    public static Properties config;
    public static Scenario scenario = null;
    public AppiumHelper appiumHelper;


    @Before
    public void beforeAll(Scenario scenario) {
        try {
            Log.startTest(scenario.getName());
            Setup.scenario = scenario;

            config = new Properties();
            FileInputStream fis;
            if (scenario.getName().contains("LINKED_IN")) {
                Log.info("Loading app properties: Linkedin");
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config_linkedin.properties");
            } else if (scenario.getName().contains("ZOOM")) {
                Log.info("Loading app properties: Zoom");
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config_zoom.properties");
            } else if (scenario.getName().contains("API")) {
                Log.info("Loading API properties");
                fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config_Api.properties");
            } else {
                Log.error("App name not found in scenario");
                return;
            }
            config.load(fis);

            if (!scenario.getSourceTagNames().contains("API") && !scenario.getName().contains("API")) {
                try {
                    appiumHelper = new AppiumHelper();
                    appiumHelper.appLaunch(config);
                    AppiumHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @After
    public void afterAll(Scenario scenario) {
        Log.info("Result for" + scenario.getName() + ": " + scenario.getStatus());
        if (!scenario.getSourceTagNames().contains("API") && !scenario.getName().contains("API")) {
            appiumHelper.appClose();
        }
        Log.endTest();
    }
}
