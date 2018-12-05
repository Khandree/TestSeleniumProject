package selenium.framework.Utils;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class AbstractDriver {

    protected CustomFileUtils customFileUtils;

    public AbstractDriver(){
        customFileUtils = new CustomFileUtils();
    }

    public WebDriver getConfiguredDriver(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
