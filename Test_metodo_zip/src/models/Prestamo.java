package models;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private Date fechaInicio;
    private Date fechaDevolucion;

    public Prestamo(Libro libro, Usuario usuario, Date fechaInicio, Date fechaDevolucion) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo: " + libro.getTitulo() + " a " + usuario.getNombre() + " desde " + fechaInicio + " hasta " + fechaDevolucion;
    }
}
