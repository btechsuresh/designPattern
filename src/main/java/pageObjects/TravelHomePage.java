package pageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.FactoryDesign;
import abstractComponents.SearchFlightAvail;
import pageComponent.FooterNav;
import pageComponent.HeaderNav;

public class TravelHomePage {
	By selectionElement=By.id("traveller-home");//can't place in -
	//AbstractComponent if we do so then it will be hardcoded for footer.
	By headerMainEle=By.id("buttons");
	WebDriver driver;
	SearchFlightAvail searchAvail;
	
	public TravelHomePage(WebDriver driver) {
		this.driver=driver;
	}

	public void goTo(){
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}
	
	public FooterNav getFooterNav(){
		return new FooterNav(driver,selectionElement);
	}

	public HeaderNav getHeaderNav(){
		System.out.println("This is Header Nav method");
		return new HeaderNav(driver,headerMainEle);
	}
	// Strategy Design pattern
	//This method will take the object of classes that implements Interface
/*	public void setBookingStrategy(SearchFlightAvail searchAvail){
		this.searchAvail=searchAvail;		
	}*/
	
	//Factory Design Pattern
	
	public void setBookingStrategy(String strategyType){
		FactoryDesign fd=new FactoryDesign(driver);
		searchAvail=fd.createStrategy(strategyType);
		
			//this.searchAvail=searchAvail;		
		}
	
	/*public void checkAvail(HashMap<String, String> reservationDetails) throws InterruptedException{
		searchAvail.checkAvail(reservationDetails);
		
	}*/
	
	public void checkAvail(String origin, String destination) throws InterruptedException{
	searchAvail.checkAvail(origin,destination);
	
}
	
	
	
}
