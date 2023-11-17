
package g11_pfbomberos.AccesoADatos;

import g11_pfbomberos.entidades.Bombero;
import g11_pfbomberos.entidades.Brigada;
import g11_pfbomberos.entidades.Cuartel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BrigadaData {
  
    private Connection con=null;

    public BrigadaData() {
        con=Conexion.getconexion();
    }

    public void guardarBrigada(Brigada brigada) {
        String sql = "INSERT INTO brigada (codBrigada , brigadaName , especialidad, libre, nro_cuartel) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, brigada.getNombreBr());
            ps.setString(2, brigada.getEspecialidad());
            ps.setBoolean(3, brigada.isLibre());
            ps.setInt(4, brigada.getNroCuartel());
            
            ps.executeUpdate();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Brigada Guardada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }
    }

    public ArrayList<Brigada> listarBrigadas() {
        ArrayList<Brigada> brigadas = new ArrayList<>();
        String sql = "SELECT * FROM brigada";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int codBrigada = rs.getInt("codBrigada");
                String nombreBrigada = rs.getString("brigadaName");
                String especialidad = rs.getString("especialidad");
                boolean libre = rs.getBoolean("libre");
                int nroCuartel = rs.getInt("nro_cuartel");
                
                Brigada brigada = new Brigada(codBrigada, nombreBrigada, especialidad, libre, nroCuartel,libre, nombreBrigada);
                brigadas.add(brigada);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }

        return brigadas;
    }
    
    public Bombero buscarBomberoPorBrigada(int codBrigada) {
    Bombero bombero = null;
    String sql = "SELECT * FROM bombero WHERE codBrigada = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, codBrigada);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            bombero = new Bombero();
            bombero.setIdBombero(rs.getInt("idBombero"));
            bombero.setDni(rs.getString("dni"));
            bombero.setNombreApellido(rs.getString("nombre_ape"));
            bombero.setFechaNacimiento(rs.getDate("fecha_nac"));
            bombero.setCelular(rs.getString("celular"));
            bombero.setCodBrigada(rs.getInt("codBrigada"));
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar bombero por brigada");
    }

    return bombero;
}

public Brigada buscarPorNombreBrigada(String nombreBrigada) {
    Brigada brigada = null;
    String sql = "SELECT * FROM brigada WHERE brigadaName = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreBrigada);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int codBrigada = rs.getInt("codBrigada");
            String especialidad = rs.getString("especialidad");
            boolean libre = rs.getBoolean("libre");
            int nroCuartel = rs.getInt("nro_cuartel");
            
            brigada = new Brigada(codBrigada, nombreBrigada, especialidad, libre, nroCuartel,libre, nombreBrigada);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar brigada por nombre");
    }

    return brigada;
}
public List<Brigada> ObtenerBrigadasNODisponibles() {
        ArrayList<Brigada> brigadas = new ArrayList<>();

        String SQL = "SELECT * FROM brigada WHERE disponibilidad = 0";

        try {
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Brigada brigada = new Brigada();
                Cuartel cuartel = new Cuartel();

                brigada.setCodBrigada(rs.getInt("id_brigada"));
                brigada.setNombreBr(rs.getString("nombre_brigada"));
                brigada.setEspecialidad(rs.getString("especialidad"));
                brigada.setLibre(rs.getBoolean("estado"));
                cuartel.setCodCuartel(rs.getInt("id_cuartel"));
                brigada.setDisponibilidad(rs.getBoolean("disponibilidad"));
                brigada.setNombre_cuartel(rs.getString("nombre_cuartel"));

                brigadas.add(brigada);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada" + ex.getMessage());
        }
        return brigadas;
    }
    public List<Brigada> ObtenerBrigadasDisponibles() {
        ArrayList<Brigada> brigadas = new ArrayList<>();

        String SQL = "SELECT * FROM brigada WHERE disponibilidad = 1";

        try {
            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Brigada brigada = new Brigada();
                Cuartel cuartel = new Cuartel();

                brigada.setCodBrigada(rs.getInt("id_brigada"));
                brigada.setNombreBr(rs.getString("nombre_brigada"));
                brigada.setEspecialidad(rs.getString("especialidad"));
                brigada.setLibre(rs.getBoolean("estado"));
                cuartel.setCodCuartel(rs.getInt("id_cuartel"));
                brigada.setDisponibilidad(rs.getBoolean("disponibilidad"));
                brigada.setNombre_cuartel(rs.getString("nombre_cuartel"));

                brigadas.add(brigada);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada" + ex.getMessage());
        }
        return brigadas;
    }
}
    

