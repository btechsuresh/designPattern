package pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.AbstractComponent;

public class HeaderNav extends AbstractComponent{
	By flights=By.cssSelector("[title='Flights']");
	By links=By.cssSelector("a");

	public HeaderNav(WebDriver driver, By headerMainEle) {
		super(driver,headerMainEle);
	}
	
	public void headerAttribute(){
		//driver.findElement(flights).click();// this will click header flights and not footer
		//But here we need to do selectionElement.findElement
		System.out.println(findElement(flights).getAttribute("class"));		
		
	}
	
	public void linkCount(){
		System.out.println("Header Link count "+findElements(links).size());
	}

}
