package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import runners.TestRunner;

import java.sql.Struct;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class NYTStepDefinitions {

    WebDriver driver = new ChromeDriver();
    String getWorldNewsText = "";


    public void clickOnContinueBtn() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue')]")));
        WebElement continueBtn = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));

        if(continueBtn.isDisplayed()){
            continueBtn.click();
        }

    }

    @Given("I navigate to the New York Times homepage")
    public void i_navigate_to_the_new_york_times_homepage() {
        driver.get("https://www.nytimes.com/international/");
        driver.manage().window().maximize();
        clickOnContinueBtn();
    }
    @Then("I should see {string} in the header")
    public void i_should_see_in_the_header(String expectedText) {
        String actualText = driver.findElement(By.xpath("//a[@href='https://www.nytimes.com/section/todayspaper']")).getText();
        assert actualText.contains(expectedText);
        driver.close();
    }

    @When("I search for {string}")
    public void i_search_for(String keyword) {

        WebElement searchBtn = driver.findElement(By.xpath("//button[@aria-controls='search-input']"));
        searchBtn.click();
        WebElement searchBox = driver.findElement(By.name("query"));
        searchBox.sendKeys(keyword);
        searchBox.submit();
    }
    @Then("I should see articles related to {string}")
    public void i_should_see_articles_related_to(String keyword) {
        clickOnContinueBtn();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement articleTitle = driver.findElement(By.xpath("//ol[@data-testid='search-results']//li//a//h4[1]"));
        String relatedKeyWord = articleTitle.getText();
        relatedKeyWord = relatedKeyWord.toUpperCase();
        assert relatedKeyWord.contains(keyword);
        driver.close();
     }

    @When("I click on the {string} footer link")
    public void i_click_on_the_footer_link(String linkText) {
        WebElement footerLink = driver.findElement(By.linkText(linkText));
        footerLink.click();
    }
    @Then("I should be redirected to the contact page")
    public void i_should_be_redirected_to_the_contact_page() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("Contact"));
        driver.close();
    }

    @When("I click on the world news")
    public void i_click_on_the_world_news() {
        WebElement getWorldNews = driver.findElement(By.xpath("(//li[@data-navid='World'])[2]"));
        String getWorldNewsText = getWorldNews.getText();
        getWorldNews.click();
    }

    @Then("I should see the world news title")
    public void i_should_see_the_world_news_title() {
        clickOnContinueBtn();
        WebElement WorldNewsTitle = driver.findElement(By.cssSelector("h1"));
        String titleEleText = WorldNewsTitle.getText();
        assert  titleEleText.contains(getWorldNewsText);
        driver.close();
    }

}
