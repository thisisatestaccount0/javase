package module7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

// http协议
public class Demo1_BaiduSearchDemo {
    private static final String BAIDU_SEARCH_URL = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=%s&fenlei=256&rsv_pq=0xcd5e5ad800096876&rsv_t=8bd0lUZ4xiCPqowi1DlYmMReTJzGohIFm03cJ2jd108nypybVS2zo2wYbhnz&rqlang=en&rsv_enter=1&rsv_dl=tb&rsv_sug3=5&rsv_sug1=2&rsv_sug7=100&rsv_sug2=0&rsv_btype=i&inputT=236139&rsv_sug4=236139";

    public static void main(String[] args) {
        String keyword = "java";
        try {
            String urlStr = String.format(BAIDU_SEARCH_URL, URLEncoder.encode(keyword,"UTF-8"));
            URL url = new URL(urlStr);

            //
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            // http 状态码
            //2xx  正常访问
            //3xx  重定向相关
            //4xx  资源不可用（404 not found）
            //5xx  服务端错误（502 内部服务器错误）
            int code = conn.getResponseCode();
            if(code == 200) {
                System.out.println("正常访问网站");
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                String line = null;
                while ((line = br.readLine()) != null) { // 如果为null，说明传输的内容结束了。
                    System.out.println(line);
                }
                br.close();
            } else {
                System.err.println("访问失败，状态码是：" + code);
            }
            conn.disconnect();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
