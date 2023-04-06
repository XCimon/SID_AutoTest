package com.example.demo;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ChunkedServerDemo {
    
    private static final int CHUNK_SIZE = 1; // 每次返回 1 字节
    
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket client = server.accept();
            new Thread(() -> {
                try {
                    OutputStream outputStream = client.getOutputStream();
                    // 设置响应头信息，使用分块传输编码
                    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                    outputStream.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
                    outputStream.write("Transfer-Encoding: chunked\r\n".getBytes());
                    outputStream.write("\r\n".getBytes());
                    // 循环生成随机数据块并发送
                    Random random = new Random();
                    for (int i = 0; i < 100; i++) {
                        String chunk = getRandomChineseString(1024);
                        int length = chunk.getBytes("UTF-8").length;
                        String chunkHeader = Integer.toHexString(length) + "\r\n";
                        outputStream.write(chunkHeader.getBytes());
                        outputStream.write(chunk.getBytes("UTF-8"));
                        outputStream.write("\r\n".getBytes());
                        outputStream.flush();
                        Thread.sleep(100); // 模拟每隔1秒发送一个块
                    }
                    // 发送数据传输结束的标识
                    outputStream.write("0\r\n\r\n".getBytes());
                    outputStream.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
    
    private static String getRandomChineseString(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(0x7FFF - 0x4E00) + 0x4E00);
            builder.append(c);
        }
        return builder.toString();
    }
    
    
    private static String getRandomChineseString() {
        int highCode = (176 + Math.abs(new Random().nextInt(39)));
        int lowCode = (161 + Math.abs(new Random().nextInt(93)));
        byte[] b = new byte[2];
        b[0] = (Integer.valueOf(highCode)).byteValue();
        b[1] = (Integer.valueOf(lowCode)).byteValue();
        try {
            return new String(b, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    
}

