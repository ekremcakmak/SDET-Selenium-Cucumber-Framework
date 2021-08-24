package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverSetup
{
    private DriverSetup(){} // singleton class

    static WebDriver driver;

    public static WebDriver getDriver()
    {

        if (driver==null) {
            String SelectedBrowser = ReadConfig.getConfig("browser");

            switch (SelectedBrowser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;
            }
        }
        Tools.sleep(1000);
       // else
       // {
            //System.out.println("Check browser - config.properities");
            //WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();
       // }
        return driver;
    }

    public static void closeDriver()
    {
        if(driver != null)
        {
            driver.quit();
            driver=null;
        }
    }


}
