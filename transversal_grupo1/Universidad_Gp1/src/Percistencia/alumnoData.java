/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Percistencia;

import Modelo.alumno;
import Modelo.myConexion;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class alumnoData {

    private final Connection conn;

    public alumnoData() {
        conn = myConexion.buscarConexion();
    }

    public void guardarAlumno(alumno a){
        String query = "INSERT INTO alumno(dni, apellido, nombre, fechaNacimiento, estado)"
                + " VALUES(?,?,?,?,?)";

        try {
             PreparedStatement ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);                 
                ps.setInt(1, a.getDni());
                ps.setString(2, a.getApellido());
                ps.setString(3, a.getNombre());
                ps.setDate(4,  Date.valueOf(a.getFechaNacimiento()));
                ps.setInt(5, a.getEstado());
                
                ps.executeUpdate();
                
                ResultSet rs = ps.getGeneratedKeys();
                
                if (rs.next()) {
                    a.setIdAlumno(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Alumno Guardado Exitosamente");
                } else {
                    System.out.println("No se pudo obtener ID");
                }
                ps.close();
            System.out.println("Guardado");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
    
    public void actualizarAlumno(alumno a){
            
            String query = "UPDATE alumno SET dni= ?, apellido = ?, nombre = ?, fechaNacimiento = ?, estado = ? "
                    + "WHERE idAlumno = ?";
            
        try {
            PreparedStatement ps= conn.prepareStatement(query);
            
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, Date.valueOf(a.getFechaNacimiento()));
            ps.setInt(5, a.getEstado());
            ps.setInt(6, a.getIdAlumno());
            
            int actualizado = ps.executeUpdate();
            
            if(actualizado == 1){
                JOptionPane.showMessageDialog(null, "Datos del alumno actualizado correctamente");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
    
    public alumno buscarAlumnonDni(int dni){
        
        String query = "SELECT * From alumno WHERE dni = ? ";
        alumno  alu= null;
        
        try{
            
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setInt(1, dni);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                alu = new alumno();
                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setEstado(rs.getInt("estado"));
            }else{
                JOptionPane.showMessageDialog(null,"no se encontro un alumno con dni : "+dni);
            }
            ps.close();
            
        }catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Error al buscar el alumno por dni ");
        }
        return alu;
    }
    
    
    public List<alumno> listarAlumnosActivos(){
        String query = "SELECT * FROM alumno";
        List <alumno> alumnos= new ArrayList<>();
        
        
        try{
            
            PreparedStatement ps= conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                
                alumno alu = new alumno();
                
                alu = new alumno();
                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setEstado(rs.getInt("estado"));
                
                alumnos.add(alu);
                
                
                
            }
            
            ps.close();
            
        }catch(Exception ex){
            
             JOptionPane.showMessageDialog(null, "Error al listar alumnos activos ");
        }
        return alumnos;
}
    
    public void darBaja(int idAlumno){
          String query = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
          
          try{
             PreparedStatement ps= conn.prepareStatement(query);
             ps.setInt(1, idAlumno); //Le damos el valor
             int actualisado = ps.executeUpdate(); // Nos da el valor de las filas modificadas
             if(actualisado == 1){
                JOptionPane.showMessageDialog(null, "Alumno dado de baja correctamente");
             }else{
                JOptionPane.showMessageDialog(null, "No se encontro al alumno con ese ID");
             }
             ps.close();
          }catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Error al dar de baja al alumno");
          }
    }
    
    public void darAlta(int idAlumno){
        String query = "UPDATE alumno SET estado = 1 WHERE idAlumno = ?";
        
        try{
             PreparedStatement ps= conn.prepareStatement(query);
             ps.setInt(1, idAlumno); //Le damos el valor
             int actualisado = ps.executeUpdate(); // Nos da el valor de las filas modificadas
             if(actualisado == 1){
                JOptionPane.showMessageDialog(null, "Alumno dado de alta correctamente");
             }else{
                JOptionPane.showMessageDialog(null, "No se encontro al alumno con ese ID");
             }
             ps.close();
          }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Error al dar de alta al alumno");
          }
    }
    public void eliminarAumno (int idAlumno){
        String query  = "DELETE FROM alumno WHERE idAlumno = ? ";
  
            try {
             PreparedStatement  ps = conn.prepareStatement (query);
             ps.setInt(1, idAlumno); 
            int elimina= ps.executeUpdate ();
            if (elimina == 1){
            JOptionPane.showMessageDialog(null, "Alumno eliminado correctamente");
             }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
             }
             ps.close();

           } catch (Exception ex) {
               JOptionPane.showMessageDialog(null, "Error al eliminar al alumno");  
               
             
            }
         
            
        }
}
