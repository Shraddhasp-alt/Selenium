import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opencart_TC01 {

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
		
		//Click on create an account
		dr.findElement(By.linkText("My Account")).click();
		dr.findElement(By.linkText("Register")).click();//Click on create account link
		
		
		//Fill the details in page
		XSSFSheet sheet1 = wb.getSheetAt(0);
		String fname = sheet1.getRow(1).getCell(0).getStringCellValue();
		
		
		dr.findElement(By.name("firstname")).sendKeys(fname);
		
		dr.findElement(By.name("lastname")).sendKeys(sheet1.getRow(1).getCell(1).getStringCellValue());
		dr.findElement(By.name("email")).sendKeys(sheet1.getRow(1).getCell(2).getStringCellValue());
		
		
		String s = String.valueOf((int)sheet1.getRow(1).getCell(3).getNumericCellValue());
		dr.findElement(By.name("telephone")).sendKeys(s);
		dr.findElement(By.name("password")).sendKeys(sheet1.getRow(1).getCell(4).getStringCellValue());
		dr.findElement(By.name("confirm")).sendKeys(sheet1.getRow(1).getCell(5).getStringCellValue());
		
		//Click on privacy policy and click on continue
		dr.findElement(By.name("agree")).click();
	    dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	    
	    //Login
	    dr.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i")).click();
		dr.findElement(By.linkText("Login")).click();
		dr.findElement(By.name("email")).sendKeys(sheet1.getRow(1).getCell(2).getStringCellValue());
		dr.findElement(By.name("password")).sendKeys(sheet1.getRow(1).getCell(4).getStringCellValue());
		dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		dr.findElement(By.xpath("//*[@id=\"account-account\"]/ul/li[1]")).click();
	    
	    //Click on "Contact" link
         dr.findElement(By.cssSelector("#top-links > ul > li:nth-child(1) > a > i")).click();;
	    
	    //Type the Enquiry - 100 characters
//         dr.findElement(By.name("name")).sendKeys(fname);
//         dr.findElement(By.name("email")).sendKeys(sheet1.getRow(1).getCell(2).getStringCellValue());
	    dr.findElement(By.name("enquiry")).sendKeys(sheet1.getRow(1).getCell(6).getStringCellValue());
	    dr.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input")).click();
	    
	  
	    
	    //Click on "Continue" and Click on "Continue" 
	    dr.findElement(By.linkText("Continue")).click();
	    
	    //Click on "Samsung Galaxy Tab" on home page which is shown as the main advertisement - this might change - but the user should click on this main image only.
	    dr.findElement(By.xpath("//*[@id=\"slideshow0\"]/div/div[2]/a/img")).click();
	    
	    JavascriptExecutor js = (JavascriptExecutor) dr;
	    js.executeScript("window.scrollBy(0,250)", "");
	    //Click on "Review" tab below
	    dr.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/ul[2]/li[2]/a")).click();
	    
	    //"Fill in your details -Name and Review. Select the rating as given in Excel
	    //Enter the code in the box - Click Continue"
	    dr.findElement(By.name("text")).sendKeys(sheet1.getRow(1).getCell(7).getStringCellValue());
	    dr.findElement(By.xpath("//*[@id=\"form-review\"]/div[4]/div/input[4]")).click();
	    dr.findElement(By.id("button-review")).click();
	    
	    //Click on "Add to wish list"
	    dr.findElement(By.cssSelector("#content > div > div.col-sm-4 > div.btn-group > button:nth-child(1) > i")).click();
	    
	    //Close the success ribbon message on the page.
//	    dr.findElement(By.cssSelector("#product-product > div.alert.alert-success.alert-dismissible > button")).click();
	    
	    //Click on "Wishlist" link.
	    dr.findElement(By.id("wishlist-total")).click();
	    
//	    //Click on "Pound Sterling".
	    dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).click();
	    dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button")).click();
	    WebElement str3 = dr.findElement(By.className("price"));
	    System.out.println(str3.getText());
	    
	    //Retrieve the value and write into any flat file.
//	    WebElement str = dr.findElement(By.className(" price"));
//	    System.out.println(str);
	    
	    //Click on "Euro".
	    dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).click();
	    dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button")).click();
	    WebElement str1 = dr.findElement(By.className("price"));
	    System.out.println(str1.getText());
	    
	    //Click on "US Dollar".
	    dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/button/strong")).click();
	    dr.findElement(By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button")).click();
	    WebElement str2 = dr.findElement(By.className("price"));
	    System.out.println(str2.getText());
	    
	    //Click on "Add To Cart" icon
	    dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/button")).click();
	    
	    //Close the success message on the page.
	    //dr.findElement(By.className("x-tool-close")).click();
	    
	    //dr.findElement(By.xpath("//button[@class='close']")).click();
	    
	    //Click "Remove" icon on the product in My Wishlist page
	    dr.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a")).click();
	    
	    //click on continue.
	    dr.findElement(By.linkText("Continue")).click();
	    
	    //Click on "Logout "
	    dr.findElement(By.linkText("My Account")).click();
	    dr.findElement(By.linkText("Logout")).click();
		
	}

}
