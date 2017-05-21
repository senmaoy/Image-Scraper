package ME;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*; 

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.firefox.*;

public class GOOLE {
	public static void main(String tag) throws IOException {
		// TODO Auto-generated method stub
        System.out.println("hello world1");
         
        WebDriver driver = new FirefoxDriver();  
		Navigation navi= driver.navigate();
		navi.to("https://www.google.com.hk/imghp?hl=zh-CN&tab=wi");
		//String tag="koby,lakers";
			   
		WebElement txt = driver.findElement(By.id("lst-ib"));
		txt.sendKeys(tag);
		WebElement btn = driver.findElement(By.className("lsb"));
		btn.click();
				
		String pas="G:\\yesenmao\\goole\\"+tag;
		File file = new File(pas);
		
	    String pass="G:\\yesenmao\\goole\\"+tag+".txt";
	    File fil = new File(pass);
	    
	    if(!file.exists()){
		    file.mkdirs();
		   }

	    if(!fil.exists()){
	        fil.createNewFile();
	       }
				
	    System.out.println("hello world2");
        OutputStreamWriter write = new OutputStreamWriter( new FileOutputStream(fil),"GBK");//考虑到编码格式
	    BufferedWriter bufferedWriter = new BufferedWriter(write);
	    System.out.println("hello world3");
		
		//String stra="/html/body/div[5]/div[3]/div[3]/div[3]/div/div[2]/div[2]/div/div/ol/li/div[3]/div[1]/div[0]/a/img";
		String stra="/html/body/div[5]/div[3]/div[3]/div[3]/div/div[2]/div[2]/div/div[1]/ol/li/div[3]/div[1]/div[0]/a/img";
		int cnt=0;
		while(cnt<=149){
			for (int j = 1;j<=10000; j++){   
				String s = String.valueOf(j);
				String str1 = stra.replaceFirst("0", s);
				//String str2 = strb.replaceFirst("0", s);
				
				System.out.println("hello world4"); //输出 'hello world4'表示进入下载阶段，用于调试
				
				
				try{
					WebElement pic = driver.findElement(By.xpath(str1));
					String url=pic.getAttribute("src");
					
					
					
					 int index1 = url.indexOf("https://");
					 if (index1==-1){
						 continue;
					 }
				 
					 String path="G:\\yesenmao\\goole\\"+tag+"\\"+String.valueOf(cnt+1)+".jpg";
						SaveFileUtil.saveToFile(url, path);
						System.out.println(url);                                        //save image
						
						bufferedWriter.write(String.valueOf(cnt+1)+"     "+url+"\r\n");
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
			}
			driver.close();
		    bufferedWriter.close();
		    write.close(); 
	}
	public static void test()throws AWTException
	{
	   Robot robot=new Robot();
	   for (int j = 1;j<=8; j++){
	   robot.delay(2000);
	   robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	   robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	 } 
	}
}
