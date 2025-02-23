package servidor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        System.out.println("INSCRIPCIONES AL TORNEO");
        System.out.println("----------------------------------");
        try {
            // Creamos un socket para el servidor y definimos el puerto
            ServerSocket servidor = new ServerSocket();
            InetSocketAddress direccion = new InetSocketAddress("localhost", 8000);
            servidor.bind(direccion);

            // Creamos el banco de pokémon
            BancoPokemon bancoPokemon = new BancoPokemon();

            // Damos un mensaje de feedback al ejecutar el servidor
            System.out.println("Servidor listo para aceptar inscripciones");
            System.out.println("Dirección IP: " + direccion.getAddress());

            // Por cada cliente que se conecte al servidor, se creará un socket para el cliente y un hilo
            while (true) {
                Socket nuevoParticipante = servidor.accept();
                System.out.println("Comunicación entrante");
                new HiloEscuchador(nuevoParticipante, bancoPokemon);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}