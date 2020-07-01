import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opencart_TC03 {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		
		//Launch opencart application
		WebDriver dr = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		dr.get("https://www.google.com/");
		dr.get("https://demo.opencart.com/ ");//Launch OpenCart application
		File src = new File("C:\\Register\\Register.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String fname = sheet1.getRow(1).getCell(0).getStringCellValue();
		
		//Click on "Login" Link

	    dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		dr.findElement(By.linkText("Login")).click();
		
		
		//Enter Email Address and Password and click on "Login" Button.

		dr.findElement(By.name("email")).sendKeys(sheet1.getRow(1).getCell(2).getStringCellValue());
		dr.findElement(By.name("password")).sendKeys(sheet1.getRow(1).getCell(4).getStringCellValue());
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		dr.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]")).click();
		
		//Click on "Samsung Galaxy Tab" on home page which is shown as the main advertisement - this might change - but the user should click on this main image only.
		dr.findElement(By.xpath("//*[@id=\"slideshow0\"]/div/div[2]/a/img")).click();
		
		//Click on the picture of the Tab (main image)
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[1]/li[1]/a/img")).click();
		
		//Reach to the last image by navigating through Arrow buttons
		for(int i=0; i<=5;i++)
		{
		dr.findElement(By.xpath("/html/body/div[2]/div/button[2]")).click();
		}
		
		dr.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		//Close the Window
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/button")).click();
		
		//Click on "Add to Cart".
		dr.findElement(By.id("button-cart")).click();
		
		dr.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		//Click on "Shopping Cart" displayed on ribbon message
		dr.findElement(By.linkText("shopping cart")).click();
		
		//Click Estimate shipping and taxes.
		dr.findElement(By.linkText("Estimate Shipping & Taxes")).click();
		dr.findElement(By.name("country_id")).click();
		dr.findElement(By.xpath("//*[@id=\"input-country\"]/option[107]")).click();
		dr.findElement(By.name("zone_id")).click();
		dr.findElement(By.xpath("//*[@id=\"input-zone\"]/option[20]")).click();
		dr.findElement(By.name("postcode")).sendKeys("12345");
		dr.findElement(By.id("button-quote")).click();
		
		//Click on Get Quotes  and check Flat Shipping Rate and Click on Apply Shipping 
		dr.findElement(By.name("shipping_method")).click();
		dr.findElement(By.id("button-shipping")).click();
		
		//dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		JavascriptExecutor js = (JavascriptExecutor) dr;
//	    js.executeScript("window.scrollBy(0,500)", "");
//	    
		//Click on 'Use Coupon code' radio button
//		dr.findElement(By.xpath("//*[@id=\"accordion\"]/div[1]/div[1]/h4/a/i")).click();
		
		//Enter the Random Coupon Number and click on Apply Coupon
//		dr.findElement(By.name("coupon")).sendKeys("125egj");
//		dr.findElement(By.id("button-coupon")).click();
		
		//Click on Check out button.
		dr.findElement(By.cssSelector("#top-links > ul > li:nth-child(5) > a")).click();
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
		
	}

}
