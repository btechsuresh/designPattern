package allTests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageComponent.MultiTrip;
import pageComponent.RoundTrip;
import pageObjects.TravelHomePage;

public class DemoTest extends BaseTest{
	
	protected WebDriver driver;
	TravelHomePage th;
	//By sectionElement=By.id("flightSearchContainer"); //required for Strategy and not for factory
	
	@BeforeTest
	public void setup(){
		driver=initlizeDriver();
		th=new TravelHomePage(driver);		
	}
	
	
	@Test(dataProvider="getData")
	public void myTest(HashMap<String, String> reservationDetail) throws InterruptedException{
		th.goTo();
		driver.manage().window().maximize();
		th.getFooterNav().footerAttribute();
		th.getHeaderNav().headerAttribute();
		th.getFooterNav().linkCount();
		th.getHeaderNav().linkCount();
		//Strategy Design pattern
		/*th.setBookingStrategy(new RoundTrip(driver,sectionElement)); //for the timebeing we add sectionElement here
		th.checkAvail("MAA", "CCU");
		th.setBookingStrategy(new MultiTrip(driver,sectionElement)); //for the timebeing we add sectionElement here
		th.checkAvail("MAA", "CCU");*/
		
		//Factory Design Pattern
		th.setBookingStrategy("Multitype"); //for the timebeing we add sectionElement here
		
		//Instead of using this we can provide data with @DataProvider
		/*HashMap<String, String> reservationDetails=new HashMap<>();
		reservationDetails.put("origin", "MAA");
		reservationDetails.put("destination", "HYD");
		reservationDetails.put("destination2", "DEL");		
		th.checkAvail(reservationDetails);*/
		
		th.checkAvail(reservationDetail);
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	/*//Manually adding data provider
	@DataProvider
	public Object[][] getData(){
		HashMap<String, String> reservationDetails=new HashMap<>();
		reservationDetails.put("origin", "MAA");
		reservationDetails.put("destination", "HYD");
		reservationDetails.put("destination2", "DEL");
		
		HashMap<String, String> reservationDetails1=new HashMap<>();
		reservationDetails1.put("origin", "HYD");
		reservationDetails1.put("destination", "MAA");
		reservationDetails1.put("destination2", "DEL");	
		
		//we can also store data in list and pass list values in DataProvider
		List<HashMap<String, String>> list=new ArrayList<>();
		list.add(reservationDetails);
		list.add(reservationDetails1);
			
		return new Object[][]{
			//{reservationDetails},{reservationDetails1}
			{list.get(0)},{list.get(1)}
		};
	}	*/
	
	//by reading .json file
	@DataProvider
	public Object[][] getData() throws IOException{
		List<HashMap<String, String>> list=getJsonData(System.getProperty("user.dir")+"/src/main/java/dataLoads/resevertionDetails.json");
			
		return new Object[][]{
			//{reservationDetails},{reservationDetails1}
			{list.get(0)},{list.get(1)}
		};
	}

}
