package DemoMobileTest;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class MobileTesting {
public	WebDriver driver;
  @Test
  public void verifySort() throws InterruptedException {
	  driver.navigate().to("http://demowebshop.tricentis.com/login");
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//span[@class='icon']")).click();
	  driver.findElement(By.xpath("//ul[@class='mob-top-menu show']//a[@href='/computers']")).click();
	  driver.findElement(By.xpath("//h2[@class='title']//a[@href='/desktops']")).click();
	  Select sort = new Select(driver.findElement(By.name("products-orderby")));
	  sort.selectByVisibleText("Created on");
	  Thread.sleep(4000);
	  Select sortnew = new Select(driver.findElement(By.name("products-orderby")));
	  System.out.println(sortnew.getFirstSelectedOption().getText());
      Assert.assertEquals(sortnew.getFirstSelectedOption().getText(), "Created on", "This is to verify sorting for created on");
	  
		/*
		 * List<WebElement> element = sort.getAllSelectedOptions(); for(WebElement
		 * selectedItem:element) { System.out.println(selectedItem.getText()); }
		 */  
	  
		/*
		 * String SortPosition = driver.findElement(By.
		 * xpath("//h2[@class='product-title']/a[text()='Build your own cheap computer']"
		 * )).getText(); System.out.println(SortPosition); String SortCreatedOn =
		 * driver.findElement(By.
		 * xpath("//h2[@class='product-title']/a[text()='Simple Computer']")).getText();
		 * System.out.println(SortCreatedOn); Assert.assertEquals(SortPosition,
		 * SortCreatedOn);
		 */
	  
  }
  @BeforeClass
  public void testSetupCapabilites() throws MalformedURLException {
	  DesiredCapabilities capability= new DesiredCapabilities();     
	  capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5x");       
	  capability.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");       
	  capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");        
	  driver=new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capability);
  }

  @AfterClass
  public void tearDown() {
	  driver.close();
	  driver.quit();
  }

}
