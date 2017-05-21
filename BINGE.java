package ME;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*; 

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.firefox.*;
public class BINGE {

	public static void main(String tag) throws IOException {
		// TODO Auto-generated method stub
        System.out.println("hello world1");
        
       //System.setProperty("webdriver.firefox.bin", "D:\\firefox\\firefox.exe");   
        WebDriver driver = new FirefoxDriver();  
		Navigation navi= driver.navigate();
		
		navi.to("http://cn.bing.com/");
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		WebElement btn1 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div/div[6]/div/div/div[1]/span[1]/a"));
		btn1.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WebElement btn2 = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div/div[6]/div/ul/li[1]/a"));
		btn2.click();
		
		WebElement txt = driver.findElement(By.id("sb_form_q"));
		txt.sendKeys(tag);
		WebElement btn = driver.findElement(By.id("sb_form_go"));
		btn.click();
		
		
		
		
		 String pas="G:\\yesenmao\\bing\\"+tag;
			File file = new File(pas);
			
		 String pass="G:\\yesenmao\\bing\\"+tag+".txt";
		    File fil = new File(pass);
		    
		    if(!file.exists()){
			    file.mkdirs();
			   }

		    if(!fil.exists()){
		        fil.createNewFile();
		       }
					
		  
	    OutputStreamWriter write = new OutputStreamWriter( new FileOutputStream(fil),"GBK");//¿¼ÂÇµ½±àÂë¸ñÊ½
		BufferedWriter bufferedWriter = new BufferedWriter(write);
			     
		
		String stra = "//div[@id='dg_c']/div[2]/div/";
		String strb	= "div[1]/a/img";

		String straa="//div[@id='dg_c']/div[1]/div[1]/";
		
		int cnt=0;
		while(cnt<=149){
		for (int i = 1; i<=40; i++) { 
										
		String s = String.valueOf(i);
		String str1 = stra.replaceFirst("2", s);
		if(i==1){
			 str1 = straa;
		}
	
		for (int j = 1;j<=35; j++){
			String ss = String.valueOf(j);
			String str2 = strb.replaceFirst("1", ss);
			String strc = str1+str2;
			String strd = strc.replaceFirst("/img", "");
			//System.out.println("hello world4");
			
			try{
			WebElement pic = driver.findElement(By.xpath(strc));
			String url=pic.getAttribute("src");
			
			
			WebElement t = driver.findElement(By.xpath(strd));
			String ta=t.getAttribute("t1");
			
			
			 int index1 = url.indexOf("http://");
			 if (index1==-1){
				 continue;
			 }
			String path="G:\\yesenmao\\bing\\"+tag+"\\"+String.valueOf(cnt+1)+".jpg";
			SaveFileUtil.saveToFile(url, path);
			System.out.println(url);                                        //save image
			
			bufferedWriter.write(String.valueOf(cnt+1)+"     "+ta+"\r\n");
			System.out.println(ta);                                         //save tag
			cnt++;
			System.out.println(cnt);
			if(cnt>=149){
				break;
			}
			}catch (Exception e) {
				
				try {
					test();
				} catch (AWTException ex) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	            continue;
	        }
			
		}
		if(cnt>=149){
				break;
			}
		}
		}
		driver.close();
	    bufferedWriter.close();
	    write.close(); 

	}
	public static void test()throws AWTException
	{
	   Robot robot=new Robot();
	   for (int j = 1;j<=4; j++){
	   robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	   robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	   robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	   robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	   robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	   robot.delay(500);
	   }
	
	
	} 
}