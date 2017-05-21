package ME;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SaveFileUtil {

    public final static boolean DEBUG = false;//调试用

    private static int BUFFER_SIZE = 8096;

    /**
       * 将HTTP资源另存为文件
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
        //建立链接
        try {
            url = new URL(destUrl);
            httpUrl = (HttpURLConnection) url.openConnection();
            //连接指定的资源
            
            httpUrl.connect();
            //获取网络输入流
            bis = new BufferedInputStream(httpUrl.getInputStream());
            //建立文件
            fos = new FileOutputStream(fileName);
            //保存文件
            if (DEBUG) 
                System.out.println("正在获取链接[" + destUrl + "]的内容..\n将其保存为文件[" + fileName + "]");
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