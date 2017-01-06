package elon.httpclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/*xml接口 -发送一个xml数据*/
public class TestHttp {
    public void testRegist(){
        try{
            StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> ");
            sb.append("<getData>");
            sb.append("<recNum>2015</recNum>");
            sb.append("<accountID>wangxin2015</accountID>");
            sb.append("</getvData>");
            byte[] xmlbyte = sb.toString().getBytes("UTF-8");
            URL url = new URL("http://xx:8180/xuxxx/xxxxxx");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
            outStream.write(xmlbyte);
            outStream.flush();
            BufferedReader  in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer sb2 = new StringBuffer();
            String lines = "";
            while(null!=(lines = in.readLine()))
            {
                sb2.append(lines);
            }
            System.out.println(sb2.toString());
            // in.read(b)
            in.close();
            outStream.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}