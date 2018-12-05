package selenium.framework.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.framework.Pages.AddVersionPage;
import selenium.framework.Pages.DashboardPage;
import selenium.framework.Pages.VersionsPage;

import java.util.Date;

public class AddVersionTest extends AbstractTest {

    @Test
    public void successAddVersionTest(){

        // Utworzenie obiektu dashboardPage
        DashboardPage dashboardPage = new DashboardPage(driver);

        // Przejście z dashboardu na stronę wersji
        VersionsPage versionsPage = dashboardPage.goToVersionsPage();

        // Przejście z wersji na stronę dodawania wersji
        AddVersionPage addVersionPage = versionsPage.goToAddVersionPage();

        // Uzupełnienie formularza dodawania wersji
        // wysłanie formularza dodawania wersji
        versionsPage = addVersionPage
                .fillAddVersionForm("Version_" + new Date().getTime(), "opis")
                .submitAddVersionForm();

        // Sprawdzenie czy infobox został wyświetlony
        Assert.assertTrue(versionsPage.isInfoBoxDisplayed());
        Assert.assertTrue(versionsPage.isInfoBoxStatusCorrect());
    }
}