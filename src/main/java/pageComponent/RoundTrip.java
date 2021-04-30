package pageComponent;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import abstractComponents.AbstractComponent;
import abstractComponents.SearchFlightAvail;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail{
	
	public RoundTrip(WebDriver driver, By sectionElement) {
		super(driver, sectionElement);
		
	}
   private By rbo=By.id("ctl00_mainContent_rbtnl_Trip_1");
   private By from=By.id("ctl00_mainContent_ddl_originStation1_CTXTaction");
   private By to =By.id("ctl00_mainContent_ddl_destinationStation1_CTNR");
   private By cb=By.id("ctl00_mainContent_chk_IndArm");
   private By search=By.id("ctl00_mainContent_btn_FindFlights");

   //Instead of hadrcoded method parameters we can pass HashMap();
   
	/*public void checkAvail(String origin, String destination) throws InterruptedException {
		System.out.println("This is RoundTrip class");
		findElement(rbo).click();	
		this.wait.until((d)->findElement(from).isDisplayed());
		selectOriginCity(origin);
		wait.until((d)->findElement(to).isDisplayed());
		selectDestinationCity(destination);
		findElement(cb).click();
		findElement(search).click();
	}*/
	
	public void selectOriginCity(String origin){
		findElement(from).click();
		findElement(By.xpath("//a[@value='"+origin+"']")).click();
	}
	
	public void selectDestinationCity(String destination){
		findElement(to).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", findElement(By.xpath("(//a[@value='"+destination+"'])[2]")));
		//findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
	}

	@Override
	public void checkAvail(HashMap<String, String> reservationDetails) throws InterruptedException {
		System.out.println("This is RoundTrip class");
		findElement(rbo).click();	
		this.wait.until((d)->findElement(from).isDisplayed());
		selectOriginCity(reservationDetails.get("origin"));
		wait.until((d)->findElement(to).isDisplayed());
		selectDestinationCity(reservationDetails.get("destination"));
		findElement(cb).click();
		findElement(search).click();
		
	}

}
