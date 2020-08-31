package com.ui.test;

import com.codeborne.selenide.*;
import com.api.ProjectConfig;
import com.ui.SelenoidDriverProvider;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

public class BaseUITest {
    @BeforeSuite
    public void setUp() {
        ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties(), System.getenv());
        RestAssured.baseURI = config.baseUrlAPI();
        Configuration.baseUrl = config.baseUrlUI();

        if (config.remoteDriverUrl() != null) {
            Configuration.browser = "com.ui.SelenoidDriverProvider";
        } else {
            try {
                // Hack because I have chrome 84 and webdriver give me chromedriver for 85 version.
                if (config.browser().equalsIgnoreCase("chrome")) {
                    ChromeDriverManager.chromedriver().browserVersion("84").setup();
                } else {
                    Configuration.browser = config.browser();
                }
            } catch (NullPointerException e) {
                System.out.println("--- You can provide browser browser=firefox/chrome ---");
                ChromeDriverManager.chromedriver().browserVersion("84").setup();
            }
            // Was faced an issue on Linux
            Configuration.reportsFolder = "/tmp/";
            Configuration.startMaximized = true;
        }
    }


    protected <T> T at(Class<T> pageClass) {
        return Selenide.page(pageClass);
    }
}
