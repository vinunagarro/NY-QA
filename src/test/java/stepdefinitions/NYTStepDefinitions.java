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
    String firstArticleTxt = "";


    public void clickOnContinueBtn() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
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

    @When("I click on the first article")
    public void i_click_on_the_first_article() {
        WebElement firstArticle = driver.findElement(By.xpath("((//section)[4]//p)[1]"));
        firstArticleTxt = firstArticle.getText();
        firstArticle.click();

    }
    @Then("I should see the article title")
    public void i_should_see_the_article_title() {
        clickOnContinueBtn();
        WebElement titleElement = driver.findElement(By.cssSelector("h1"));
        String titleEleText = titleElement.getText();
        assert titleEleText.equals(firstArticleTxt);

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

}
