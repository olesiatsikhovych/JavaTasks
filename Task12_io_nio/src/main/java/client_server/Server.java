package client_server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        Server server = new Server(6666);
    }

    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream inputStream;

    public Server(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client");

            socket = serverSocket.accept();
            System.out.println("Client accepted");

            inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("Stop")){
                try {
                    line = inputStream.readUTF();
                    System.out.println(line);
                }
                catch (IOException c){
                    System.out.println(c);
                }
            }
            System.out.println("Closing connection");
            socket.close();
            inputStream.close();
        }
        catch (IOException d){
            System.out.println(d);
        }
    }
}
