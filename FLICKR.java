package ME;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*; 

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.firefox.*;
public class FLICKR {

	public static void main(String tag) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("hello world1");// ���ڵ��ԣ�����ɾ��
		//String tag="ţ";
		
      WebDriver driver = new FirefoxDriver();  
	    //FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\ey\\AppData\\Local\\Mozilla\\Firefox\\Profiles\\oymzzir8.default"));  
	    //WebDriver driver= new FirefoxDriver(profile);  
		//System.setProperty("webdriver.firefox.bin", "C:\\Program Files(x86)\\Mozilla Firefox\\firefox.exe");  
		//WebDriver driver = new FirefoxDriver(); 
		Navigation navi= driver.navigate();
		driver.get("https://www.flickr.com/search");
		
		//navi.to("https://www.flickr.com/search/");
		//ģ������entity name
		WebElement txt = driver.findElement(By.id("gn-search-field"));
		txt.sendKeys(tag);
		txt.sendKeys(Keys.ENTER);
		driver.manage().window().maximize();
		//���ɴ���ͼƬ���ļ�
		String pas="G:\\yesenmao\\flickr\\"+tag;
		File file = new File(pas);
		
	    String pass="G:\\yesenmao\\flickr\\"+tag+".txt";
	    File fil = new File(pass);
	    
	    if(!file.exists()){
		    file.mkdirs();
		   }

	    if(!fil.exists()){
	        fil.createNewFile();
	       }
				
	  
        OutputStreamWriter write = new OutputStreamWriter( new FileOutputStream(fil),"GBK");//���ǵ������ʽ
	    BufferedWriter bufferedWriter = new BufferedWriter(write);
		   
		
		              // the xpath of images from flickr, if the website was changed,the 
			         //xpath will be changed too.
			String stra = "/html/body/div[1]/div/main/div/div[1]/section/div[0]/div/figure/div[1]/a/img";
			String strb="/html/body/div[1]/div/main/div/div[1]/section/div[0]/div/figure/div[2]/div[1]/div/span[1]/a";
			  
			int cnt=0;
			while(cnt<=999){
			for (int j = 1;j<=10000; j++){   
				String s = String.valueOf(j);
				String str1 = stra.replaceFirst("0", s);
				String str2 = strb.replaceFirst("0", s);
				
				//System.out.println("hello world4"); //��� 'hello world4'��ʾ�������ؽ׶Σ����ڵ���
				
				//System.out.println("hello world1");
				try{
					WebElement pic = driver.findElement(By.xpath(str1));
					String url=pic.getAttribute("src");
					
					
					WebElement t = driver.findElement(By.xpath(str2));
					String ta=t.getAttribute("title");
					
					
					 int index1 = url.indexOf("https://");
					 if (index1==-1){
						 continue;
					 }
				 
					 String path="G:\\yesenmao\\flickr\\"+tag+"\\"+String.valueOf(cnt+1)+".jpg";
						int flag=SaveFile.saveToFile(url, path);
						System.out.println(flag); 
						if(flag<=1)
							continue;
						
						
						System.out.println(url);                                        //save image
						
						bufferedWriter.write(String.valueOf(cnt+1)+"     "+ta+"\r\n");
						System.out.println(ta);                                         //save tag
						cnt++;
						System.out.println(cnt);
						if(cnt>=999){
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
		{//�������ģ�����·�ҳ��'j'���ظ��Ĵ���,Ҫ���ݾ����      ���ٱ䶯    ��Ҫȷ��ҳ������ʾ���㹻��ͼƬ����������
			//��ҳ��ʱ��   �����   ���� ��    ��ǰ�棡��������
		   Robot robot=new Robot();
		   for (int j = 1;j<=10; j++){           
		   robot.delay(1000);
		   robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		   robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		   ///robot.mouseWheel(15);
		 }

		}

}

