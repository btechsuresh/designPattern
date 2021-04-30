package abstractComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {
	protected WebDriver driver;
	WebElement sectionElement;
	protected WebDriverWait wait;
	
	public AbstractComponent(WebDriver driver, By sectionElement) {
		this.driver=driver;
		this.sectionElement=driver.findElement(sectionElement);	
		this.wait=new WebDriverWait(driver, 30);
	}
	
	public WebElement findElement(By findElementBy){
		return sectionElement.findElement(findElementBy);
	}
	
	public List<WebElement> findElements(By findElementBy){
		return sectionElement.findElements(findElementBy);
	}

	
	
	
	
	

}
