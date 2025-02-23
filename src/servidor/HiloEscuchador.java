package servidor;

import modelo.Inscripcion;
import modelo.Pokemon;

import java.io.*;
import java.net.Socket;

public class HiloEscuchador implements Runnable {
    private Thread hilo;
    private static int numeroParticipante = 0;
    private Socket nuevoParticipante;
    private BancoPokemon bancoPokemon;

    // Constructor del hilo pasando el cliente y el banco de Pokémon
    public HiloEscuchador(Socket participante, BancoPokemon bancoPokemon) {
        numeroParticipante++;
        hilo = new Thread(this, "PARTICIPANTE Nº " + numeroParticipante);
        this.nuevoParticipante = participante;
        this.bancoPokemon = bancoPokemon;
        hilo.start();
    }

    @Override
    public void run() {

        ObjectInputStream input = null;
        ObjectOutputStream output = null;
        Inscripcion inscripcion = null;

        try {
            input = new ObjectInputStream(nuevoParticipante.getInputStream());
            output = new ObjectOutputStream(nuevoParticipante.getOutputStream());

            // Enviamos automáticamente la lista de Pokémon disponibles al conectar
            output.writeObject(bancoPokemon.toString());
            output.flush();

            // Recibe la inscripción del cliente
            inscripcion = (Inscripcion) input.readObject();
            Object respuesta;

            String nombrePokemon = inscripcion.getNombrePokemon();
            String nombreParticipante = inscripcion.getNombreParticipante();

            // Asigna el Pokémon solicitado
            Pokemon pokemonAsignado = bancoPokemon.asignarPokemon(nombrePokemon);

            if (pokemonAsignado != null) {
                respuesta = "¡" + nombreParticipante + ", tu Pokémon asignado es: " + pokemonAsignado + "!";
            } else {
                respuesta = "El Pokémon '" + nombrePokemon + "' no está disponible. Pokémon disponibles: " + bancoPokemon.toString();
            }

            // Envía la respuesta al cliente
            output.writeObject(respuesta);
            output.flush();
            System.out.println("Respuesta enviada a " + nombreParticipante);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            // Cierre de conexiones
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (nuevoParticipante != null) nuevoParticipante.close();
                System.out.println("Conexión cerrada con " + hilo.getName());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}