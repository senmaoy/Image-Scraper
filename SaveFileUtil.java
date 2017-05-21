package ME;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SaveFileUtil {

    public final static boolean DEBUG = false;//������

    private static int BUFFER_SIZE = 8096;

    /**
       * ��HTTP��Դ���Ϊ�ļ�
       *
       * @param destUrl String
       * @param fileName String
       * @throws Exception
       */
      public static void saveToFile(String destUrl, String fileName) {
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        HttpURLConnection httpUrl = null;
        URL url = null;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
        //��������
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            //����ָ������Դ
            
            httpUrl.connect();
            //��ȡ����������
            bis = new BufferedInputStream(httpUrl.getInputStream());
            //�����ļ�
            fos = new FileOutputStream(fileName);
            //�����ļ�
            if (DEBUG) 
                System.out.println("���ڻ�ȡ����[" + destUrl + "]������..\n���䱣��Ϊ�ļ�[" + fileName + "]");
            while ( (size = bis.read(buf)) != -1) {
              fos.write(buf, 0, size);
            }
           
            
            

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fos!=null)fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bis!=null)bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpUrl.disconnect();
        }
		
        
      }
      
}