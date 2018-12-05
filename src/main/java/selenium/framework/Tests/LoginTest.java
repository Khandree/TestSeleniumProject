package selenium.framework.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.framework.Pages.DashboardPage;
import selenium.framework.Pages.LoginPage;
import selenium.framework.Utils.BaseProperties;

public class LoginTest extends AbstractTest {

    @Test
    public void successLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage =
                loginPage
                        .fillLoginForm(BaseProperties.baseAdminEmail, BaseProperties.baseAdminPassword)
                        .submitLoginForm();

        Assert.assertTrue(dashboardPage.isLogoutButtonDisplayed());
    }
}