/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Materia;
import Modelo.alumno;

/**
 *
 * @author arceb
 */
public class Inscripcion {
    private int idDescripcion;
    private alumno alumno;
    private Materia mate;
    private double nota;

    public Inscripcion() {
    }

    public Inscripcion(int idDescripcion, alumno alumno, Materia mate, double nota) {
        this.idDescripcion = idDescripcion;
        this.alumno = alumno;
        this.mate = mate;
        this.nota = nota;
    }

    public Inscripcion(double nota, alumno alumno, Materia mate) {
        this.alumno = alumno;
        this.mate = mate;
        this.nota = nota;
    }

    public int getIdDescripcion() {
        return idDescripcion;
    }

    public void setIdDescripcion(int idDescripcion) {
        this.idDescripcion = idDescripcion;
    }

    public alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMate() {
        return mate;
    }

    public void setMate(Materia mate) {
        this.mate = mate;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    
    
    
    
    
}
