/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.Date;





/**
 *
 * @author paula
 */
public class alumno {
    int idAlumno;
    int dni;
    String apellido;
    String nombre;
    LocalDate fechaNacimiento;
    int estado;

    public alumno() {
    }

    
    public alumno(int idAlumno, int dni, String apellido, String nombre, LocalDate fecha, int estado) {
        this.idAlumno = idAlumno;
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fecha;
        this.estado = estado;
    }

    public alumno(int dni, String apellido, String nombre, LocalDate fecha, int estado) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fecha;
        this.estado = estado;
    }


    
    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "alumno{" + "idAlumno=" + idAlumno + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", estado=" + estado + '}';
    }
    
    
    
    
}
