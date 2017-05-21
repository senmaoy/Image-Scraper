package ME;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FI {
// 这个 函数用于读取   query list，然后调用相关的selenium函数
	//query list 的 存放方式不一样的话，还要修改一下这个函数 或者 query list
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 String filePath = "C:\\Users\\ey\\Desktop\\scraper\\downn\\list.txt";
	 try {
         String encoding="GBK";
         File file=new File(filePath);
         if(file.isFile() && file.exists()){ //判断文件是否存在
             InputStreamReader read = new InputStreamReader(
             new FileInputStream(file),encoding);//考虑到编码格式
             BufferedReader bufferedReader = new BufferedReader(read);
             String lineTxt = null;
             while((lineTxt = bufferedReader.readLine()) != null){
         	        //BING.main(lineTxt);// 调用 selenium函数，下载图片
            	 //BINGE.main(lineTxt); 
            	 //GOOLE.main(lineTxt);
         	        FLICKR.main(lineTxt);
         	        //instagram.main(lineTxt);
            	     // NEW.main(lineTxt);
             }
             read.close();
 }else{
     System.out.println("找不到指定的文件");
 }
 } catch (Exception e) {
     System.out.println("读取文件内容出错");
     e.printStackTrace();
 }
		
		

	}
 
}
