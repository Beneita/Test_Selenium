package fr.selenium.Martarelli.Benedetta;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	private static String URL = "http://www.fr.jal.co.jp/frl/en/";
	private static final String PATH_CHROME_DRIVER = "C:\\chromedriver.exe";
	public static WebDriver driver;
	// attesa implicita che permette di eliminare le pause

	public static void firstTest() { // dove creare key/value della classe properties
		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		pausa(5);

		// dichiaro le variabili per andare a recuperare i valori e verificare che sono
		// giusti
		// lo faccio per alcuni variabili. per il price uso altro metodo e la variabile
		// la dichiaro dopo
		String departureDate = "";
		String arrivalDate = "";
		String departureVille = "";
		String arrivalVille = "";
		String price = "";

		WebElement element = driver.findElement(By.cssSelector(".JS_ciBox_submit"));
		element.click();
		Select s = new Select(driver.findElement(By.id("mdlDepLocation1")));
		s.selectByValue("NCE");
		Select r = new Select(driver.findElement(By.id("mdlArrLocation1")));
		r.selectByValue("OKA");
		Select t = new Select(driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")));
		t.selectByValue("7");
		Select f = new Select(driver.findElement(By.id("DEPARTURE_DATE_1_DAY")));
		f.selectByValue("13");
		Select g = new Select(driver.findElement(By.id("DEPARTURE_DATE_2_DAY")));
		g.selectByValue("29");
		Select h = new Select(driver.findElement(By.id("CFF_1")));
		h.selectByValue("1JE");
		Select i = new Select(driver.findElement(By.id("mdlNbAdt")));
		i.selectByValue("1");
		Select l = new Select(driver.findElement(By.id("mdlNbChd")));
		l.selectByValue("0");
		Select m = new Select(driver.findElement(By.id("mdlNbInf")));
		m.selectByValue("0");

		WebElement element1 = driver.findElement(By.cssSelector(".searchBtn"));
		element1.click();

		String price2 = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
		System.out.println(price2);

		try {
			System.out.println(LocalDateTime.now());
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"))));
		} catch (TimeoutException e) {
			System.out.println("J'ai pas trouver ton Web Element et maintenant est: " + LocalDateTime.now());
		}

		// condizioni per aprire show detail nella 2 pagina dove cerco il volo da
		// paragonare al volo dell'ultima pagina.
		// In questo caso anditions.

		if (driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).isDisplayed()) {
			System.out.println("le flight number s'affiche");
		} else {
			System.out.println("le flight number s'affiche PAS. On click pour l'afficher");
			driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(0).click();

		}
		WebElement element3 = driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"));
		String volPar = element3.getText();
		System.out.println("Flight Number: " + volPar);

		try {
			System.out.println(LocalDateTime.now());
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"))));
			System.out.println("Ho trovato il valore dell' elemento ed é : " + LocalDateTime.now());
		} catch (TimeoutException e) {
			System.out.println("J'ai pas trouver ton Web Element et maintenant est: " + LocalDateTime.now());
		}

		if (driver.findElement(By.cssSelector("#flightNumber-1-0 .flight-identifier")).isDisplayed()) {
			System.out.println("le flight number s'affiche");
		} else {
			System.out.println("le flight number s'affiche PAS. On click pour l'afficher");
			driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(1).click();

		}
		WebElement element8 = driver.findElement(By.cssSelector("#flightNumber-1-0 .flight-identifier"));
		String volRet = element8.getText();
		System.out.println("Flight Number: " + volRet);

		pausa(5);
		WebElement element2 = driver.findElement(By.cssSelector(".primary-button.right.ml2"));
		element2.click();

		Select n = new Select(driver.findElement(By.id("0-title")));
		n.selectByValue("MRS");

		driver.findElement(By.id("0-last-name")).sendKeys("MARTARELLI");

		driver.findElement(By.id("0-first-name")).sendKeys("BENEDETTA");

		Select o = new Select(driver.findElement(By.id("0-gender")));
		o.selectByValue("string:FEMALE");

		Select p = new Select(driver.findElement(By.id("0-birth-date-day")));
		p.selectByValue("string:01");

		Select q = new Select(driver.findElement(By.id("0-birth-date-month")));
		q.selectByValue("string:12");

		Select u = new Select(driver.findElement(By.id("0-birth-date-year")));
		u.selectByValue("string:1973");

		Select v = new Select(driver.findElement(By.id("0-nationality")));
		v.selectByValue("string:IT");

		Select z = new Select(driver.findElement(By.id("phone1-phone-country-0")));
		z.selectByValue("ITA");

		driver.findElement(By.id("phone1-phone-number-0")).sendKeys("3496798876");

		driver.findElement(By.id("email-guest-address")).sendKeys("fr@gmail.com");

		driver.findElement(By.id("email-confirm-new")).sendKeys("fr@gmail.com");

		WebElement element4 = driver.findElement(By.id("continueButton"));
		element4.click();

		WebElement element5 = driver.findElement(By.id("continueButton-PCOF"));
		element5.click();

		WebElement element6 = driver.findElement(By.id("seatContinue"));
		element6.click();

		// Recupero dati
		price = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
		System.out.println(price);

		departureVille = driver.findElement(By.id("originLocation-0")).getText();
		System.out.println(departureVille);

		departureDate = driver.findElement(By.id("originDate-0")).getText();
		System.out.println(departureDate);

		arrivalVille = driver.findElement(By.id("destinationLocation-0")).getText();
		System.out.println(arrivalVille);

		String nVolo = driver.findElement(By.id("flightNumber-0-0")).getText();
		System.out.println(nVolo);

		String hourAY1602 = driver.findElement(By.id("segmentOriginDate-0-0")).getText();
		System.out.println(hourAY1602);

		String nVolo2 = driver.findElement(By.id("flightNumber-1-0")).getText();
		System.out.println(nVolo2);

		// org.junit.Assert.assertEquals("", "");
		System.out.println(price2 + " = " + price);
		assertEquals(price2, price);

		
		System.out.println(volPar + " = " + nVolo);
		assertTrue(nVolo.contains(volPar));

		System.out.println(volRet + " = " + nVolo2);
//				assertEquals (volRet, nVolo2);			
		assertTrue(nVolo2.contains(volRet));
		// Fine recupero dati

		pausa(1);
		WebElement element7 = driver.findElement(By.id("purchaseButton"));
		element7.click();

		
		driver.close();

	}

	private static void pausa(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}

	}

}
