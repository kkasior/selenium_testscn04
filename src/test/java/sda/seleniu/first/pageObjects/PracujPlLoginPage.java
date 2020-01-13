package sda.seleniu.first.pageObjects;

import org.openqa.selenium.WebDriver;

public class PracujPlLoginPage {
    public WebDriver localDriver;
    public String url = "https://login.pracuj.pl/";

    public PracujPlLoginPage(WebDriver driver){
        this.localDriver = driver;
    }


}
