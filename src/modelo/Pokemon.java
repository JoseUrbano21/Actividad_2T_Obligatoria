package modelo;

import java.io.Serializable;
import java.util.Objects;

public class Pokemon implements Serializable {

    // Atributos que tienen los pokemon. Se serializa para poder enviarse en las conexiones entre cliente-servidor
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String tipo1;
    private String tipo2;

    // Constructor
    public Pokemon(String nombre, String tipo1, String tipo2) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    // GETTER and SETTER de los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    // equals y hashCode para identificar cada pokemon por su Nombre y que no haya dos nombres iguales
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(nombre, pokemon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return "Pokémon{" +
                "Nombre:'" + nombre + '\'' +
                ", Tipo 1:'" + tipo1 + '\'' +
                ", Tipo 2:'" + tipo2 + '\'' +
                '}';
    }
}