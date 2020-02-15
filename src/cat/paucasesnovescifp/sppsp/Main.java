package cat.paucasesnovescifp.sppsp;

import cat.paucasesnovescifp.sppsp.model.Cliente;
import cat.paucasesnovescifp.sppsp.model.ClienteHilo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        ClienteHilo cliente1 = new ClienteHilo();
        ClienteHilo cliente2 = new ClienteHilo();
        ClienteHilo cliente3 = new ClienteHilo();
        ClienteHilo cliente4 =  new ClienteHilo();

        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
    }
}
