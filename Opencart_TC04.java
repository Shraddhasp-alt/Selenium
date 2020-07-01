import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opencart_TC04 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
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
//				dr.findElement(By.xpath("//*[@id=\"slideshow0\"]/div/div[2]/a/img")).click();
				
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div[1]/a")).click();
		
		//Click on the Related Products tab on the page.
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[1]/a/img")).click();
		
		dr.findElement(By.cssSelector("#content > div:nth-child(3) > div:nth-child(1) > div > div.image > a > img")).click();
		
		//Click on Add to Cart for the related product.
		dr.findElement(By.id("button-cart")).click();
		
		//Click on Shopping Cart link displayed in the top right corner of the page.
		dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/i")).click();

		//Change the quantity of the product.
		dr.findElement(By.name("quantity[425462]")).clear();
		dr.findElement(By.name("quantity[425462]")).sendKeys("2");
		
		//Click on the update icon.
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[1]/i")).click();
		
		//Click on Check out button.
		dr.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[2]/a")).click();
		
		//Click on Order History of My Account -footer of the page.
		dr.findElement(By.linkText("Order History")).click();
		
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div/a")).click();
		
		dr.findElement(By.linkText("Logout")).click();
	}

}
