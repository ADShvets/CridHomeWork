package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.CheckImageClass;
import pages.SqlTableClass;
import pages.TestIframePage;

public class BaseTest {

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public SqlTableClass getSqlTableClass() {
        return new SqlTableClass();
    }

    public CheckImageClass getCheckImageClass() {
        return new CheckImageClass();
    }

    public TestIframePage getTestIframePage() {
        return new TestIframePage(getDriver());
    }


}

