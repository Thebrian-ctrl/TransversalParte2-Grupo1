/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Percistencia;

import Modelo.Inscripcion;
import Modelo.Materia;
import Modelo.myConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author arceb
 */
public class InscripcionData {
    private Connection conn = null;

    public InscripcionData() {
        conn= myConexion.buscarConexion();
    }
    
    public void guardarInscripcion(Inscripcion i){
        String query = "INSERT INTO inscripcion (nota, idAlumno, idMateria) "
                + "values (?, ?, ?)";
        try {
           PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
               ps.setDouble(1, i.getNota());
               ps.setInt(2, i.getAlumno().getIdAlumno());
               ps.setInt(3, i.getMate().getIdMateria());
               
               ps.executeUpdate();
               
               ResultSet rs = ps.getGeneratedKeys();
                    
                if(rs.next()){
                    i.setIdDescripcion(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Inscripcion realizada correctamente");
                
                }
               
                    ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
            
        }
        
    
    
    }
    public void anularInscripcion(int idAlumno, int idMateria){
        String query = "DELETE FROM inscripcion WHERE idAlumno = ? and idMateria = ?";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            int elimina = ps.executeUpdate();
            if (elimina > 0) {
                JOptionPane.showMessageDialog(null, "Inscripcion anulada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo anular");
            }
            ps.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error al anular la inscripcion" + e.getMessage());
        }
    
    
    }
    
    
    public List<Materia> listaMateriasInscriptas(int idAlumno){
        List<Materia> materias = new ArrayList<>();
        
        String query = "SELECT m.idMateria, m.nombre, m.anio, m.estado FROM materia m JOIN inscripcion i ON m.idMateria = i.idMateria WHERE i.idAlumno = ?";
        
        try {
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idAlumno);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Materia m = new Materia();
                
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getInt("estado"));
                
                materias.add(m);
            
            
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el listado de materias" + e.getMessage());
            
        }
        
        return materias;
    }
    
    public List<Materia> listaMateriasNoInscriptas(int idAlumno){
        List<Materia> materias = new ArrayList<>();
        
        String query = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?) AND estado = 1";
        
        try {
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idAlumno);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Materia m = new Materia();
                
                m.setIdMateria(rs.getInt("idMateria"));
                m.setNombre(rs.getString("nombre"));
                m.setAnio(rs.getInt("anio"));
                m.setEstado(rs.getInt("estado"));
                
                materias.add(m);
            
            
            }
            ps.close();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el listado de las materias no inscriptas.");
            
        }
    
    
    return materias;
    }
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno){
        List <Inscripcion> inscripciones = new ArrayList<>();
        String query =" SELECT i.idInscripto, i.nota, m.idMateria, m.nombre, m.anio, m.estado FROM inscripcion i JOIN materia m ON i.idMateria = m.idMateria WHERE i.idAlumno=?";
        
        
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idAlumno);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
             
                
                //creamos nuestra inscripcion
                Inscripcion ins= new Inscripcion();
                
                //valores q necesitamos de nuestra isncripcion
                ins.setIdDescripcion(rs.getInt("idInscripto"));
                ins.setNota(rs.getDouble("nota"));
                
                
                //creamos nuestra materia 
                
                Materia materia= new Materia();
                
                
                //le damos valores a la materia 
                
                
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnio(rs.getInt("anio"));
                materia.setEstado(rs.getInt("estado"));
                
                
                
                
                // asignamos la materia a la inscrripcion
                
                ins.setMate(materia);
                
                inscripciones.add(ins);
                
                
            }
            ps.close();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al botener las inscripciones.....");
            
        }
        return inscripciones;
    }
    
    
    
    
    public void actualizarNota (int idAlumno, int idMateria, double nota){
        String quary = "UPDATE inscripcion SET nota= ? WHERE idAlumno= ? AND idMateria= ?";
        
        try{
            PreparedStatement ps = conn.prepareStatement(quary);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            System.out.println("Ejecutando: " + ps.toString()); // <-- debug en consola
            
            int exito = ps.executeUpdate();
            
            if(exito >0){
              //  JOptionPane.showMessageDialog(null,"nota actualizada correctamente");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al actualizar la nota");
            
        }
    }
    
}
