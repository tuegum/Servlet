package tuegum.web.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

public class DownloadUtils {
    public static String getFilename(String agent,String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")){
            //IE浏览器
            filename = URLEncoder.encode(filename,"utf-8");
            filename = filename.replace("+","");
        }else if (agent.contains("Firefox")){
//            Base64.Encoder encoder = new Base64.Encoder();
        }else{
            filename = URLEncoder.encode(filename,"utf-8");
        }
    return filename;
    }
}
