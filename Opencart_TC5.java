import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opencart_TC5 {

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
		
		//Click on "Gift Vouchers" from the extras - footer of the page.
		dr.findElement(By.linkText("Gift Certificates")).click();
		
		//Fill in the details through an external flat file.
		dr.findElement(By.name("to_name")).sendKeys(sheet1.getRow(1).getCell(8).getStringCellValue());
		dr.findElement(By.name("to_email")).sendKeys(sheet1.getRow(1).getCell(9).getStringCellValue());
		dr.findElement(By.name("voucher_theme_id")).click();
		dr.findElement(By.name("message")).sendKeys(sheet1.getRow(1).getCell(10).getStringCellValue());
		dr.findElement(By.name("agree")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div[8]/div/input[2]")).click();
		
//		Click on continue.
		dr.findElement(By.linkText("Continue")).click();
		
//		Remove the products if there is any.
		while(dr.getPageSource().contains("Product Name"))
		{
//		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[4]/div/span/button[2]")).click();
		dr.findElement(By.cssSelector("#content > form > div > table > tbody > tr > td:nth-child(4) > div > span > button > i")).click();
		}
		
//		Click on Continue Shopping.
		dr.findElement(By.linkText("Continue")).click();
		
//		Click on Contact  from the customer service from the Footer of the page.
		dr.findElement(By.linkText("Contact Us")).click();
		
//		Type the Enquiry - 100 characters
		dr.findElement(By.name("enquiry")).sendKeys(sheet1.getRow(1).getCell(6).getStringCellValue());
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();
		
//		Click on "Continue" and Click on "Continue" 
		dr.findElement(By.linkText("Continue")).click();
		
//		Click on Wish list from the footer of the Home page.
		dr.findElement(By.linkText("Wish List")).click();
		
//		Click on continue.
		dr.findElement(By.linkText("Continue")).click();
		
//		Click on Edit your account information.
		dr.findElement(By.linkText("Edit your account information")).click();

		//Change the Telephone number from an external file and click on Continue.
		dr.findElement(By.name("telephone")).clear();
		dr.findElement(By.name("telephone")).sendKeys("7391");
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
		
//		Click on view your return requests.
		dr.findElement(By.linkText("View your return requests")).click();
		
//		Click on View icon .
		dr.findElement(By.linkText("Continue")).click();
		
		//Click on Modify your address book entries link on the page.
		dr.findElement(By.linkText("Modify your address book entries")).click();
		
		//Click on Edit button.
		dr.findElement(By.linkText("New Address")).click();
		
		//Fill in the details through an external flat file.
		dr.findElement(By.name("firstname")).sendKeys(sheet1.getRow(1).getCell(0).getStringCellValue());
		dr.findElement(By.name("lastname")).sendKeys(sheet1.getRow(1).getCell(1).getStringCellValue());
		dr.findElement(By.name("address_1")).sendKeys(sheet1.getRow(1).getCell(11).getStringCellValue());
		dr.findElement(By.name("city")).sendKeys(sheet1.getRow(1).getCell(12).getStringCellValue());
		String s = String.valueOf((int)sheet1.getRow(1).getCell(13).getNumericCellValue());
		dr.findElement(By.name("postcode")).sendKeys(s);
		//dr.findElement(By.xpath("//*[@id=\"input-country\"]")).click();
		dr.findElement(By.xpath("//*[@id=\"input-country\"]/option[107]")).click();
		//dr.findElement(By.xpath("//*[@id=\"input-zone\"]")).click();
		dr.findElement(By.xpath("//*[@id=\"input-zone\"]/option[20]")).click();
		dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
	}

}
