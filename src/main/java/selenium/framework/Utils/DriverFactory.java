package selenium.framework.Utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public WebDriver getDriver(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {
            CustomChromeDriver customChromeDriver = new CustomChromeDriver();
            return customChromeDriver.getConfiguredDriver(
                    customChromeDriver.getDriver());
        } else if (browserType.equalsIgnoreCase("firefox")) {
            CustomFirefoxDriver customFirefoxDriver = new CustomFirefoxDriver();
            return customFirefoxDriver.getConfiguredDriver(
                    customFirefoxDriver.getDriver());
        } else {
            CustomChromeDriver customChromeDriver = new CustomChromeDriver();
            return customChromeDriver.getConfiguredDriver(
                    customChromeDriver.getDriver());

        }
    }
}
