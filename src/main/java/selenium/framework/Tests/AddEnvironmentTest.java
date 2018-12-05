package selenium.framework.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.framework.Pages.AddEnvironmentPage;
import selenium.framework.Pages.DashboardPage;
import selenium.framework.Pages.EnvironmentsPage;

import java.util.Date;

public class AddEnvironmentTest extends AbstractTest {

    @Test
    public void successAddEnvironmentTest(){

        // Utworzenie obiektu dashboardPage
        DashboardPage dashboardPage = new DashboardPage(driver);

        // Przejście z dashboardu na stronę środowisk
        EnvironmentsPage environmentsPage = dashboardPage.goToEnvironmentsPage();

        // Przejście z środowisk na stronę dodawania środowiska
        AddEnvironmentPage addEnvironmentPage = environmentsPage.goToAddEnvironmentPage();

        // Uzupełnienie formularza dodawania środowiska
        // wysłanie formularza dodawania środowiska
        environmentsPage = addEnvironmentPage
                .fillAddEnvironmentForm("Environment_" + new Date().getTime(), "opis")
                .submitAddEnvironmentForm();

        // Sprawdzenie czy infobox został wyświetlony
        Assert.assertTrue(environmentsPage.isInfoBoxDisplayed());
        Assert.assertTrue(environmentsPage.isInfoBoxStatusCorrect());
    }
}
