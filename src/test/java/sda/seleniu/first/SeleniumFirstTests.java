package sda.seleniu.first;

import junit.framework.TestResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.list;

public class SeleniumFirstTests {

    public WebDriver driver; //initialization of driver in order to be available in all methods: SetUp,FirstTest,TearDown



    public void HighlightElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public void ScrollToTheBottomOfThePage(WebDriver driver){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void MoveToElementUsingActions(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void ScrollIntoView(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void RefreshThePage(){
        driver.navigate().refresh();
    }

    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
        driver = new ChromeDriver(); //use CHROME driver, open new driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void FirstTest(){
        driver.get("https://www.dev.to");

    }

    @Test
    public void TestDevTo(){
        driver.get("https://dev.to");
        WebElement elementFoundByXpath = driver.findElement(By.xpath("//*[@id=\"on-page-nav-controls\"]/div/div[1]/a[2]"));
        HighlightElement(driver,elementFoundByXpath);
    }

    @Test
    public void TestKtoryDreczy(){
        driver.get("https://dev.to");
        WebElement elementLocatedByText = driver.findElement(By.xpath("//h3[contains(normalize-space(text()),'tips on using the JS')]"));
        HighlightElement(driver, elementLocatedByText);
    }

    @Test
    public void FirstPracujPlTest(){
        driver.get("https://www.pracuj.pl");
        WebElement header = driver.findElement(By.id("kansas-header"));
        WebElement logo = header.findElement(By.tagName("h1"));
        HighlightElement(driver,logo);
        String logoAttributeInfo = logo.getCssValue("width");
    }

    @Test
    public void FindFirstChild(){
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        WebElement firstChild = driver.findElement(By.cssSelector("#leftcontainer > table > tbody > tr:nth-child(1) > td:nth-child(1)"));
        HighlightElement(driver,firstChild);
    }

    @Test
    public void LastChildTest(){
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        WebElement lastChild = driver.findElement(By.cssSelector("#leftcontainer > table > tbody > tr:nth-child(1) > td:last-child"));
        HighlightElement(driver,lastChild);
    }

    @Test
    public void LastRowTest(){
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        WebElement lastRow = driver.findElement(By.cssSelector("#leftcontainer > table > tbody > tr:last-child"));
        boolean isLastRowDisplayed = lastRow.isDisplayed();
        if(isLastRowDisplayed){
            HighlightElement(driver, lastRow);
        }
    }

    @Test
    public void FindParent(){
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        WebElement lastRow = driver.findElement(By.cssSelector("#leftcontainer > table > tbody > tr:last-child"));
        WebElement parent = lastRow.findElement(By.xpath("//tr/parent::store"));
        HighlightElement(driver,parent);
    }

    @Test
    public void IframeTest(){
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
        WebElement iframe = driver.findElement(By.tagName("iframe"));
        HighlightElement(driver,iframe);
        driver.switchTo().frame(iframe);
        WebElement logo = driver.findElement(By.tagName("a"));
        HighlightElement(driver,logo);
    }

    @Test
    public void SuperTest(){
        driver.get("https://dev.to");
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.sendKeys("testing");
        searchBar.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //od tego momentu sprawdzaj co 1 sek, czy szukane niżej elementy są dostępne na stronie, przez 10 sekund
        //jeśli elementy nie są dostępne po 10 sek na stronie - wywal sie chamie
        RefreshThePage();
        String url = driver.getCurrentUrl();
    }








    @After
    public void TearDown(){

    }
}
