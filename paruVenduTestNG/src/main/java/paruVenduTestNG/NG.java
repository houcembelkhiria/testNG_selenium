package paruVenduTestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NG {
	WebDriver driver = null;
		

	@BeforeTest
	public void setUp() {
		String projectLocation = System.getProperty("user.dir");
		System.out.println(projectLocation);
		System.setProperty("webdriver.gecko.driver",projectLocation + "/src/lib/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@Test
	public void navigate() {
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		driver.get("https://www.paruvendu.fr");
		js.executeScript("cmp_pv.cookie.saveConsent(true);");
		 try {
	            Thread.sleep(2000); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }		
		
		
	driver.navigate().refresh();
		  try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	
		  driver.findElement(By.partialLinkText("Déposer une annonce gratuite")).click();
		  try {
	            Thread.sleep(2000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		  driver.findElement(By.xpath("//a[contains(@class, '_2hYQUYBGPVPPF8rtNxLrLI') and text()='Plus tard']")).click();
		 		
	
	
	

		  WebElement  dropdown  = driver.findElement(By.cssSelector("div.select"));
		  dropdown.click();
		  try {
	            Thread.sleep(2000); // Wait for 2 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		  WebElement autoMotoBateau = driver.findElement(By.cssSelector("li[data-value='V']"));
		  autoMotoBateau.click();
		  try {
	            Thread.sleep(2000); // Wait for 2 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		  WebElement voitureOccasion = driver.findElement(By.cssSelector("li[data-value='VVO00000']"));
		  voitureOccasion.click();

		  Select categ = new Select(driver.findElement(By.id("choixFamille")));
		  categ.selectByVisibleText("Location");
		  
		  Select sousRubrique = new Select(driver.findElement(By.id("categorie")));
		  sousRubrique.selectByVisibleText("Voiture");
		  		  
		  driver.findElement(By.id("descBien")).sendKeys("ceci est la description de houcem");
		  
		  
		  Select diffusionAnnonce = new Select(driver.findElement(By.id("nbrSemainesPublication")));
		  diffusionAnnonce.selectByVisibleText("Pendant 6 mois");
		  
		  
		  driver.findElement(By.id("prix")).sendKeys("25");
		  try {
	            Thread.sleep(2000); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		  driver.findElement(By.id("codePostal")).sendKeys("75013");
		  try {
	            Thread.sleep(2000); 
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		  
		  driver.findElement(By.id("suivant1")).click();
		  String codeSource =  driver.getPageSource();
		  String chaine ="Vos coordonnées de contact";
		  
		  if (codeSource.contains(chaine)){
			  System.out.println("existe");
		  }else {
			  System.out.println("n''existe pas");

		  }
		  				
	
	
	}
	
	@AfterTest
	public void tearDown() {
		
		
        System.out.println("Test NG completed successfully !!!! ");
        //driver.close();
        //driver.quit();
	}

}
