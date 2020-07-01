import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Opencart_08 {

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
				
				//"Display a Message Box containing the number of links present in the User Home page
				
				java.util.List<WebElement> links = dr.findElements(By.tagName("a"));
				 
				 System.out.println(links.size());
				 
				 for (int i = 1; i<=links.size(); i=i+1)
					 
				 {
				 
				 System.out.println(links.get(i).getText());
				 }
	}

}
