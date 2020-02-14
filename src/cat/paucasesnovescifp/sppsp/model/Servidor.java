package cat.paucasesnovescifp.sppsp.model;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) {
        // Pedimos cuantos clientes queremos soportar
        System.out.println("Quants clients vols acceptar com a màxim?");
        Scanner sc = new Scanner(System.in);
        // Variable de número de clientes
        final int MAX_CLIENTS = sc.nextInt();

        try {
            // Se inicializa el socket del servidor con el puerto asignado
            ServerSocket socketServidor = new ServerSocket(5555);

            // inicializacion de dirección donde el socketServidor escuchará
            //InetSocketAddress direccion = new InetSocketAddress(5555);
            // El socketServidor empieza a escuchar por la direccion de la linea anterior
            //socketServidor.bind(direccion);

            System.out.println("Servidor inicialitzat");

            for(int i = 0; i < MAX_CLIENTS; i++) {
                //byte[] mensaje = new byte[25]; // Array que guardará la información enviada desde el cliente

                // Inicialización de un socket cliente que haya hecho una petición al servidor
                Socket socketNou = socketServidor.accept();
                // Se inicializa la entrada de informacion del cliente - el msg del cliente al servidor
                DataInputStream entrada = new DataInputStream(socketNou.getInputStream());
                // se inicializa la salida de informacion del cliente - el msg del servidor al cliente
                DataOutputStream sortida = new DataOutputStream(socketNou.getOutputStream());

                //entrada.read(entrada.readUTF()); // Introduce todo lo escrito por el cliente
                System.out.println("El client "+ i +" diu: " + entrada.readUTF());
                // mensaje predefinido que se va a enviar a cada cliente
                String serverMSN = "Ets el client " + i;
                // Envia el mensaje de la linea anterior al cliente
                sortida.writeUTF(serverMSN);

                // Cierre de objetos socket, InputStream y OutputStream dirigidos a los nuevos clientes
                entrada.close();
                sortida.close();
                socketNou.close();
            }

            /*while(true){
                // Inicialización de un socket cliente que haya hecho una petición al servidor
                Socket socketNou = socketServidor.accept();
                // Se inicializa la entrada de informacion del cliente - el msg del cliente al servidor
                DataInputStream entrada = new DataInputStream(socketNou.getInputStream());
                // se inicializa la salida de informacion del cliente - el msg del servidor al cliente
                DataOutputStream sortida = new DataOutputStream(socketNou.getOutputStream());

                //entrada.read(entrada.readUTF()); // Introduce todo lo escrito por el cliente
                System.out.println("El client diu: " + entrada.readUTF());
                // mensaje predefinido que se va a enviar a cada cliente
                //System.out.println("Introduce la respuesta al cliente");
                String serverMSN = sc.nextLine();

                // Envia el mensaje de la linea anterior al cliente
                sortida.writeUTF(serverMSN);

                // Cierre de objetos socket, InputStream y OutputStream dirigidos a los nuevos clientes
                entrada.close();
                sortida.close();
                socketNou.close();
            }*/

            System.out.println("Servidor aturat.");
            // Cierre del socket servidor
            socketServidor.close();

        } catch (IOException e) {
            System.out.println("Error servidor: " + e.getMessage());
        }
    }

}
