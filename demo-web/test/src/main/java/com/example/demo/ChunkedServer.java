package com.example.demo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class ChunkedServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");
        
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");
            
            OutputStream outputStream = clientSocket.getOutputStream();
            byte[] header = ("HTTP/1.1 200 OK\r\n" +
                    "Transfer-Encoding: chunked\r\n" +
                    "Content-Type: text/plain; charset=utf-8\r\n" +
                    "\r\n").getBytes(StandardCharsets.UTF_8);
            outputStream.write(header);
            
            Random random = new Random();
            int chunkSize = 10; // 自定义分块大小
            for (int i = 0; i < 50; i++) {
                byte[] chunk = generateRandomString(chunkSize).getBytes(StandardCharsets.UTF_8);
                String hexChunkSize = Integer.toHexString(chunkSize);
                byte[] chunkHeader = (hexChunkSize + "\r\n").getBytes(StandardCharsets.UTF_8);
                outputStream.write(chunkHeader);
                outputStream.write(chunk);
                outputStream.write("\r\n".getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            outputStream.write("0\r\n\r\n".getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
            
            clientSocket.close();
            System.out.println("Client disconnected");
        }
    }
    
    private static String generateRandomString(int length) {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            builder.append((char) (random.nextInt(20902) + 19968));
        }
        return builder.toString();
    }
}
