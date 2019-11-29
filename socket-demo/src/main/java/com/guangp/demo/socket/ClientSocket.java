package com.guangp.demo.socket;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class ClientSocket {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3333);
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                try {
                    socket.getOutputStream().write((new Date() + ": Hello World.").getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
