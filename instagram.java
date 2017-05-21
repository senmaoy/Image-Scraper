package ME;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*; 

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.firefox.*;

public class instagram {
	public static void main(String tag) {
		// TODO Auto-generated method stub
        System.out.println("hello world1");
         
        WebDriver driver = new FirefoxDriver();  
		Navigation navi= driver.navigate();
		//String tag="ţ";
		navi.to("http://searchinstagram.com/"+"tag");
		
		 String pas="C:\\Users\\ey\\Desktop\\scraper\\downn\\instagram\\"+tag;
			File file = new File(pas);
			   if(!file.exists()){
			    file.mkdirs();
			   }
				
		try {
			test();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String stra="/html/body/div[1]/ul/li[0]/a/img";
	
		
		for (int j = 1;j<=200; j++){
			String s = String.valueOf(j);
			String str1 = stra.replaceFirst("0", s);
			
			System.out.println("hello world4");
			
			try{
			WebElement pic = driver.findElement(By.xpath(str1));
			String url=pic.getAttribute("src");
			System.out.println(url);
			
			 int index1 = url.indexOf("https://");
			 if (index1==-1){
				 continue;
			 }
			String path="C:\\Users\\ey\\Desktop\\scraper\\downn\\goole\\"+tag+"\\"+s+"_"+s+".jpg";
			SaveFileUtil.saveToFile(url, path);	
			}catch (NoSuchElementException e) {
	            continue;
	        }
		}
		driver.close();
	}
	public static void test()throws AWTException
	{
	   Robot robot=new Robot();
	   for (int j = 12;j<=40; j++){
	   robot.delay(2000);
	   robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	   robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	 } 
	}
}
