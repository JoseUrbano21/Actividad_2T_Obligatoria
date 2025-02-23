package cliente;

import modelo.Inscripcion;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("INSCRIPCIÓN AL TORNEO");
        System.out.println("---------------------------------------");

        try (Socket cliente = new Socket()) {
            // Conexión al servidor
            InetSocketAddress direccionServidor = new InetSocketAddress("localhost", 8000);
            System.out.println("Conectando al servidor...");
            cliente.connect(direccionServidor);
            System.out.println("Conexión establecida con el servidor.");

            ObjectOutputStream output = new ObjectOutputStream(cliente.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(cliente.getInputStream());

            // Mostramos la lista enviada automáticamente por el servidor
            Object listaDisponible = input.readObject();
            System.out.println("\n✨ Pokémon disponibles para el torneo: " + listaDisponible.toString() + "\n");

            // Solicitar datos al usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce tu nombre: ");
            String nombreParticipante = scanner.nextLine();
            System.out.print("Introduce el nombre del Pokémon que deseas de la lista: ");
            String nombrePokemon = scanner.nextLine();

            // Crear y enviar el objeto Inscripcion
            Inscripcion inscripcion = new Inscripcion(nombreParticipante, nombrePokemon);
            output.writeObject(inscripcion);
            output.flush();
            System.out.println("Inscripción enviada al servidor...");

            // Recibir y mostrar la respuesta del servidor
            Object respuesta = input.readObject();
            System.out.println("Respuesta del servidor: " + respuesta);

            // Cierre de conexiones
            input.close();
            output.close();
            cliente.close();
            System.out.println("Conexión cerrada.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}