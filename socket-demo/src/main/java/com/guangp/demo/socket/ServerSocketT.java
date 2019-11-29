package com.guangp.demo.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketT {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3333);
        new Thread(() -> {
            while (true) {
                try {
                    Socket s = ss.accept();
                    new Thread(() -> {
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = s.getInputStream();
                            // 按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {

                        }
                    }).start();
                } catch (IOException e) {

                }
            }
        }).start();
    }
}
