package modelo;

import java.io.Serializable;

public class Inscripcion implements Serializable {

    // Atributos de la inscripcion: nombre del participante y del pokemon que peticiona
    private String nombreParticipante;
    private String nombrePokemon;

    // Constructor
    public Inscripcion(String nombreParticipante, String nombrePokemon) {
        this.nombreParticipante = nombreParticipante;
        this.nombrePokemon = nombrePokemon;
    }

    // Getter
    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    @Override
    public String toString() {
        return "Inscripción{" +
                "Participante:'" + nombreParticipante + '\'' +
                ", Pokémon solicitado:'" + nombrePokemon + '\'' +
                '}';
    }
}
