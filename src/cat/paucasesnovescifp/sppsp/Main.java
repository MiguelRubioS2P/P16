package cat.paucasesnovescifp.sppsp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(55054,3);
            Socket socket = new Socket("127.0.0.1",55054);

        } catch (IOException e) {
            System.out.println("Error de socket: " + e.getMessage());
        }
    }
}
