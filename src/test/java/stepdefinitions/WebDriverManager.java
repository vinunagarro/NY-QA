package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

class WebDriverManager {

    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        Browsers browser = Browsers.valueOf(browserName.toUpperCase());
        switch (browser) {
            case FIREFOX:
                System.out.println("Launching Firefox");
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.out.println("Launching Chrome");
                 driver = new ChromeDriver();
                break;
            case IE:
                System.out.println("Launching IE");
                 driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("You have selected a browser that isn't available.");
        }

        return driver;
    }

    private enum Browsers {
        FIREFOX, CHROME, IE
    }
}
