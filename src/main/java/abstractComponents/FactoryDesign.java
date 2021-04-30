package abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageComponent.MultiTrip;
import pageComponent.RoundTrip;

public class FactoryDesign {
	WebDriver driver; //but actual driver value comes from Test
	By sectionElement=By.id("flightSearchContainer");
	
	public FactoryDesign(WebDriver driver) {
		this.driver=driver;
	}

	//we are returning 2 classes object that implements common inteface, so-
	// return type is Interface
	public SearchFlightAvail createStrategy(String strategyType){
		if (strategyType.equalsIgnoreCase("Multitype")) {
			return new MultiTrip(driver, sectionElement);			
		}
		if (strategyType.equalsIgnoreCase("roundtrip")) {
			return new RoundTrip(driver, sectionElement);			
		}
		return null;
		
	}
	
	

}
