package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class TestIframePage extends BasePage {
    private Actions action = new Actions(driver);

    public TestIframePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='CodeMirror-scroll']")
    private WebElement scriptEntryField;
    @FindBy(xpath = "//button[contains(text(),'Run')]")
    private WebElement buttonRun;
    @FindBy(xpath = "//iframe[@src='https://www.bing.com' and contains(@title,'W3Schools Free Online Web Tutorials')]")
    private WebElement iframeResultBinqCom;
    @FindBy(xpath = "iframeResult")
    private WebElement iframeResult;
    @FindBy(xpath = "//input[@class='sb_form_q']")
    private WebElement searchField;
    @FindBy(xpath = "//li[contains(@aria-label,'redmond washington')]")
    private List<WebElement> listOfResultSearch;
    @FindBy(xpath = "//li[contains(@aria-label,'redmond washington')]")
    private WebElement clickRedmondWashington;
    @FindBy(xpath = "//cite[text()='https://bing.com/travelguide?q=Redmond']")
    private WebElement linkOnThePage;


    public void enterNewScript(String script) {
        action.clickAndHold(scriptEntryField).sendKeys(script).build().perform();
    }

    public void clickButtonRun() {
        buttonRun.click();
    }

    public void switchToIframeResult() {
        driver.switchTo().frame("iframeResult");
    }

    public void switchToIframeResultBinqCom() {
        driver.switchTo().frame(iframeResultBinqCom);
    }

    public void switchToDefaultIframe() {
        driver.switchTo().frame(iframeResultBinqCom);
    }

    public void clickSearchField() {
        searchField.click();
    }

    public void sendSearchWord(String word) {
        searchField.sendKeys(word);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public List<WebElement> getListOfResultSearch() {
        return listOfResultSearch;
    }

    public void selectTheDesiredSearchResult() {
        searchField.sendKeys(Keys.DOWN);
        searchField.sendKeys(Keys.DOWN);
        searchField.sendKeys(Keys.ENTER);
    }

    public WebElement getLinKToCheckResults() {
        return linkOnThePage;
    }
}

