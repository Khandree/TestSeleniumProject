package selenium.framework.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomChromeDriver extends AbstractDriver{

    public WebDriver getDriver(){

        System.setProperty("webdriver.chrome.driver",
                customFileUtils.getProjectPath() +
                        BaseProperties.driverPath +
                        BaseProperties.chromeDriver);

        return new ChromeDriver();
    }
}
