package cat.paucasesnovescifp.sppsp.model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHilo extends Thread{

    @Override
    public void run() {
        try {
            // Inicializamos socket cliente con un puerto y una ip predeterminada
            Socket socket = new Socket("127.0.0.1",5555);

            // inicializacion de dirreción donde el socket será abierto
            //InetSocketAddress direccion = new InetSocketAddress(5555);
            // Se abre el socket a la dirrección especificada en la anterior linea
            //socket.connect(direccion);

            System.out.println("Connexió iniciada");

            // Se inicializa la entrada de informacion del cliente - el msg del servidor al cliente
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            // se inicializa la salida de informacion del cliente - el msg del cliente al servidor
            DataOutputStream sortida = new DataOutputStream(socket.getOutputStream());

            //System.out.println("Introdueixi el missatge que voleu enviar:");
            // Escaner el cual permite personalizar el texto enviado al servidor
            //Scanner sc = new Scanner(System.in);

            // se envia lo que se escribe al servidor
            sortida.writeUTF("Hola soy un cliente");


            System.out.println("Resposta del servidor: " + entrada.readUTF());
            // Cierre de objetos socket, InputStream y OutputStream.
            entrada.close();
            sortida.close();
            socket.close();
            System.out.println("Connexió finalitzada");


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
