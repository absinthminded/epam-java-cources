package com.epam.university.java.core.task031;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientImpl implements Client {
    private Socket serverSocket;
    private PrintWriter out;

    @Override
    public void sendMessage(String message) {
        try {
            out.write(message + "\n");
            out.flush();
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start() {
        try {
            Thread.sleep(100);
            serverSocket = new Socket(InetAddress.getLocalHost(), 6000);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    serverSocket.getOutputStream());
            out = new PrintWriter(new BufferedWriter(outputStreamWriter), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws IOException {
        try {
            serverSocket.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
