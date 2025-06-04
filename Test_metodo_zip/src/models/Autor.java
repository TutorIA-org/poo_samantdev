package models;

public class Autor {
    private String nombre;
    private String biografia;

    public Autor(String nombre, String biografia) {
        this.nombre = nombre;
        this.biografia = biografia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBiografia() {
        return biografia;
    }

    @Override
    public String toString() {
        return nombre + " - " + biografia;
    }
}
