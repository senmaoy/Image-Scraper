package ME;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FI {
// ��� �������ڶ�ȡ   query list��Ȼ�������ص�selenium����
	//query list �� ��ŷ�ʽ��һ���Ļ�����Ҫ�޸�һ��������� ���� query list
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 String filePath = "C:\\Users\\ey\\Desktop\\scraper\\downn\\list.txt";
	 try {
         String encoding="GBK";
         File file=new File(filePath);
         if(file.isFile() && file.exists()){ //�ж��ļ��Ƿ����
             InputStreamReader read = new InputStreamReader(
             new FileInputStream(file),encoding);//���ǵ������ʽ
             BufferedReader bufferedReader = new BufferedReader(read);
             String lineTxt = null;
             while((lineTxt = bufferedReader.readLine()) != null){
         	        //BING.main(lineTxt);// ���� selenium����������ͼƬ
            	 //BINGE.main(lineTxt); 
            	 //GOOLE.main(lineTxt);
         	        FLICKR.main(lineTxt);
         	        //instagram.main(lineTxt);
            	     // NEW.main(lineTxt);
             }
             read.close();
 }else{
     System.out.println("�Ҳ���ָ�����ļ�");
 }
 } catch (Exception e) {
     System.out.println("��ȡ�ļ����ݳ���");
     e.printStackTrace();
 }
		
		

	}
 
}
