package com.epam.university.java.core.task031;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class ServerImpl implements Server {
    private boolean isWorking = true;
    private ServerSocket serverSocket;
    private final LinkedList<String> messages = new LinkedList<>();

    @Override
    public String readMessage() {
        if (messages.isEmpty()) {
            return "";
        } else {
            return messages.removeLast();
        }
    }

    @Override
    public void start() {
        new Thread(() -> {
            try {
                serverSocket = new ServerSocket(6000);
                while (isWorking) {
                    Socket clientSocket = serverSocket.accept();
                    new Thread(() -> {
                        try (BufferedReader in = new BufferedReader(
                                new InputStreamReader(clientSocket.getInputStream()))) {
                            while (isWorking) {
                                if (in.ready()) {
                                    messages.add(in.readLine());
                                }
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void stop() {
        isWorking = false;
        try {
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}