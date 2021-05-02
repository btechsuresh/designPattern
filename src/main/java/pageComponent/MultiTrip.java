package pageComponent;

import java.util.HashMap;
import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import abstractComponents.AbstractComponent;
import abstractComponents.SearchFlightAvail;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail{
	
	//as soon u extend AbstractComponent class, constructor will get created

	public MultiTrip(WebDriver driver, By sectionElement) {
		super(driver, sectionElement);
	}

	private By from=By.id("ctl00_mainContent_ddl_originStation1_CTXT");
	private By to=By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
	private By submit=By.id("ctl00$mainContent$btn_FindFlights");
	private By multiCity_rdo=By.id("ctl00_mainContent_rbtnl_Trip_2");
	private By destination_2=By.id("ctl00_mainContent_ddl_originStation2_CTXT");
	private By modalPopup=By.id("MultiCityModelAlert");
	
	//Instead of hardcoded parameters, we can use HashMap, see below method
	public void checkAvail(String origin, String destination) {
		makeStrategy((d)->selectOriginCity(origin)); //prerequest (ExecuteAround DPattern)
		//above line means makeStrategy will accept any method of this class
		//but execute that method after predefined lines in makeStrategy method 
		// like selectOriginCity(origin) will execute after:-
		/*System.out.println("This is Mutitrip class");
		findElement(multiCity_rdo).click();
		findElement(modalPopup).click();*/
		
		//selectOriginCity(origin);
		wait.until((d)->findElement(to).isDisplayed());
		selectDestinationCity(destination);
		selectDestinationCity2("BLR");
	}
	
	public void selectOriginCity(String origin){
		findElement(from).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", findElement(By.xpath("//a[@value='"+origin+"']")));
		
		//findElement(By.xpath("//a[@value='"+origin+"']")).click();
	}
	
	public void selectDestinationCity(String destination){
		findElement(to).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", findElement(By.xpath("(//a[@value='"+destination+"'])[2]")));
		//findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
	}
	
	public void selectDestinationCity2(String destination2){
		findElement(destination_2).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", findElement(By.xpath("(//a[@value='"+destination2+"'])[3]")));
		//findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
	}
	
	//Execute Around Design Pattern
	// Generic method (Prerequest code)
	public void makeStrategy(Consumer<MultiTrip> consumer){
		System.out.println("This is Mutitrip class");
		findElement(multiCity_rdo).click();
		findElement(modalPopup).click();
		wait.until((d)->findElement(from).isDisplayed());
		consumer.accept(this); //this refers to any method of this class
		System.out.println("I am Done");	
		
	}

	/*@Override
	public void checkAvail(HashMap<String, String> reservationDetails) throws InterruptedException {
		makeStrategy((d)->selectOriginCity(reservationDetails.get("origin")));
		//selectOriginCity(origin);
		wait.until((d)->findElement(to).isDisplayed());
		selectDestinationCity(reservationDetails.get("destination"));
		selectDestinationCity2(reservationDetails.get("destination2"));
		
	}*/
	

}
