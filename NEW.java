package ME;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*; 

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.firefox.*;
public class NEW {

	public static void main(String tag) {
		// TODO Auto-generated method stub
		System.out.println("hello world1");// ���ڵ��ԣ�����ɾ��
		//String tag="ţ";
        WebDriver driver = new FirefoxDriver();  
		Navigation navi= driver.navigate();
		navi.to("https://www.flickr.com/search/");
		//ģ������entity name
		WebElement txt = driver.findElement(By.name("text"));
		txt.sendKeys(tag);
		txt.sendKeys(Keys.ENTER);
		
		//���ɴ���ͼƬ���ļ�
		String pas="C:\\Users\\ey\\Desktop\\scraper\\downn\\flickr\\"+tag;
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
		
		   // the xpath of images from flickr, if the website was changed,the 
			//xpath will be changed too.
		
		
			String stra = "/html/body/div[1]/div/main/div/div[1]/section/div[0]/div/figure/div[1]/a/img";
			String strb="/html/body/div[1]/div/main/div/div[1]/section/div[0]/div/figure/div[2]/div[1]/div/span[1]/a";
			int j=1;
			while (j<=100){   //����'j'��������ͼƬ��������Ҫ��֤ҳ�����Ѿ�����ô���ͼƬ!!!
				String s = String.valueOf(j);
				String str1 = stra.replaceFirst("0", s);
				String str2 = strb.replaceFirst("0", s);
				
				System.out.println("hello world4"); //��� 'hello world4'��ʾ�������ؽ׶Σ����ڵ���
				
				WebElement pic = driver.findElement(By.xpath(str1));
				String url=pic.getAttribute("src");
				
				WebElement t = driver.findElement(By.xpath(str2));
				String tags=t.getAttribute("title");
				
				System.out.println(url);
				
				
				int index1 = url.indexOf("https://");
				 if (index1==-1){//����URL�Ƿ����
					 continue;
				 }
				 
				 //����ͼƬ
				String path="C:\\Users\\ey\\Desktop\\scraper\\downn\\flickr\\"+tag+"\\"+s+"_"+tags+".jpg";
				try{
				SaveFileUtil.saveToFile(url, path);	
				j++;
				}catch(Exception e){
					try {
						test();
					} catch (AWTException ex) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
				}
			
			
			driver.close();
			
			}
			

	
	
		public static void test()throws AWTException  
		{//�������ģ�����·�ҳ��'j'���ظ��Ĵ���,Ҫ���ݾ����      ���ٱ䶯    ��Ҫȷ��ҳ������ʾ���㹻��ͼƬ����������
			//��ҳ��ʱ��   �����   ���� ��    ��ǰ�棡��������
		   Robot robot=new Robot();
		   for (int j = 1;j<=2; j++){           
		   robot.delay(1000);
		   robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		   robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		   robot.mouseWheel(15);
		 }

		}

}

