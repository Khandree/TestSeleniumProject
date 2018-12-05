package selenium.framework.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CustomFirefoxDriver extends AbstractDriver{

    public WebDriver getDriver(){

        System.setProperty("webdriver.gecko.driver",
                customFileUtils.getProjectPath() +
                        BaseProperties.driverPath +
                        BaseProperties.firefoxDriver);

        return new FirefoxDriver();
    }
}
