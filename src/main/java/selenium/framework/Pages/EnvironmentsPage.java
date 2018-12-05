package selenium.framework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EnvironmentsPage extends AbstractPage {

    @FindBy(css = "#content > article > nav > ul > li > a")
    private WebElement addEnvironmentButton;

    @FindBy(id = "j_info_box")
    private WebElement infoBox;

    @FindBy(css = "#j_info_box > div")
    private WebElement infoBoxIcon;

    public EnvironmentsPage(WebDriver driver){
        super(driver);
    }

    public AddEnvironmentPage goToAddEnvironmentPage(){
        clickElement(addEnvironmentButton);
        return new AddEnvironmentPage(driver);
    }

    public boolean isInfoBoxDisplayed(){
        return isElementDisplayed(infoBox);
    }

    public boolean isInfoBoxStatusCorrect () {
        return hasElementCorrectAttributeValue(infoBoxIcon,"class","icon_info");
    }
}