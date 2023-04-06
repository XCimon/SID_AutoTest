package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ChunkedClientExample {
    
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/chunked-data");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Transfer-Encoding", "chunked");
        
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line = reader.readLine()) != null) {
            // 将每个字符逐字输出
            System.out.println(">");
            for (int i = 0; i < line.length(); i++) {
                System.out.print(line.charAt(i));
                Thread.sleep(10); // 暂停一段时间，模拟逐字显示的效果
            }
        }
        
        reader.close();
        connection.disconnect();
    }
}
