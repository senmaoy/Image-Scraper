package ME;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
public class TEST {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//WebDriver driver = new FirefoxDriver();  
	    //FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\ey\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\oymzzir8.default"));  
	    //WebDriver driver= new FirefoxDriver(profile);  
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files(x86)\\Mozilla Firefox\\firefox.exe");  
		//WebDriver driver = new FirefoxDriver(); 
		//Navigation navi= driver.navigate();
		//driver.get("https://www.flickr.com/");
		//navi.to("https://www.flickr.com/search");
		//navi.to("https://www.flickr.com/search/");
		//ƒ£ƒ‚ ‰»Îentity name
		//WebElement txt = driver.findElement(By.id("gn-search-field"));
		//String tag="horse";
		//txt.sendKeys(tag);
		//txt.sendKeys(Keys.ENTER);
		//driver.manage().window().maximize();
		   URL url = new URL("http://c1.staticflickr.com/1/81/238858145_3d8d582cac.jpg");

		    Image image = Toolkit.getDefaultToolkit().getDefaultToolkit().createImage(url);
		    System.out.println(image);   
		  }
		
				
	}


