package steps;

import Constants.constant;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class BaseStep {

    private static WebDriver driver;
    public final static int TIMEOUT = 30;
    public final static int PAGE_LOAD_TIMEOUT = 50;

    void openBrowser(String browserType) {

        switch (browserType) {
            case constant.chromeBrowser:
                driver = new ChromeDriver();
                break;

        }


        setWebDriver(driver);

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));

    }


    public static WebDriver getDriver() {

        return driver;
    }

    public static void setWebDriver(WebDriver driver1) {

        driver=driver1;
    }

    void openUrl(String url){
        getDriver().get(url);

    }


    public static void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }

    }

}