package selenium.framework.Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import selenium.framework.Utils.BaseProperties;
import selenium.framework.Utils.CustomFileUtils;
import selenium.framework.Utils.CustomScreenshot;
import selenium.framework.Utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    protected static WebDriver driver;
    protected static CustomFileUtils customFileUtils;
    protected static CustomScreenshot customScreenshot;
    private DriverFactory driverFactory;

    @BeforeTest
    @Parameters ({"deleteScreenshots", "browser"})
    public void setUpTest(String deleteScreenshots, String browser) {
        customFileUtils = new CustomFileUtils();
        customScreenshot = new CustomScreenshot();
        driverFactory = new DriverFactory();

        driver = driverFactory.getDriver(browser);

        driver.get(BaseProperties.baseUrl);

        if (deleteScreenshots.equalsIgnoreCase("true")) {
            customFileUtils.deleteProjectDirectory(BaseProperties.screenshotPath);
        }
    }

    @AfterMethod
    @Parameters({"makeScreenshot"})
    public void tearDownMethod(ITestResult result, String makeScreenshot) {

        if (makeScreenshot.equalsIgnoreCase("onFailure")) {
            if (result.getStatus() == ITestResult.FAILURE) {
                customScreenshot.makeScreenshot(
                        driver,
                        new Date().getTime()+"_"+
                                result.getMethod().getMethodName()+"_"+
                                BaseProperties.statusNames[result.getStatus()+1]

                );
            }
        } else {
            customScreenshot.makeScreenshot(
                    driver,
                    new Date().getTime()+"_"+
                            result.getMethod().getMethodName()+"_"+
                            BaseProperties.statusNames[result.getStatus()-1]
            );
        }
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
    }
}
