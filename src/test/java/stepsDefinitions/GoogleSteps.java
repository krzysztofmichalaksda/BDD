package stepsDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSteps {

    private ChromeDriver driver;

    @Before
    public void beforeScenario()
    {
        // aby uruchomić testy należy pobrać chromrdriver odpowiedni do wersji waszej przeglądarki
        // oraz wskazać ścieżkę do chromedrivera na waszym komputerze jako drugi argument do setProperty(1,2)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Krzysztof\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();

        // Ustawiamy opcję czekania na element na 20 sekund
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    @When("^I open (.*)$")
    public void startPage(String url)
    {
        // funkcja navigate().to() wywołana na driver otwiera adres jaki podamy jako argument
        driver.navigate().to(url);
    }

    @When("^I type '(.*)' in text input$")
    public void fillInputText(String text)
    {
        // Wprowadzamy text do wyszukania
        driver.findElement(By.name("q")).sendKeys(text);
    }

    @When("^I click search button$")
    public void clickSearch()
    {
        // Komentarz - klikamy w logo, aby zwinąć podpowiedzi i móc kliknąć Szukaj
        driver.findElement(By.id("hplogo")).click();

        // Klikamy przycisk 'Szukaj w Google'
        driver.findElement(By.xpath(".//*[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).click();
    }

    @Then(  "^(?:I|the user) should see '(.*)' as a first search result$")
    public void assertFirstResult(String expectedSite)
    {
        // Pobieramy elementy wszystkich wyszukanych stron
        List<WebElement> searchedSites = driver.findElements(By.xpath("//*[@class='iUh30 bc']"));

        // Pobieramy text z pierwszego wyszukanej strony index 0 oznacza pierwszy element z listy.
        String firstSite = searchedSites.get(0).getText();

        // Sprawdzamy czy pierwsza wyszukana strona zawiera spodziewany text - czyli naszą szukaną stronę
        Assert.assertTrue(firstSite.contains(expectedSite));
    }

    @When("^a user searches '(.*)' in google$")
    public void searchTextInGoogle(String text)
    {
        driver.navigate().to("https://google.pl");
        driver.findElement(By.name("q")).sendKeys(text);
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }

    @After
    public void after()
    {
        if (driver != null) {
            driver.close();
        }
    }
}
