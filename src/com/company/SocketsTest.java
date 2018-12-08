package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketsTest {

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
        BufferedReader in =
                new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;

        out.println("ping");

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Program B says: " + inputLine);
            out.println("server: " + inputLine);
            if (inputLine.equals("quit"))
                break;
        }
    }

}
