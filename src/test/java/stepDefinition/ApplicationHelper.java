package stepDefinition;

import CommonHelper.Log;
import io.cucumber.java.en.Given;

public class ApplicationHelper {

    @Given("user launches the {string} app")
    public void userLaunchesTheApp(String app) {
        switch (app.toUpperCase()) {
            case "ZOOM":
                Log.info("launching Zoom app");
                break;
            case "LINKEDIN":
                Log.info("launching Linkedin app");
                break;
            default:
                break;
        }
    }
}
