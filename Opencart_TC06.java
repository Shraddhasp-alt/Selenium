import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opencart_TC06 {

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
		
		
		//Click on "Login" Link
		
	    dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		dr.findElement(By.linkText("Login")).click();
		
		//Enter Email Address and Password and click on "Login" Button.

				dr.findElement(By.name("email")).sendKeys(sheet1.getRow(1).getCell(2).getStringCellValue());
				dr.findElement(By.name("password")).sendKeys(sheet1.getRow(1).getCell(4).getStringCellValue());
				dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
				dr.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]")).click();
				
				//Enter the key word in search text box on top right of the page.
				dr.findElement(By.name("search")).sendKeys("canon");
				dr.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
				
				//Click on "Canon" image searched .
				dr.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[1]/a/img")).click();
				
				//Change the quantity in the edit box.
				dr.findElement(By.name("quantity")).clear();
				dr.findElement(By.name("quantity")).sendKeys("2");
				
				//Click on the "Add to Cart" button
				dr.findElement(By.id("button-cart")).click();
	}

}
