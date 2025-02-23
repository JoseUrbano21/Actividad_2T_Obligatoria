package servidor;

import modelo.Pokemon;

import java.util.ArrayList;

public class BancoPokemon {

    // Se crea un buffer que contiene una lista de pokémon. Al generar el buffer, se cargan 10 pokémon
    private final ArrayList<Pokemon> lista;

    public BancoPokemon() {
        lista = new ArrayList<>();
        cargarPokemon();
    }

    // Lista de pokémon que se añaden al buffer al crearlo
    private void cargarPokemon() {
        lista.add(new Pokemon("Wigglytuff", "Normal", "Hada"));
        lista.add(new Pokemon("Venusaur", "Planta", "Veneno"));
        lista.add(new Pokemon("Charizard", "Fuego", "Volador"));
        lista.add(new Pokemon("Blastoise", "Agua", ""));
        lista.add(new Pokemon("Onix", "Roca", "Tierra"));
        lista.add(new Pokemon("Gengar", "Fantasma", "Veneno"));
        lista.add(new Pokemon("Jynx", "Hielo", "Psíquico"));
        lista.add(new Pokemon("Dragonite", "Dragón", "Volador"));
        lista.add(new Pokemon("Heracross", "Bicho", "Lucha"));
        lista.add(new Pokemon("Umbreon", "Siniestro", ""));
    }

    // Metodo para devolver al participante un pokemon de la lista
    public synchronized Pokemon asignarPokemon(String nombre) {
        // Recorremos la lista buscando el pokémon solicitado
        for (int i = 0; i < lista.size(); i++) {
            Pokemon ele = lista.get(i);
            if (ele.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Este es tu Pokémon: " + ele.getNombre());
                // Devuelve el pokémon solicitado y lo elimina de la lista
                return lista.remove(i);
            }
        }
        // Si no se encuentra en la lista
        System.out.println("El pokémon solicitado no está disponible.");
        System.out.println("Elige uno de los pokémon disponibles:");
        System.out.println(lista);
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Pokémon disponibles:\n");
        for (Pokemon p : lista) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}