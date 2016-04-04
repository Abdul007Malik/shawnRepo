package core;


import org.jsoup.nodes.Document;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class UrlList {

    List<String> allUrl;

    public List<String> getUrl() {
        return allUrl;
    }

    public void setAllUrl(String url) throws Exception {

        if(url==null && dirpath==null){
            System.out.println(GrabUtility.usageMessage);
            throw new Exception("Url or Output directory is invalid");
        }

        // in case no http protocol specified then add protocol part
        // to form proper url
        if(!url.startsWith("http://") && !url.startsWith("https://")){
            url="http://" + url;
        }
        URL rootUrl = new URL(url);


      /*  File dir = new File(dirpath);
        if(dir.exists() && dir.isFile()){
            System.out.println("output directory path is wrong, please provide some directory path");
            return;
        }
        else if(!dir.exists()){
            dir.mkdirs();
            System.out.println("Directory Created!!");
        }




    */

        Document resHtmlDoc =null;
        String urlToGrab = null;




    }


   public static void getWebPage(URL obj, File outputDir){
       FileOutputStream fop =null;
       BufferedReader in = null;
       HttpURLConnection conn =null;
       File outputFile =null;
       InputStream is =null;
       try{
           String path = obj.getPath();
           String fileName = path.substring(path.lastIndexOf('/')+1);
           if(fileName.equals("/") || fileName.equals("")){
               fileName = "default.html";
           }
           System.out.println(fileName);

           //Output FileName
           outputFile = new File(outputDir,fileName);

           conn = (HttpURLConnection) obj.openConnection();
           conn.setReadTimeout(5000);
           conn.addRequestProperty("Accept-Language","en-US,en;q=0.8");
           conn.addRequestProperty("User-Agent","Java");
           conn.addRequestProperty("Referer","google.com");

           boolean redirect = false;

           //normally, 3xx is redirect
           int status = conn.getResponseCode();
           if(status!=HttpURLConnection.HTTP_OK){
               if(status == HttpURLConnection.HTTP_MOVED_TEMP|| status == HttpURLConnection.HTTP_MOVED_PERM
                       || status == HttpURLConnection.HTTP_SEE_OTHER){
                   redirect = true;
               }else{
                   System.out.println("Unable to get resource mostly 404 "+status);
                   return;
               }
           }

           System.out.println("Response Code ... " + status);

           if(redirect){

           }







       }catch (Exception e){
           System.out.println("Excpetion in getting webpage - "+obj);
           e.printStackTrace();
       }
       finally {
           try {
               if(is != null){
                   is.close();
               }
               if(in != null){
                   in.close();
               }
               if (fop != null) {
                   fop.close();
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
}