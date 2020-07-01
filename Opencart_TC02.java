import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opencart_TC02 {

	public static void main(String[] args) throws Exception {
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
				
				//Enter the key word in search text box on top right of the page.  Hit Enter button only and no icon click
				dr.findElement(By.name("search")).sendKeys("apple");
				dr.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
				
				//Select "Monitors" under Components in the drop down.  Check "Search in sub categories" and click Search
				dr.findElement(By.name("category_id")).click();
				dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/select/option[10]")).click();
				dr.findElement(By.name("sub_category")).click();
				dr.findElement(By.id("button-search")).click();
				
				//Click on "Phones and PDA's" tab.
				dr.findElement(By.linkText("Phones & PDAs")).click();
				
				//Sort from the "Price (High > Low)" for the page.

				dr.findElement(By.id("input-sort")).click();
				dr.findElement(By.xpath("//*[@id=\"input-sort\"]/option[5]")).click();
				
				//Click on "Add to Compare " for the first three phones" and click on Close button
				dr.findElement(By.cssSelector("#content > div:nth-child(3) > div:nth-child(1) > div > div.image > a > img")).click();
				dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[2]")).click();
				dr.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				dr.navigate().back();
				
				dr.findElement(By.cssSelector("#content > div:nth-child(3) > div:nth-child(2) > div > div.image > a > img")).click();
				dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[2]")).click();
				dr.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				dr.navigate().back();
				
				
				dr.findElement(By.cssSelector("#content > div:nth-child(3) > div:nth-child(3) > div > div.image > a > img")).click();
				dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[1]/button[2]")).click();
				dr.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				dr.navigate().back();
				
				dr.findElement(By.id("compare-total")).click();
				dr.navigate().back();
				
				//Click on the first phone link on the page.
				dr.findElement(By.cssSelector("#content > div:nth-child(3) > div:nth-child(1) > div > div.image > a > img")).click();
				
				//Check the fifth feature in the description section of the phone and write into flat file.

				WebElement str = dr.findElement(By.xpath("//*[@id=\"tab-description\"]/ul/li[5]"));
				System.out.println(str.getText());
				
				//Click on "Add to Cart".
				dr.findElement(By.id("button-cart")).click();
				dr.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				
				//Click on "Shopping Cart" displayed on ribbon message
				dr.findElement(By.linkText("shopping cart")).click();
				
				//Click on Check out button.
				JavascriptExecutor js = (JavascriptExecutor) dr;
			    js.executeScript("window.scrollBy(0,250)", "");
				dr.findElement(By.linkText("Checkout")).click();
				
				//Click on Continue buttons (2nd, 3rd and 4th)
				dr.findElement(By.linkText("Continue Shopping")).click();
				
				//Click on "Order history " from "My account "tab
				dr.findElement(By.linkText("My Account")).click();
				dr.findElement(By.linkText("Order History")).click();
				
				//Click on "Subscribe to news letters".
				dr.findElement(By.linkText("Newsletter")).click();
				dr.findElement(By.name("newsletter")).click();
				dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
				
				//Click on Extras -> Specials in the footer
				dr.findElement(By.linkText("Specials")).click();
				
				//Click on List (or) Grid whichever is enabled
				dr.findElement(By.cssSelector("#grid-view > i")).click();
				
				//Click on "Logout "
				dr.findElement(By.linkText("My Account")).click();
				dr.findElement(By.linkText("Logout")).click();
	}

}
