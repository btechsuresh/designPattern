package pageComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import abstractComponents.AbstractComponent;

public class FooterNav extends AbstractComponent{
	WebDriver driver;

	By flights=By.cssSelector("[title='Flights']");
	By links=By.cssSelector("a");

	
	public FooterNav(WebDriver driver, By sectionElement) {
		super(driver,sectionElement);
		
	}



	public void footerAttribute(){
		//driver.findElement(flights).click();// this will click header flights and not footer
		//But here we need to do selectionElement.findElement
		System.out.println(findElement(flights).getAttribute("class"));		
	}
	
	public void linkCount(){
		System.out.println("Footer Link count "+findElements(links).size());
	}

}
