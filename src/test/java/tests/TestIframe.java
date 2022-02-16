package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;


public class TestIframe extends BaseTest {
    private static final long TIME_TO_WAIT = 15;
    private final CapabilityFactory capabilityFactory = new CapabilityFactory();
    private static final String W3SCHOOLS_URL = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe";

    String newScript = "<iframe src=\"https://www.bing.com\" title=\"W3Schools Free Online Web Tutorials\">";
    String searchWord = "redmond";
    String searchQueryFromSearchResults = "redmond washington";
    String searchedLink = "https://bing.com/travelguide?q=Redmond";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {

        driver.set(new RemoteWebDriver(new URL("http://192.168.0.102:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(W3SCHOOLS_URL);
    }

    @Test
    public void testTreeIframe() {
        getTestIframePage();
        getTestIframePage().enterNewScript(newScript);
        getTestIframePage().clickButtonRun();
        getTestIframePage().implicitWait(TIME_TO_WAIT);
        getTestIframePage().switchToIframeResult();
        getTestIframePage().switchToIframeResultBinqCom();
        getTestIframePage().clickSearchField();
        getTestIframePage().sendSearchWord(searchWord);
        getTestIframePage().switchToParentFrame();
        getTestIframePage().implicitWait(TIME_TO_WAIT);
        for (WebElement webElement : getTestIframePage().getListOfResultSearch()) {
            Assert.assertTrue(webElement.getAttribute("aria-label").contains(searchQueryFromSearchResults));
        }
        getTestIframePage().switchToDefaultIframe();
        getTestIframePage().implicitWait(TIME_TO_WAIT);
        getTestIframePage().selectTheDesiredSearchResult();
        Assert.assertEquals(getTestIframePage().getLinKToCheckResults().getText(), searchedLink);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }
}

//-------------------------------------------------------------------------------------
//The following code works with Selenium 4
//-------------------------------------------------------------------------------------
//
//public class TestIframe {
//    private WebDriver driver;
//
//    @BeforeTest
//    public void proFileSetup() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//    }
//
//    @BeforeMethod
//    public void testsSetUp() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe");
//    }
//
//    @Test
//    public void checkThatUrlContainsSearchWord() throws InterruptedException {
//        Actions mouse2 = new Actions(driver);
//        WebElement fieldText = driver.findElement(By.xpath("//div[@class='CodeMirror-scroll']"));
//        String newText = "<iframe src=\"https://www.bing.com\" title=\"W3Schools Free Online Web Tutorials\">";
//        mouse2.doubleClick(fieldText);
//        for (int i = 0; i < fieldText.getText().length() * 2; i++) {
//            mouse2.sendKeys(BACK_SPACE);
//        }
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        mouse2.clickAndHold(fieldText).sendKeys(newText).build().perform();
//        driver.findElement(By.xpath("//button[contains(text(),'Run')]")).click();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.switchTo().frame("iframeResult");
//        WebElement frame = driver.findElement(By.xpath("//iframe[@src='https://www.bing.com' and contains(@title,'W3Schools Free Online Web Tutorials')]"));
//        driver.switchTo().frame(frame);
//        WebElement field = driver.findElement(By.xpath("//input[@class='sb_form_q']"));
//        field.click();
//        field.sendKeys("redmond");
//        driver.switchTo().parentFrame();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        List<WebElement> elementList = driver.findElements(xpath("//li[contains(@aria-label,'redmond')]"));
//        for (WebElement webElement : elementList) {
//            Assert.assertTrue(webElement.getAttribute("aria-label").contains("redmond washington"));
//        }
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.switchTo().frame(frame);
//        field.sendKeys(Keys.DOWN);
//        field.sendKeys(Keys.DOWN);
//        field.sendKeys(Keys.ENTER);
//        WebElement c = driver.findElement(By.xpath("//cite[text()='https://bing.com/travelguide?q=Redmond']"));
//        Assert.assertEquals(c.getText(), "https://bing.com/travelguide?q=Redmond");
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
//}