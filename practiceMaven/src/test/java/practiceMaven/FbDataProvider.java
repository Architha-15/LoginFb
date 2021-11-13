package practiceMaven;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.selenium.common.BaseClass;
import com.selenium.common.DataproviderUtils;

public class FbDataProvider extends BaseClass{
	
	@Parameters("url")
	@Test(priority=1)
	public void launchApp(String url) {
		driver.get(url);
		
	}
	
	  @DataProvider
	  public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testdata = DataproviderUtils.getDataFromExcel();
		return testdata.iterator();
		  
	  }
	
	
	
	
	
	@Test(dataProvider = "getTestData",priority=2)
	public void LoginDetails(String username,String password) throws Exception {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(username);
		Thread.sleep(5000);
		
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(5000);
		
		
	}

}
