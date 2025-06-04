package main;

import models.*;
import services.Biblioteca;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Crear autores
        Autor autor1 = new Autor("Gabriel García Márquez", "Autor de Cien años de soledad.");
        Autor autor2 = new Autor("J.K. Rowling", "Creadora de Harry Potter.");

        // Crear libros
        Libro libro1 = new Libro("Cien años de soledad", autor1, "978-3-16-148410-0");
        Libro libro2 = new Libro("Harry Potter y la piedra filosofal", autor2, "978-0-7475-3269-9");

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        // Crear usuarios
        Usuario usuario1 = new Usuario("U001", "Juan Pérez");

        biblioteca.registrarUsuario(usuario1);

        // Préstamo de libro
        biblioteca.prestarLibro("U001", "Cien años de soledad");

        // Mostrar información de usuarios
        biblioteca.mostrarUsuarios();
    }
}
