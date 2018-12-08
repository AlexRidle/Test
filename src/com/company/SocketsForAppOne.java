package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SocketsForAppOne {

    public static int type = 4;
    public static String path = "path to file";

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4567);
        }
        catch (IOException e) {
            System.out.println("Could not listen on port: 4567");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        }
        catch (IOException e) {
            System.out.println("Accept failed: 4567");
            System.exit(-1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;

        out.println("connected");

        while ((inputLine = in.readLine()) != null) {
            if (inputLine.equals("type")) {
                out.println(type);
            } else if (inputLine.equals("path")) {
                out.println(path);
            } else if (inputLine.equals("quit")) {
                out.println(inputLine);
                break;
            } else {
                out.println("response");
                System.out.println(inputLine);
            }
        }

    }
}
