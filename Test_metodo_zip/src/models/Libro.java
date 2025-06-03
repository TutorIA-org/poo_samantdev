package models;

public class Libro {
    private String titulo;
    private Autor autor;
    private String isbn;
    private boolean disponible;

    public Libro(String titulo, Autor autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestar() {
        this.disponible = false;
    }

    public void devolver() {
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor.getNombre() + ", ISBN: " + isbn + ", Disponible: " + disponible;
    }
}
