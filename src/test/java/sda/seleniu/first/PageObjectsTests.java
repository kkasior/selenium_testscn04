package sda.seleniu.first;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sda.seleniu.first.pageObjects.PracujPlLoginPage;
import sda.seleniu.first.pageObjects.PracujPlMainPage;

public class PageObjectsTests {

    public WebDriver driver;

    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void OpenPracujPlMainPageAndClickSignUpButton(){
        PracujPlMainPage pracujPlMainPage = new PracujPlMainPage(driver); //utworzenie nowego obiektu strony Pracul.pl (PracujPlMainPage)
        pracujPlMainPage.clickSignUpButton(); //wywołanie metody z klasy PracujPlMainPage
    }

    @Test
    public void OpenPracujPlLoginPage(){
        PracujPlMainPage pracujPlMainPage = new PracujPlMainPage(driver);
        PracujPlLoginPage pracujPlLoginPage = pracujPlMainPage.clickSignUpButton();
        //poprzez wywołanie metody clickSignUpButton() otwiera nam się strona PracujPlLoginPage
        //tworzymy nowy obiekt klasy PracujPlLoginPage
    }

}
