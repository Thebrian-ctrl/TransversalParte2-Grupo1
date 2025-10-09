package Percistencia;

import Modelo.Materia;
import Modelo.myConexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MateriaData {

    private final Connection conn;

    public MateriaData() {
        this.conn = myConexion.buscarConexion();
    }

    public void guardarMateria(Materia m) {
        // En la base de datos idMateria debe ser autoincrement (por eso no lo coloque en el insert)
        String query = "INSERT INTO materia(nombre, anio, estado) VALUES(?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setInt(3, m.getEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                m.setIdMateria(1);
            } else {
                System.out.println("No se pudo obtener ID");
            }
            ps.close();
            System.out.println("Guardado");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo acceder a la tabla materia");
        }
    }

    public void darBajaMateria(int idMateria) {
        String query = "UPDATE materia SET estado = 0 WHERE idMateria = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idMateria); //Le damos el valor
            int actualisado = ps.executeUpdate(); // Nos da el valor de las filas modificadas
            if (actualisado == 1) {
                JOptionPane.showMessageDialog(null, "Materia dada de baja");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la materia con ese ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la materia");
        }
    }

    public void darAltaMateria(int idMateria) {
        String query = "UPDATE materia SET estado = 1 WHERE idMateria = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idMateria); //Le damos el valor
            int actualisado = ps.executeUpdate(); // Nos da el valor de las filas modificadas
            if (actualisado == 1) {
                JOptionPane.showMessageDialog(null, "Materia dado de alta correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la materia con ese ID");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al dar de alta a la materia");
        }
    }

    public void eliminarMateria(int idMateria) {
        String query = "DELETE FROM materia WHERE idMateria = ? ";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, idMateria);
            int elimina = ps.executeUpdate();
            if (elimina == 1) {
                JOptionPane.showMessageDialog(null, "Materia eliminada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la materia");

        }

    }
    
    public List<Materia> listarMateriaActivos(){
        String query = "SELECT * FROM materia WHERE estado=1";
        List <Materia> listamateria= new ArrayList<>();
        
        
        try{
            
            PreparedStatement ps= conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            
            while(rs.next()){
                
                Materia mate = new Materia();
                
               
                mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                mate.setEstado(rs.getInt("estado"));
                
                listamateria.add(mate);
                
            }
            
            ps.close();
            
        }catch(SQLException ex){
            
             JOptionPane.showMessageDialog(null, "Error al listar alumnos activos ");
        }
        return listamateria;
}
    public void actualizarMateria(Materia m){
            
            String query = "UPDATE materia SET  nombre = ?, anio = ?, estado = ? "
                    + "WHERE idMateria = ?";
            
        try {
            PreparedStatement ps= conn.prepareStatement(query);
            
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnio());
            ps.setInt(3, m.getEstado());
            ps.setInt(4, m.getIdMateria());
            
            
            int actualizado = ps.executeUpdate();
            
            if(actualizado == 1){
                JOptionPane.showMessageDialog(null, "Datos de la materia actualizado correctamente");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia" + ex.getMessage());
        }
    }
    
    public Materia buscarMateria(int idMateria){
        
        String query = "SELECT * From materia WHERE idMateria = ? ";
        Materia mate= null;
        
        try{
            
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setInt(1, idMateria);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                mate = new Materia();
                mate.setIdMateria(rs.getInt("idMateria"));
                mate.setNombre(rs.getString("nombre"));
                mate.setAnio(rs.getInt("anio"));
                mate.setEstado(rs.getInt("estado"));
            }else{
                JOptionPane.showMessageDialog(null,"no se encontro la materia : "+idMateria);
            }
            ps.close();
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Error al buscar el alumno por dni ");
        }
        return mate;
    }

}
