package Percistencia;

import Modelo.Materia;
import Modelo.myConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

}
