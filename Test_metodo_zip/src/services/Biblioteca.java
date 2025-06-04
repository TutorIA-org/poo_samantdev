package services;

import models.Libro;
import models.Usuario;
import models.Prestamo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> buscarLibrosPorAutor(String nombreAutor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().getNombre().equalsIgnoreCase(nombreAutor)) {
                resultados.add(libro);
            }
        }
        return resultados;
    }

    public boolean prestarLibro(String idUsuario, String tituloLibro) {
        Usuario usuario = buscarUsuario(idUsuario);
        Libro libro = buscarLibroPorTitulo(tituloLibro);

        if (usuario != null && libro != null && libro.isDisponible()) {
            libro.prestar();
            usuario.prestarLibro(libro);
            prestamos.add(new Prestamo(libro, usuario, new Date(), null));
            System.out.println("Libro prestado exitosamente.");
            return true;
        }
        System.out.println("No se pudo realizar el préstamo.");
        return false;
    }

    public boolean devolverLibro(String idUsuario, String tituloLibro) {
        Usuario usuario = buscarUsuario(idUsuario);
        if (usuario == null) return false;

        for (Libro libro : usuario.getLibrosPrestados()) {
            if (libro.getTitulo().equalsIgnoreCase(tituloLibro)) {
                usuario.devolverLibro(libro);
                libro.devolver();
                System.out.println("Libro devuelto exitosamente.");
                return true;
            }
        }
        System.out.println("El usuario no tiene este libro.");
        return false;
    }

    private Usuario buscarUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public void mostrarUsuarios() {
        for (Usuario usuario : usuarios) {
            usuario.mostrarInfo();
        }
    }
}
