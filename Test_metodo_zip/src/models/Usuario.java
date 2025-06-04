package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private List<Libro> librosPrestados;

    public Usuario(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void prestarLibro(Libro libro) {
        librosPrestados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        librosPrestados.remove(libro);
    }

    public void mostrarInfo() {
        System.out.println("Usuario: " + nombre + " (ID: " + id + ")");
        System.out.println("Libros prestados:");
        for (Libro libro : librosPrestados) {
            System.out.println("  - " + libro.getTitulo());
        }
    }
}
