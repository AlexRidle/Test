package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketsForAppTwo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 4567);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader sysIn = new BufferedReader(new InputStreamReader(System.in));
        String fromServer;
        String fromUser;

        int type = 0;
        String path = null;

        while ((fromServer = in.readLine()) != null) {
            if (fromServer.equals("quit"))
                break;

            System.out.println(path + type);
            fromUser = sysIn.readLine();
            if (fromUser != null) {
                out.println(fromUser);
            }
        }
    }
}