package sda.seleniu.first.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracujPlMainPage { //reprezentacja strony pracuj.pl jako klasy Page Object
    public WebDriver localDriver; //definicja lokalnej przeglądarki w obrębie tej klasy
    public String url = "https://pracuj.pl"; //definicja adresu url przegląrki

    public PracujPlMainPage(WebDriver driver){ //stworzenie konstruktora i przekazanie przeglądarki z PageObjectsTests
        this.localDriver = driver; //podmiana przekazanej przeglądarki na lokalną
        this.localDriver.get(url); //otworzenie adresu url klasy/strony w przeglądarce
    }

    public By SignUpButtonPath = By.className("odP7vM"); //deklaracja ścieżki lokatora do odnalezienia buttona na stronie pracuj.pl

    public PracujPlLoginPage clickSignUpButton(){
        WebElement signUpButton = localDriver.findElement(SignUpButtonPath); //odnalezienie buttona i przypisanie go jako WebElement
        signUpButton.click(); // kliknięcie przycisku przekierowującego na stronę PracujPlLoginPage
        return new PracujPlLoginPage(localDriver); //zwracamy nowy obiekt klasy PracujPlLoginPage(budujemy stronę Page Object - PracujPlLoginPage)
    //przekazujemy localDriver to konstruktora PracujPlLoginPage
    }
}
