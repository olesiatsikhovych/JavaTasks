package client_server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 6666);
    }

    private Socket socket;
    private BufferedReader input;
    private DataOutputStream output;

    public Client(String address, int port) {
        try {
            socket = new Socket(address,port);
            System.out.println("Connected");

            input = new BufferedReader(new InputStreamReader(System.in));

            output = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException a) {
            System.out.println(a);
        }

        String line = "";
        while (!line.equals("Stop")){
            try {
                line = input.readLine();
                output.writeUTF(line);
            }
            catch (IOException b){
                System.out.println(b);
            }
        }
        try {
            input.close();
            output.close();
            socket.close();
        }
        catch (IOException b){
            System.out.println(b);
        }
    }
}
