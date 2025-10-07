package Modelo;

public class Materia {

    private int idMateria = -1;
    private String nombre;
    private int anio;
    private int estado;

    public Materia() {
    }

    public Materia(int idMateria, String nombre, int anio, int estado) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }
    
    public Materia(String nombre, int anio, int estado) {
        this.nombre = nombre;
        this.anio = anio;
        this.estado = estado;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public int getEstado() {
        return estado;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Materia: " + "idMateria: " + idMateria + ", nombre: " + nombre + ", año: " + anio + ", estado: " + estado;
    }

}
